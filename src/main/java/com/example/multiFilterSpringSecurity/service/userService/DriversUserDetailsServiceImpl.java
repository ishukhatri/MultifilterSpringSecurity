package com.example.multiFilterSpringSecurity.service.userService;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DriversUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Authentication For Driver User");
        if ("driveruser".equals(username)) {
            // Dummy driver user with "driver" role
            return User.withUsername("driveruser")
                    .password("{noop}driver123") // {noop} is a NoOpPasswordEncoder for simplicity
                    .roles("DRIVER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}
