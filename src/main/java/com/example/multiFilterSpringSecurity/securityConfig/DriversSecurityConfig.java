package com.example.multiFilterSpringSecurity.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DriversSecurityConfig {

    @Autowired
    private DaoAuthenticationProvider driversAuthenticationProvider;

    @Bean
    @Order(2)
    public SecurityFilterChain driversSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(driversAuthenticationProvider)
                .antMatcher("/api/transport/end-users/drivers/**")
                .authorizeRequests()
                .anyRequest()
                .hasRole("DRIVER")
                .and()
                .httpBasic();
        return http.build();
    }
}
