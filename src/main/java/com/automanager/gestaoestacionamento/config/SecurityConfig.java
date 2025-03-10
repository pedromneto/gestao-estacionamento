package com.automanager.gestaoestacionamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                csrf(csrf -> csrf.disable()) // Desabilita CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "swagger-ui.html"
                        ).permitAll()        // Permite acesso livre ao Swagger
                        .anyRequest().authenticated()  // Protege outras rotas
                )
                .formLogin(form -> form.disable())   // Desabilita formulário de login padrão
                .httpBasic(httpBasic -> httpBasic.disable());
        return http.build();
    }

}
