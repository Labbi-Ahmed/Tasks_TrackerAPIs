package com.labbi.TaskTracker.repository.project_management;

import com.labbi.TaskTracker.model.project_management.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
