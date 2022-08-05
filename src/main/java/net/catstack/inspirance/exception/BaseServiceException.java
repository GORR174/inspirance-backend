package net.catstack.inspirance.exception;

public class BaseServiceException extends RuntimeException {
    private final String message;
    private final int code;

    public BaseServiceException(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
