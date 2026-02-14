package com.example.issue_tracker.controller;

import com.example.issue_tracker.entity.User;
import com.example.issue_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')") // Strict Role-Based Access
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register-user")
    public String registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User/Resolver registered successfully by Admin!";
    }

    @GetMapping("/performance-stats")
    public String getPerformance() {
        // This will connect to your PerformanceDTO logic later
        return "Performance data for Admin analysis";
    }
}