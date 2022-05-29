package net.catstack.inspirance.security;

import net.catstack.inspirance.domain.model.RoleModel;
import net.catstack.inspirance.domain.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtUserFactory {
    public static JwtUser create(final UserModel userModel) {
        var jwtUser = new JwtUser();

        jwtUser.setId(userModel.getId());
        jwtUser.setUsername(userModel.getUsername());
        jwtUser.setPassword(userModel.getPassword());
        jwtUser.setEmail(userModel.getEmail());
        jwtUser.setFirstName(userModel.getFirstName());
        jwtUser.setAuthorities(mapToGrantedAuthorities(userModel.getRoles()));

        return jwtUser;
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(final Set<RoleModel> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
