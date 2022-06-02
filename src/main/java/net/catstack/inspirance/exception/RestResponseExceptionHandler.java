package net.catstack.inspirance.exception;

import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.domain.dto.response.AdapterError;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestResponseExceptionHandler {
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<AdapterResponse> handle(Exception e) {
        e.printStackTrace();
        log.info("Exception: " + e.toString());
        var response = new AdapterResponse<>();

        response.setStatus(1);
        response.setError(new AdapterError(1, "Internal server error: " + e));

        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(value = { BaseServiceException.class })
    public ResponseEntity<AdapterResponse> handle(BaseServiceException e) {
        log.info("Exception: " + e.toString());

        var response = AdapterResponse.fromException(e);

        return ResponseEntity.ok(response);
    }
}
