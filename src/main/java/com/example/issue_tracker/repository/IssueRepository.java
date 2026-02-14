package com.example.issue_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.issue_tracker.entity.Issue;
import com.example.issue_tracker.entity.Status;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    long countByStatus(Status status); // Supports Performance Dashboard
    List<Issue> findByResolverId(Long resolverId); // Supports Resolver Dashboard
}