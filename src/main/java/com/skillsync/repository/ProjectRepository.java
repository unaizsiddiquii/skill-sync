package com.skillsync.repository;

import com.skillsync.model.entity.Project;
import com.skillsync.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByOwner(User owner);
}