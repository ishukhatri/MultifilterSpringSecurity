package com.example.multiFilterSpringSecurity.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class ClientsSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DaoAuthenticationProvider clientsAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/transport/end-users/clients/**")
                .authenticationProvider(clientsAuthenticationProvider)
                .authorizeRequests()
                .anyRequest()
                .hasRole("CLIENT")
                .and()
                .httpBasic()
                .and()
                .csrf().disable(); // Disabling CSRF protection for simplicity, but should be enabled in production
    }
}
