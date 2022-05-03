package net.catstack.inspirance.exception;

public class LoginException extends BaseServiceException {
    public LoginException() {
        super(5, "Wrong username or password");
    }
}
