package net.catstack.inspirance.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.component.enums.Roles;
import net.catstack.inspirance.domain.dto.request.LoginRequestDTO;
import net.catstack.inspirance.domain.dto.request.RegisterRequestDTO;
import net.catstack.inspirance.domain.dto.response.LoginResponseDTO;
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
            var username = requestDTO.getUsername().toLowerCase();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDTO.getPassword()));
            var user = userService.getByUsername(username);

            if (user == null) {
                throw new LoginException();
            }

            var token = jwtTokenProvider.createToken(username, user.getRoles());
            var response = new LoginResponseDTO();
            response.setAccessToken(token);

            return response;
        } catch (BadCredentialsException e) {
            throw new LoginException();
        }
    }

    public UserModel register(final RegisterRequestDTO requestDTO) {
        if (userService.getByUsername(requestDTO.getUsername().toLowerCase()) != null) {
            throw new UserAlreadyExistsException(requestDTO.getUsername());
        }
        var roleUser = roleRepository.findByName(Roles.USER.getRoleName());
        var userRoles = new HashSet<RoleModel>();
        userRoles.add(roleUser);

        var user = new UserModel();
        user.setUsername(requestDTO.getUsername().toLowerCase());
        user.setFirstName(requestDTO.getFirstName());
        user.setEmail(requestDTO.getEmail());

        user.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        user.setRoles(userRoles);

        var registeredUser = repository.save(user);

        log.info("User register: User {} successfully registered", registeredUser.getUsername());

        return registeredUser;
    }
}
