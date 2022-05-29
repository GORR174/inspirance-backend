package net.catstack.inspirance.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.component.enums.Roles;
import net.catstack.inspirance.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class RolesService {
    private final RoleRepository repository;

    @PostConstruct
    public void init() {
        log.info("Adding roles to DB");
        Arrays.stream(Roles.values())
                .map(Roles::getRoleName)
                .forEach(repository::addIfNotExists);
    }
}
