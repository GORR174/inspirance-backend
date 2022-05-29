package net.catstack.inspirance.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.controller.AuthenticationController;
import net.catstack.inspirance.domain.dto.request.auth.LoginRequestDTO;
import net.catstack.inspirance.domain.dto.request.auth.RegisterRequestDTO;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.dto.response.auth.LoginResponseDTO;
import net.catstack.inspirance.domain.dto.response.auth.RegisterResponseDTO;
import net.catstack.inspirance.service.AuthenticationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthenticationControllerImpl implements AuthenticationController {
    private final AuthenticationService authenticationService;

    @Override
    public AdapterResponse<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO requestDTO) {
        log.info("Register User: Register request: Username: {}", requestDTO.getUsername());
        var user = authenticationService.register(requestDTO);

        var response = new RegisterResponseDTO();
        response.setMessage("User " + user.getUsername() + " successfully registered!");

        log.info("Register User: Register response: {}", response);

        return new AdapterResponse<>(response);
    }

    @Override
    public AdapterResponse<LoginResponseDTO> login(@RequestBody LoginRequestDTO requestDTO) {
        log.info("Login User: Trying login with username: {}", requestDTO.getUsername());
        var loginResponse = authenticationService.loginAndGetToken(requestDTO);
        log.info("Login User: User '{}' login successful", requestDTO.getUsername());
        return new AdapterResponse<>(loginResponse);
    }
}
