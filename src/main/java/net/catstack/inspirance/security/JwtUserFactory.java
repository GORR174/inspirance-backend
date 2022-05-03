package net.catstack.inspirance.security;

import net.catstack.inspirance.domain.model.Role;
import net.catstack.inspirance.domain.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtUserFactory {
    public static JwtUser create(final User user) {
        var jwtUser = new JwtUser();

        jwtUser.setId(user.getId());
        jwtUser.setUsername(user.getUsername());
        jwtUser.setPassword(user.getPassword());
        jwtUser.setEmail(user.getEmail());
        jwtUser.setFirstName(user.getFirstName());
        jwtUser.setAuthorities(mapToGrantedAuthorities(user.getRoles()));

        return jwtUser;
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(final Set<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
