package net.catstack.inspirance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.catstack.inspirance.domain.dto.request.CreateTaskRequestDTO;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.dto.response.CreateTaskResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = TaskController.TAG, description = "Контроллер для взаимодействия с задачами")
@RequestMapping("/v1/task")
public interface TaskController {
    String TAG = "Task Controller";

    @Operation(summary = "Позволяет создать новую задачу", tags = TAG)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ")
    })
    @PostMapping("/createTask")
    AdapterResponse<CreateTaskResponseDTO> createTask(@RequestBody CreateTaskRequestDTO request);
}
