package com.labbi.TaskTracker.model.project_management.dto;

import com.labbi.TaskTracker.model.project_management.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerProjectsList {

    public HttpStatus status;
    public List<Project> projects;
}
