package com.labbi.TaskTracker.repository.project_management;

import com.labbi.TaskTracker.model.project_management.ProjectWorker;
import com.labbi.TaskTracker.model.project_management.ProjectWorkerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectWorkerRepository extends JpaRepository<ProjectWorker, ProjectWorkerId> {
}
