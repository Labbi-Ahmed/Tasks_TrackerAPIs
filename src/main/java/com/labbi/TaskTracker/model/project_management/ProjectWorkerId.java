package com.labbi.TaskTracker.model.project_management;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectWorkerId implements Serializable {
    private Long projectId;
    private Long userId;





}
