package net.catstack.inspirance.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.domain.model.UserModel;
import net.catstack.inspirance.repository.UserRepository;
import net.catstack.inspirance.security.JwtUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository repository;

    public List<UserModel> getAll() {
        return repository.findAll();
    }

    public UserModel getByUsername(final String username) {
        log.info("Get by username: Trying to get {} user", username);
        return repository.findByUsername(username);
    }

    public UserModel getByEmail(final String email) {
        log.info("Get by email: Trying to get user with email: {}", email);
        return repository.findByEmail(email);
    }

    public UserModel getById(final Long id) {
        log.info("Get by id: Trying to get user with id: {}", id);
        return repository.getById(id);
    }

    public UserModel getCurrentUser() {
        log.info("Get current user: Trying to get current user...");
        var jwtUser = ((JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        log.info("Get jwtUser: {}", jwtUser.getUsername());
        var user = getByUsername(jwtUser.getUsername());
        log.info("Get user '{}' from DB", user.getUsername());
        return user;
    }

    public UserModel saveUserModel(final UserModel userModel) {
        log.info("Saving user `{}` model to DB", userModel.getUsername());
        return repository.save(userModel);
    }
}
