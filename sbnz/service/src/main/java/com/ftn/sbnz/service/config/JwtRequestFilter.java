package com.ftn.sbnz.service.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ftn.sbnz.service.services.UserDetailsService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userService;
    @Autowired
    private JwtUtils jwt;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwtToken = jwt.getJwt(request.getHeader("Authorization"));
            if (jwtToken != null) {
                UsernamePasswordAuthenticationToken authToken = getUserCredentials(jwtToken);
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch (Exception e) {
            return;
        }
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getUserCredentials(String jwtToken) {
        String email = jwt.getEmail(jwtToken);
        UserDetails userDetails = userService.findByEmail(email);
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
                null,
                userDetails.getAuthorities());
    }
}
