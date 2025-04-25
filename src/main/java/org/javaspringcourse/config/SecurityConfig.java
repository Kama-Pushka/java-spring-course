package org.javaspringcourse.config;

import org.javaspringcourse.domain.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String[] PUBLIC_URLS = {
            "/public/**"
    };
    private static final String[] ADMIN_URLS = {
            "/admin/**"
    };
    private static final String[] SUPPORT_URLS = {
            "/support/**"
    };

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(c -> c
                        .requestMatchers(PUBLIC_URLS)
                        .permitAll()
                        .requestMatchers(ADMIN_URLS)
                        .hasAuthority(UserRole.ADMIN.name())
                        .requestMatchers(SUPPORT_URLS)
                        .hasAuthority(UserRole.SUPPORT.name()))
                .httpBasic(_ -> {})
                .build();
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        var admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("maozedong"))
                .authorities(UserRole.ADMIN)
                .build();

        var support = User.builder()
                .username("support")
                .password(passwordEncoder.encode("password"))
                .authorities(UserRole.SUPPORT)
                .build();

        return new InMemoryUserDetailsManager(admin, support);
    }
}
