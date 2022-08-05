package net.catstack.inspirance.domain.dto.response.tasks.themes;

import lombok.Data;

import java.util.List;

@Data
public class GetThemesResponseDTO {
    private List<ThemeDTO> categories;
}
