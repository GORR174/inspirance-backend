package net.catstack.inspirance.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.controller.AuthenticationController;
import net.catstack.inspirance.domain.dto.request.LoginRequestDTO;
import net.catstack.inspirance.domain.dto.request.RegisterRequestDTO;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.dto.response.LoginResponseDTO;
import net.catstack.inspirance.domain.dto.response.RegisterResponseDTO;
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
        var user = authenticationService.register(requestDTO);

        var response = new RegisterResponseDTO();
        response.setMessage("User " + user.getUsername() + " successfully registered!");

        return new AdapterResponse<>(response);
    }

    @Override
    public AdapterResponse<LoginResponseDTO> login(@RequestBody LoginRequestDTO requestDTO) {
        return new AdapterResponse<>(authenticationService.loginAndGetToken(requestDTO));
    }
}
