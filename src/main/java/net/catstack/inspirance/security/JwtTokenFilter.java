package net.catstack.inspirance.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.exception.BaseServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            var token = jwtTokenProvider.resolveToken(servletRequest);

            if (token != null && jwtTokenProvider.validateToken(token)) {
                var authentication = jwtTokenProvider.getAuthentication(token);

                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }

            filterChain.doFilter(servletRequest, servletResponse);
        } catch (BaseServiceException e) {
            ObjectMapper mapper = new ObjectMapper();
            servletResponse.setHeader("Content-Type", "application/json");
            servletResponse.getWriter().write(mapper.writeValueAsString(AdapterResponse.fromException(e)));
        }
    }
}
