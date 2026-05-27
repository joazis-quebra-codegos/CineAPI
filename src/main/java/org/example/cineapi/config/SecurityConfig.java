package org.example.cineapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("swagger-ui/**", "/v3/api-/**").permitAll()
                        .requestMatchers("/filmes").permitAll()
                        .requestMatchers("/filmes/buscar").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic()
                .and()
                .build();
                /*
                desativar o CSRF
                (Cross-Site Request forgery)
                faz a proteção entre sites logados
                 */
    }
}
