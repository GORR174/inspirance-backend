package net.catstack.inspirance.service.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.domain.dto.response.tasks.themes.GetThemesResponseDTO;
import net.catstack.inspirance.domain.dto.response.tasks.themes.ThemeDTO;
import net.catstack.inspirance.repository.ThemeRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class GetThemesAdapterService {
    private final ThemeRepository repository;

    public GetThemesResponseDTO getThemes() {
        var themes = repository.findAll().stream()
                .map(model -> {
                    var theme = new ThemeDTO();
                    theme.setId(model.getId());
                    theme.setName(model.getName());
                    return theme;
                })
                .collect(Collectors.toList());

        var response = new GetThemesResponseDTO();
        response.setCategories(themes);

        return response;
    }
}
