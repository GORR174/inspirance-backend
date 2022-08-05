package net.catstack.inspirance.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.component.enums.Roles;
import net.catstack.inspirance.domain.dto.request.auth.LoginRequestDTO;
import net.catstack.inspirance.domain.dto.request.auth.RegisterRequestDTO;
import net.catstack.inspirance.domain.dto.response.auth.LoginResponseDTO;
import net.catstack.inspirance.domain.model.RoleModel;
import net.catstack.inspirance.domain.model.UserModel;
import net.catstack.inspirance.exception.LoginException;
import net.catstack.inspirance.exception.UserAlreadyExistsException;
import net.catstack.inspirance.repository.RoleRepository;
import net.catstack.inspirance.repository.UserRepository;
import net.catstack.inspirance.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final UserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginResponseDTO loginAndGetToken(final LoginRequestDTO requestDTO) {
        try {
            var email = requestDTO.getEmail().toLowerCase();
            var user = userService.getByEmail(email);
            if (user == null) {
                throw new LoginException();
            }
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), requestDTO.getPassword()));

            var token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
            var response = new LoginResponseDTO();
            response.setAccessToken(token);

            return response;
        } catch (BadCredentialsException e) {
            throw new LoginException();
        }
    }

    public UserModel register(final RegisterRequestDTO requestDTO) {
        if (userService.getByEmail(requestDTO.getEmail().toLowerCase()) != null) {
            throw new UserAlreadyExistsException(requestDTO.getEmail());
        }
        var roleUser = roleRepository.findByName(Roles.USER.getRoleName());
        var userRoles = new HashSet<RoleModel>();
        userRoles.add(roleUser);

        var user = new UserModel();
        user.setFirstName(requestDTO.getFirstName());
        user.setEmail(requestDTO.getEmail());

        user.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        user.setRoles(userRoles);

        var registeredUser = repository.save(user);
        registeredUser.setUsername("id" + registeredUser.getId());
        registeredUser = repository.save(registeredUser);

        log.info("User register: User {} successfully registered", registeredUser.getUsername());

        return registeredUser;
    }
}
