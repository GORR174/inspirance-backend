package net.catstack.inspirance.repository;

import net.catstack.inspirance.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    UserModel findByEmail(String email);
}
