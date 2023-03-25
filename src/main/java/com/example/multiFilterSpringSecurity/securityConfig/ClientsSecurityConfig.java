package com.example.multiFilterSpringSecurity.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ClientsSecurityConfig {

    @Autowired
    private DaoAuthenticationProvider clientsAuthenticationProvider;

    @Bean
    @Order(1)
    public SecurityFilterChain clientsSecurityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("registered client Security Filter!");
        http.authenticationProvider(clientsAuthenticationProvider)
                .antMatcher("/api/transport/end-users/clients/**")
                .authorizeRequests()
                .anyRequest()
                .hasRole("CLIENT")
                .and()
                .httpBasic()
                .and()
                .csrf().disable(); // Disabling CSRF protection for simplicity, but should be enabled in production
        return http.build();
    }
}
