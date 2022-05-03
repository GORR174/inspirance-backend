package net.catstack.inspirance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.catstack.inspirance.domain.dto.request.LoginRequestDTO;
import net.catstack.inspirance.domain.dto.request.RegisterRequestDTO;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.dto.response.LoginResponseDTO;
import net.catstack.inspirance.domain.dto.response.RegisterResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = AuthenticationController.TAG, description = "Контроллер для авторизации и регистрации пользоватлей")
@RequestMapping("/v1/auth")
public interface AuthenticationController {
    String TAG = "Authentication Controller";

    @Operation(summary = "Создаёт нового пользователя", tags = TAG)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ")
    })
    @PostMapping("/register")
    AdapterResponse<RegisterResponseDTO> register(RegisterRequestDTO requestDTO);

    @Operation(summary = "Авторизирует пользователя. Возвращает токен", tags = TAG)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ")
    })
    @PostMapping("/login")
    AdapterResponse<LoginResponseDTO> login(LoginRequestDTO requestDTO);
}
