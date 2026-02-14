package com.example.issue_tracker.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "issues")
@Data // This Lombok annotation generates getReporter() and getResolver() automatically
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status = Status.OPEN;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private User reporter; // Must match 'reporter' in repository counts

    @ManyToOne
    @JoinColumn(name = "resolver_id")
    private User resolver; // Must match 'resolver' in repository counts

    private LocalDateTime createdAt = LocalDateTime.now();
}