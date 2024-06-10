package com.labbi.TaskTracker.service.project_management;

import com.labbi.TaskTracker.model.project_management.Project;
import com.labbi.TaskTracker.model.project_management.dao.ProjectDAO;
import com.labbi.TaskTracker.model.project_management.dto.OwnerProjectsList;
import com.labbi.TaskTracker.model.project_management.dto.ProjectCreateResponse;
import com.labbi.TaskTracker.model.project_management.dto.ProjectDTO;
import com.labbi.TaskTracker.model.project_management.dto.ProjectResponseDTO;
import com.labbi.TaskTracker.model.user_management.User;
import com.labbi.TaskTracker.repository.project_management.ProjectRepository;
import com.labbi.TaskTracker.repository.project_management.ProjectWorkerRepository;
import com.labbi.TaskTracker.repository.user_management.UserRepogitory;
import com.labbi.TaskTracker.utility.InternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepogitory;
    private final UserRepogitory userRepogitory;
    private final ProjectWorkerRepository userProjectRepository;


    public OwnerProjectsList getAllProjectsByOwner(){
        String email = InternalService.getAuthenticatedUser();
        OwnerProjectsList response = new OwnerProjectsList();

        if(email.isBlank()){
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setProjects(null);
            return response;
        }

        User user = userRepogitory.findByEmail(email);

        if(user == null){
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setProjects(null);
            return response;
        }

       List<Project> projects =  projectRepogitory.findByOwner(user);

        response.setStatus(HttpStatus.OK);
        response.setProjects(projects);
        return response;

    }

    public ProjectResponseDTO getProjectById(Long id){
       String email = InternalService.getAuthenticatedUser();
       ProjectResponseDTO responseDTO = new ProjectResponseDTO();
       if(email.isBlank()){
           responseDTO.setStatus(HttpStatus.NOT_FOUND);
           responseDTO.setProject(null);
           return responseDTO;
       }
        System.out.println("ok");

//       User user = userRepogitory.findByEmail(email);
        Optional<Project> project = null; //findByOwnerAndId(user,id);
        try {
            project = projectRepogitory.findById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());

        }

        if(!project.isPresent()){
           responseDTO.setStatus(HttpStatus.NOT_FOUND);
           responseDTO.setProject(null);
           return responseDTO;
       }

        responseDTO.setStatus(HttpStatus.OK);
        responseDTO.setProject(project.get());
        return responseDTO;

    }


    public ProjectCreateResponse createProject(ProjectDAO dao) {
        String email = InternalService.getAuthenticatedUser();
        ProjectCreateResponse response = new ProjectCreateResponse();

        if(email.isBlank()){
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setProjectDTO(null);
            return response;
        }

        User user  = userRepogitory.findByEmail(email);

        if(user == null){
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setProjectDTO(null);
            return response;
        }

        Project project =new Project();
        project.setProjectName(dao.getName());
        project.setDescription(dao.getDescription());
        project.setOwner(user);
        project.setCreatedAt(Instant.now());

        Project res = projectRepogitory.save(project);

        ProjectDTO projectDTO  = new ProjectDTO(res.getProjectId(),res.getProjectName(),res.getDescription(),res.getOwner().getUserId());

        response.setStatus(HttpStatus.CREATED);
        response.setProjectDTO(projectDTO);
        return response;

    }
}
