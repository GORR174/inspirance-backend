package net.catstack.inspirance.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.domain.model.User;
import net.catstack.inspirance.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getByUsername(final String username) {
        log.info("Get by username: Trying to get {} user", username);
        return repository.findByUsername(username);
    }

    public User getById(final Long id) {
        log.info("Get by id: Trying to get user with id: {}", id);
        return repository.getById(id);
    }
}
