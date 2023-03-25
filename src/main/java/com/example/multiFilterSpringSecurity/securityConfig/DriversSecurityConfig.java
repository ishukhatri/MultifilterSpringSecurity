package com.example.multiFilterSpringSecurity.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(2)
public class DriversSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DaoAuthenticationProvider driversAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/transport/end-users/drivers/**")
                .authenticationProvider(driversAuthenticationProvider)
                .authorizeRequests()
                .anyRequest()
                .hasRole("DRIVER")
                .and()
                .httpBasic();
    }
}