package com.example.multiFilterSpringSecurity.service.userService;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApiUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Authentication For Api/Web User");
        if ("apiuser".equals(username)) {
            // Dummy API user with "apiuser" role
            return User.withUsername("apiuser")
                    .password("{noop}apiuser123") // {noop} is a NoOpPasswordEncoder for simplicity
                    .roles("APIUSER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}