package com.example.issue_tracker.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}