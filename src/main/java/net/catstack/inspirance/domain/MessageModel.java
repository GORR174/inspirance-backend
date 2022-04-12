package net.catstack.inspirance.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MessageModel {
    @Schema(example = "Some text")
    private String text;
    @Schema(example = "12.04.2022")
    private String date;
}
