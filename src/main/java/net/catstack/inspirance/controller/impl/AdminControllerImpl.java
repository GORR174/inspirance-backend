package net.catstack.inspirance.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.controller.AdminController;
import net.catstack.inspirance.domain.dto.request.tasks.CreateTaskRequestDTO;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.dto.response.tasks.CreateTaskResponseDTO;
import net.catstack.inspirance.service.adapter.CreateTaskAdapterService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AdminControllerImpl implements AdminController {
    private final CreateTaskAdapterService createTaskAdapterService;

    @Override
    public AdapterResponse<CreateTaskResponseDTO> createTask(final CreateTaskRequestDTO request) {
        log.info("Create task request: {}", request);
        final var response = createTaskAdapterService.createTask(request);
        log.info("Create task response: {}", response);

        return new AdapterResponse<>(response);
    }
}
