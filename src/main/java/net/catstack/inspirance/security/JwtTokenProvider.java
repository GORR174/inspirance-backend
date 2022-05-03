package net.catstack.inspirance.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import net.catstack.inspirance.domain.model.Role;
import net.catstack.inspirance.exception.JwtAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private String secret = "CatInspirance";

    private final UserDetailsService userDetailsService;

    public String createToken(final String username, Set<Role> roles) {
        var claims = Jwts.claims().setSubject(username);
        claims.put("roles", getRoleNames(roles));

        var now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
//                .setExpiration(new Date(Long.MAX_VALUE))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Authentication getAuthentication(final String token) {
        var userDetails = userDetailsService.loadUserByUsername(getUsername(token));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(final String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
        var bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(final String token) {
        try {
            var claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            throw new JwtAuthenticationException("Invalid token");
        }
    }

    private List<String> getRoleNames(Set<Role> userRoles) {
        var result = new ArrayList<String>();

        userRoles.forEach(role -> result.add(role.getName()));

        return result;
    }
}
