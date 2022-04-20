package net.catstack.inspirance.exception;

import net.catstack.inspirance.domain.dto.response.AdapterError;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler {
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<AdapterResponse> handle(Exception e) {
        System.out.println("EXCEPTION!");
        var response = new AdapterResponse<>();

        response.setStatus(1);
        response.setError(new AdapterError(1, "Internal server error"));

        return ResponseEntity.ok(response);
    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return ResponseEntity.ok(AdapterResponse.fromException(new ValidationException()));
//    }
}
