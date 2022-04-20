package net.catstack.inspirance.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SendMessageRequestDTO {
    @Schema(example = "Some text")
    private String text;
    @NotEmpty
    @Schema(example = "12.04.2022")
    private String date;
}
