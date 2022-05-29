package net.catstack.inspirance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.catstack.inspirance.domain.dto.request.SetProfileDescriptionRequestDTO;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.dto.response.GetMyProfileResponseDTO;
import net.catstack.inspirance.domain.dto.response.SetProfileDescriptionResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Operation(summary = "Устронавливает описание профиля текущего пользователя", tags = TAG)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ")
    })
    @PostMapping("/setDescription")
    AdapterResponse<SetProfileDescriptionResponseDTO> setProfileDescription(@RequestBody SetProfileDescriptionRequestDTO request);
}
