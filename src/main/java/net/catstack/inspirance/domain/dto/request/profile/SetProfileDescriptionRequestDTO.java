package net.catstack.inspirance.domain.dto.request.profile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SetProfileDescriptionRequestDTO {
    @Schema(example = "My awesome profile")
    private String description;
}
