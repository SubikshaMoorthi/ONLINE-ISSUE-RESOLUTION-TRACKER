package com.example.issue_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceDTO {
    private long totalIssues;
    private long openIssues;
    private long assignedIssues;
    private long ongoingIssues;
    private long resolvedIssues;
    private long closedIssues;
}