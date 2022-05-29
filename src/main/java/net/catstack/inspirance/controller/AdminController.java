package net.catstack.inspirance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.catstack.inspirance.domain.dto.request.tasks.CreateTaskRequestDTO;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.dto.response.tasks.CreateTaskResponseDTO;
import net.catstack.inspirance.domain.dto.response.tasks.categories.GetCategoriesResponseDTO;
import net.catstack.inspirance.domain.dto.response.tasks.themes.GetThemesResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = AdminController.TAG, description = "Контроллер для выполнения функций администратора")
@RequestMapping("/v1/admin")
public interface AdminController {
    String TAG = "Admin Controller";

    @Operation(summary = "Позволяет создать новую задачу", tags = TAG)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ")
    })
    @PostMapping("/createTask")
    AdapterResponse<CreateTaskResponseDTO> createTask(@RequestBody CreateTaskRequestDTO request);
}
