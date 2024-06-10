package com.labbi.TaskTracker.repository.project_management;

import com.labbi.TaskTracker.model.project_management.Project;
import com.labbi.TaskTracker.model.user_management.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByOwner(User owner);
//    Project findByOwnerAndId(User owner, Long id);

}
