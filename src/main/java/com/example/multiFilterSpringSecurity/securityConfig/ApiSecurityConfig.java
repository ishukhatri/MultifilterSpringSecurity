package com.example.multiFilterSpringSecurity.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@Order(3)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DaoAuthenticationProvider apiAuthenticationProvider;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**")
                .authenticationProvider(apiAuthenticationProvider)
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
    }
}