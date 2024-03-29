package net.catstack.inspirance.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import net.catstack.inspirance.component.enums.Roles;
import net.catstack.inspirance.domain.dto.response.AdapterResponse;
import net.catstack.inspirance.exception.JwtAuthenticationException;
import net.catstack.inspirance.security.JwtConfigurer;
import net.catstack.inspirance.security.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenProvider jwtTokenProvider;

    private static final String ADMIN_ENDPOINT = "/v1/admin/**";
    private static final String LOGIN_ENDPOINT = "/v1/auth/login";
    private static final String CATEGORIES_ENDPOINT = "/v1/task/getCategories";
    private static final String THEMES_ENDPOINT = "/v1/task/getThemes";
    private static final String REGISTER_ENDPOINT = "/v1/auth/register";

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                    .antMatchers("/v2/api-docs",
                            "/configuration/ui",
                            "/swagger-resources/**",
                            "/configuration/security",
                            "/swagger-ui/**",
                            "/webjars/**").permitAll()
                    .antMatchers("/actuator/**").permitAll()
                    .antMatchers(LOGIN_ENDPOINT, REGISTER_ENDPOINT).permitAll()
                    .antMatchers(CATEGORIES_ENDPOINT, THEMES_ENDPOINT).permitAll()
                    .antMatchers(ADMIN_ENDPOINT).hasAuthority(Roles.ADMIN.getRoleName())
                .anyRequest()
                    .authenticated()
                    .and()
                .exceptionHandling()
                    .authenticationEntryPoint((httpServletRequest, httpServletResponse, e) -> {
                        var mapper = new ObjectMapper();
                        httpServletResponse.setHeader("Content-Type", "application/json");
                        var exception = new JwtAuthenticationException("Unauthorized");
                        httpServletResponse.getWriter().write(mapper.writeValueAsString(AdapterResponse.fromException(exception)));
                    })
                .accessDeniedHandler((httpServletRequest, httpServletResponse, e) -> {
                    var mapper = new ObjectMapper();
                    httpServletResponse.setHeader("Content-Type", "application/json");
                    var exception = new JwtAuthenticationException("Forbidden");
                    httpServletResponse.getWriter().write(mapper.writeValueAsString(AdapterResponse.fromException(exception)));
                })
                    .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}
