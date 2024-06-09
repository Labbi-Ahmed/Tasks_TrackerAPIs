package com.labbi.TaskTracker.controller.project_management;


import com.labbi.TaskTracker.model.project_management.dao.ProjectDAO;
import com.labbi.TaskTracker.model.project_management.dto.OwnerProjectsList;
import com.labbi.TaskTracker.model.project_management.Project;
import com.labbi.TaskTracker.model.project_management.dto.ProjectCreateResponse;
import com.labbi.TaskTracker.model.project_management.dto.ProjectDTO;
import com.labbi.TaskTracker.model.project_management.dto.ProjectResponseDTO;
import com.labbi.TaskTracker.service.project_management.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDAO dao){
        ProjectCreateResponse response = projectService.createProject(dao);

        return ResponseEntity.status(response.getStatus()).body(response.getProjectDTO());
    }


    @GetMapping
    public ResponseEntity<List<Project>> getAllProjectByOwner(){
        OwnerProjectsList projects = projectService.getAllProjectsByOwner();
        return ResponseEntity.status(projects.getStatus()).body(projects.getProjects());
    }

    @GetMapping("{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long projectId){
        ProjectResponseDTO dto = projectService.getProjectById(projectId);
        return ResponseEntity.status(dto.getStatus()).body(dto.getProject());
    }



}
