package net.catstack.inspirance.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.controller.TaskController;
import net.catstack.inspirance.domain.dto.request.tasks.GetTasksRequestDTO;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.dto.response.tasks.GetTasksResponseDTO;
import net.catstack.inspirance.domain.dto.response.tasks.categories.GetCategoriesResponseDTO;
import net.catstack.inspirance.domain.dto.response.tasks.themes.GetThemesResponseDTO;
import net.catstack.inspirance.service.adapter.GetCategoriesAdapterService;
import net.catstack.inspirance.service.adapter.GetTasksAdapterService;
import net.catstack.inspirance.service.adapter.GetThemesAdapterService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TaskControllerImpl implements TaskController {
    private final GetCategoriesAdapterService getCategoriesAdapterService;
    private final GetThemesAdapterService getThemesAdapterService;
    private final GetTasksAdapterService getTasksAdapterService;

    @Override
    public AdapterResponse<GetCategoriesResponseDTO> getCategories() {
        log.info("Get categories request");
        return new AdapterResponse<>(getCategoriesAdapterService.getCategories());
    }

    @Override
    public AdapterResponse<GetThemesResponseDTO> getThemes() {
        log.info("Get themes request");
        return new AdapterResponse<>(getThemesAdapterService.getThemes());
    }

    @Override
    public AdapterResponse<GetTasksResponseDTO> getTasks(final GetTasksRequestDTO request) {
        log.info("Get tasks request: {}", request);
        var response = getTasksAdapterService.getTasks(request);
        log.info("Get tasks response: find {} tasks", response.getTasks().size());
        return new AdapterResponse<>(response);
    }
}
