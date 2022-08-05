package net.catstack.inspirance.domain.dto.request.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequestDTO {
    @Schema(example = "test@gmail.com")
    @NotEmpty
    private String email;
    @Schema(example = "12345678")
    @NotEmpty
    private String password;
}
