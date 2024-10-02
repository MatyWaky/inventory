package com.github.matywaky.inventory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().permitAll() // Zezwala na dostęp do wszystkich żądań
                )
                .csrf(csrf -> csrf.disable()); // Możesz wyłączyć CSRF, jeśli to potrzebne

        return http.build();
    }
}