package com.example.issue_tracker.controller;

import java.util.List; // Added import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.issue_tracker.dto.IssueDTO;
import com.example.issue_tracker.entity.Issue;
import com.example.issue_tracker.service.IssueService;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    // USER REQUIREMENT: Raise an issue
    @PostMapping("/raise")
    @PreAuthorize("hasRole('USER')")
    public Issue createIssue(@RequestBody Issue issue) {
        return issueService.saveIssue(issue);
    }

    // ADMIN REQUIREMENT: Access all issues - Changed return type to IssueDTO
    @GetMapping("/admin/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<IssueDTO> getAllForAdmin() {
        return issueService.getAllIssues();
    }

    // RESOLVER REQUIREMENT: Changed return type to IssueDTO
    @GetMapping("/resolver/{resolverId}")
    @PreAuthorize("hasRole('RESOLVER')")
    public List<IssueDTO> getAssignedIssues(@PathVariable Long resolverId) {
        return issueService.getIssuesByResolver(resolverId);
    }

    // USER REQUIREMENT: Dashboard - Changed return type to IssueDTO
    @GetMapping("/user/my-issues/{userId}")
    @PreAuthorize("hasRole('USER')")
    public List<IssueDTO> getMyIssues(@PathVariable Long userId) {
        return issueService.getIssuesByReporter(userId);
    }
}