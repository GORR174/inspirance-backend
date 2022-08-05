package net.catstack.inspirance.domain.dto.response.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RegisterResponseDTO {
    @Schema(example = "User Test successfully registered!")
    private String message;
}
