package net.catstack.inspirance.exception;

public class UserAlreadyExistsException extends BaseServiceException {
    public UserAlreadyExistsException(String email) {
        super(4, "User with email '" + email + "' is already exists");
    }
}
