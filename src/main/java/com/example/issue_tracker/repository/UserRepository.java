package com.example.issue_tracker.repository;

import com.example.issue_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Add this line to allow searching by email
    Optional<User> findByEmail(String email); 
}