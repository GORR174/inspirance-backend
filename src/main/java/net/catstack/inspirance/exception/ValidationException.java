package net.catstack.inspirance.exception;

public class ValidationException extends BaseServiceException {
    public ValidationException() {
        super(2, "Invalid request format");
    }
}
