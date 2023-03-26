package com.example.multiFilterSpringSecurity.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    // Add necessary dependencies and methods for JWT processing

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("Verifying Auth Header!!");
        String authHeader = request.getHeader("Authorization");

//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            String jwtToken = authHeader.substring(7); // Remove "Bearer " prefix
//
//            // Dummy JWT validation
//            if (isValidJwtToken(jwtToken)) {
//                String username = "apiuser"; // Extract username from JWT token (dummy value in this example)
//                List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("APIUSER"));
//
//                // Create an authentication object with the user details and granted authorities
//                Authentication authentication = new UsernamePasswordAuthenticationToken(username, "{noop}apiuser123", authorities);
//
//                // Set the authentication object in the security context
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }

        String username = "apiuser"; // Extract username from JWT token (dummy value in this example)
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_APIUSER"));

        // Create an authentication object with the user details and granted authorities
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, "{noop}apiuser123", authorities);

        // Set the authentication object in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Continue the filter chain processing
        filterChain.doFilter(request, response);
    }

    private boolean isValidJwtToken(String jwtToken) {
        // Dummy validation: return true if the token contains "valid" (replace with actual JWT validation logic)
        return jwtToken.contains("valid");
    }
}
