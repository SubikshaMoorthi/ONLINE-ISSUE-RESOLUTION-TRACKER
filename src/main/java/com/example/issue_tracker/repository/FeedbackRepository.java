package com.example.issue_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.issue_tracker.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // You can add a method to find feedback by Issue ID if needed
    Feedback findByIssueId(Long issueId);
}