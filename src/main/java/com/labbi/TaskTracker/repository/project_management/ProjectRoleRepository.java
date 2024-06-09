package com.labbi.TaskTracker.repository.project_management;

import com.labbi.TaskTracker.model.project_management.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRoleRepository extends JpaRepository<ProjectRole, Long> {
    ProjectRole findByName(String name);
}
