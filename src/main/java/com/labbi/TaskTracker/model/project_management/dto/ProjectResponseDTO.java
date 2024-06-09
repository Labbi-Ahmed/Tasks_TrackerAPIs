package com.labbi.TaskTracker.model.project_management.dto;

import com.labbi.TaskTracker.model.project_management.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDTO {
    public HttpStatus status;
    Project project;
}
