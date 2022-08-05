package net.catstack.inspirance.domain.dto.request.tasks;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class GetTasksRequestDTO {
    @Schema(example = "1")
    private Long themeId;
    @Schema(example = "2")
    private Long categoryId;
    @Schema(example = "4")
    private Long minDays;
    @Schema(example = "20")
    private Long maxDays;
}
