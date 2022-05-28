package net.catstack.inspirance.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catstack.inspirance.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        var user = userService.getByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " doesn't exists");
        }

        var jwtUser = JwtUserFactory.create(user);
        log.info("Load by username: user with username {} successfully loaded", username);

        return jwtUser;
    }
}
