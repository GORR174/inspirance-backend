package net.catstack.inspirance.exception;

public class JwtAuthenticationException extends BaseServiceException {
    public JwtAuthenticationException(String message) {
        super(3, message);
    }
}
