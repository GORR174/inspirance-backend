package net.catstack.inspirance.exception;

public class UserAlreadyExistsException extends BaseServiceException {
    public UserAlreadyExistsException(String username) {
        super(4, "User with username '" + username + "' is already exists");
    }
}
