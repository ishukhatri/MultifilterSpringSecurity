package com.example.multiFilterSpringSecurity.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApiSecurityConfig {

    @Autowired
    private DaoAuthenticationProvider apiAuthenticationProvider;

    @Bean
    @Order(3)
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(apiAuthenticationProvider)
                .antMatcher("/api/**")
                .authorizeRequests()
                .anyRequest()
                .hasRole("APIUSER")
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable();
        return http.build();
    }
}
