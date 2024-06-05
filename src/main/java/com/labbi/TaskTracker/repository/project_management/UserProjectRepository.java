package com.labbi.TaskTracker.repository.project_management;

import com.labbi.TaskTracker.model.project_management.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProjectRepository extends JpaRepository<UserProject, Long> {
}
