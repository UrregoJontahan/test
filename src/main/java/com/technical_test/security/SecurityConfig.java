package com.technical_test.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Desactiva CSRF para facilitar las pruebas, no recomendado en producción
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/**").permitAll() // Permitir acceso a todos los endpoints
                        .anyRequest().authenticated() // Otros endpoints requieren autenticación
                );
        return http.build();
    }
}
