package net.catstack.inspirance.domain.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.catstack.inspirance.exception.BaseServiceException;

@Data
@NoArgsConstructor
public class AdapterResponse<T> {
    private int status;
    private AdapterError error;
    private T response;

    public AdapterResponse(T response) {
        this.response = response;
    }

    public static AdapterResponse<Object> fromException(BaseServiceException exception) {
        var response = new AdapterResponse<>();

        response.setStatus(1);
        response.setError(new AdapterError(exception.getCode(), exception.getMessage()));

        return response;
    }
}
