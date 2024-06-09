package com.labbi.TaskTracker.model.project_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectCreateResponse {
     ProjectDTO projectDTO;
     HttpStatus status;
}
