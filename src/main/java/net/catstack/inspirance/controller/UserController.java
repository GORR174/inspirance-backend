package net.catstack.inspirance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.dto.response.GetMyProfileResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = UserController.TAG, description = "Контроллер для взаимодействия с профилями пользователей")
@RequestMapping("/v1/user")
public interface UserController {
    String TAG = "User Controller";

    @Operation(summary = "Возвращает профиль текущего пользователя", tags = TAG)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ")
    })
    @GetMapping("/getMyProfile")
    AdapterResponse<GetMyProfileResponseDTO> getMyProfile();
}
