package com.example.issue_tracker.controller;

import com.example.issue_tracker.dto.AuthRequest;
import com.example.issue_tracker.dto.AuthResponse;
import com.example.issue_tracker.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        // Authenticate the user against the database
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), 
                authRequest.getPassword()
            )
        );

        // If successful, generate a JWT token for the user
        String token = jwtUtils.generateToken(authRequest.getUsername());
        
        return new AuthResponse(token);
    }
}