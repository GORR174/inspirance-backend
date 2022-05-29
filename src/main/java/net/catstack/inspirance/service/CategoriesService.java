package net.catstack.inspirance.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.component.enums.Categories;
import net.catstack.inspirance.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoriesService {
    private final CategoryRepository repository;

    @PostConstruct
    public void init() {
        log.info("Adding categories to DB");
        Arrays.stream(Categories.values())
                .map(Categories::getCategoryName)
                .forEach(repository::addIfNotExists);
    }
}
