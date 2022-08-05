package net.catstack.inspirance.domain.dto.request.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegisterRequestDTO {
    @Schema(example = "12345678")
    @NotEmpty
    private String password;
    @Schema(example = "Егор")
    @NotEmpty
    private String firstName;
    @Schema(example = "Летов")
    @NotEmpty
    private String lastName;
    @Schema(example = "test@gmail.com")
    @NotEmpty
    private String email;
}
