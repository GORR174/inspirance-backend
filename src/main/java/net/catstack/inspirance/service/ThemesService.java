package net.catstack.inspirance.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.component.enums.Themes;
import net.catstack.inspirance.domain.model.ThemeModel;
import net.catstack.inspirance.repository.ThemeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class ThemesService {
    private final ThemeRepository repository;

    @PostConstruct
    public void init() {
        log.info("Adding themes to DB");
        Arrays.stream(Themes.values())
                .map(Themes::getThemeName)
                .forEach(repository::addIfNotExists);
    }

    public ThemeModel getThemeById(final long id) {
        return repository.getById(id);
    }
}
