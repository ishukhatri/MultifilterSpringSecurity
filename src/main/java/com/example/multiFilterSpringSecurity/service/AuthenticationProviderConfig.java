package com.example.multiFilterSpringSecurity.service;

import com.example.multiFilterSpringSecurity.service.userService.ApiUserDetailsServiceImpl;
import com.example.multiFilterSpringSecurity.service.userService.ClientsUserDetailsServiceImpl;
import com.example.multiFilterSpringSecurity.service.userService.DriversUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class AuthenticationProviderConfig {

    @Autowired
    private ClientsUserDetailsServiceImpl clientsUserDetailsService;

    @Autowired
    private DriversUserDetailsServiceImpl driversUserDetailsService;

    @Autowired
    private ApiUserDetailsServiceImpl apiUserDetailsService;

    @Bean
    public DaoAuthenticationProvider clientsAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(clientsUserDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

    @Bean
    public DaoAuthenticationProvider driversAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(driversUserDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

    @Bean
    public DaoAuthenticationProvider apiAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(apiUserDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }
}