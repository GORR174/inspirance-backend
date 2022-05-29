package net.catstack.inspirance.service.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.domain.dto.response.tasks.categories.CategoryDTO;
import net.catstack.inspirance.domain.dto.response.tasks.categories.GetCategoriesResponseDTO;
import net.catstack.inspirance.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class GetCategoriesAdapterService {
    private final CategoryRepository repository;

    public GetCategoriesResponseDTO getCategories() {
        var categories = repository.findAll().stream()
                .map(model -> {
                    var category = new CategoryDTO();
                    category.setId(model.getId());
                    category.setName(model.getName());
                    return category;
                })
                .collect(Collectors.toList());

        var response = new GetCategoriesResponseDTO();
        response.setCategories(categories);

        return response;
    }
}
