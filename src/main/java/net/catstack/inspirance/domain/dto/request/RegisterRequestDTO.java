package net.catstack.inspirance.domain.dto.request;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String username;
    private String password;
    private String firstName;
    private String email;
}
