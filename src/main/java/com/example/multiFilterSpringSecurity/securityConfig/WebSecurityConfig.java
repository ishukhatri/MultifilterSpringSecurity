package com.example.multiFilterSpringSecurity.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(4)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DaoAuthenticationProvider apiAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/web/**")
                .authenticationProvider(apiAuthenticationProvider)
                .authorizeRequests()
                .anyRequest()
                .hasRole("APIUSER")
                .and()
                .httpBasic();
    }
}
