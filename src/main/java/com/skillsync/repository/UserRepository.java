package com.skillsync.repository;

import com.skillsync.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username or email
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    // Check existence of username and email
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}