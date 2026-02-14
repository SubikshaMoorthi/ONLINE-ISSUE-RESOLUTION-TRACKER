package com.example.issue_tracker.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "feedbacks")
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "issue_id", nullable = false)
    private Issue issue;

    @Column(nullable = false)
    private int rating; // e.g., 1 to 5

    @Column(columnDefinition = "TEXT")
    private String comment;

    private LocalDateTime createdAt = LocalDateTime.now();
}