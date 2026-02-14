package com.example.issue_tracker.dto;

import com.example.issue_tracker.entity.Status;

import lombok.Data;

@Data
public class IssueDTO {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private String reporterName;
    private String resolverName;
}