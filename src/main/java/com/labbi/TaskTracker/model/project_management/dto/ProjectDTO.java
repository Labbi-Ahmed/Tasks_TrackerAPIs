package com.labbi.TaskTracker.model.project_management.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private Long id;
    private String name;
    private String description;
    private Long owner_id;

}
