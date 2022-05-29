package net.catstack.inspirance.domain.dto.response.tasks.categories;

import lombok.Data;

import java.util.List;

@Data
public class GetCategoriesResponseDTO {
    private List<CategoryDTO> categories;
}
