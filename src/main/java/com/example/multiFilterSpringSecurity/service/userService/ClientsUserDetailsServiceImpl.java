package com.example.multiFilterSpringSecurity.service.userService;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientsUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Authentication For Client User");
        // Dummy client user with "client" role
        if ("clientuser".equals(username)) {
            return User.withUsername("clientuser")
                    .password("{noop}client123") // {noop} is a NoOpPasswordEncoder for simplicity
                    .roles("CLIENT")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}