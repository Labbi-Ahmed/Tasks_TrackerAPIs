package com.labbi.TaskTracker.service.project_management;

import com.labbi.TaskTracker.model.project_management.Project;
import com.labbi.TaskTracker.repository.project_management.ProjectRepository;
import com.labbi.TaskTracker.repository.project_management.UserProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepogitory;
    private final UserProjectRepository userProjectRepository;


    public List<Project> getAllProjectS(){
        return projectRepogitory.findAll();
    }

    public Optional<Project> getProjectById(Long id){
        return projectRepogitory.findById(id);
    }

    public List<Project> getProjectByOwnerId(Long id){
        return projectRepogitory.findAll();
    }
}
