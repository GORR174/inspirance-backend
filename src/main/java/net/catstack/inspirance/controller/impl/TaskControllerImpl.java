package net.catstack.inspirance.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.controller.TaskController;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.domain.dto.response.tasks.categories.GetCategoriesResponseDTO;
import net.catstack.inspirance.domain.dto.response.tasks.themes.GetThemesResponseDTO;
import net.catstack.inspirance.service.adapter.GetCategoriesAdapterService;
import net.catstack.inspirance.service.adapter.GetThemesAdapterService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TaskControllerImpl implements TaskController {
    private final GetCategoriesAdapterService getCategoriesAdapterService;
    private final GetThemesAdapterService getThemesAdapterService;

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
}
