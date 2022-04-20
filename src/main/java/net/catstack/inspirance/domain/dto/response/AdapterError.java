package net.catstack.inspirance.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdapterError {
    private int code;
    private String message;
}
