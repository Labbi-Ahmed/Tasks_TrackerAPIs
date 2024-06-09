package com.labbi.TaskTracker.repository.project_management;

import com.labbi.TaskTracker.model.project_management.Project;
import com.labbi.TaskTracker.model.project_management.UserProjectRole;
import com.labbi.TaskTracker.model.user_management.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProjectRoleRepository extends JpaRepository<UserProjectRole, Long> {
    UserProjectRole findByUserAndProject(User user, Project project);
}
