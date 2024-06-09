package com.labbi.TaskTracker.model.project_management;


import com.labbi.TaskTracker.model.user_management.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private String projectName;
    private String description;
//    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User owner;

    @OneToMany(mappedBy = "project_worker")
    private Set<ProjectWorker> userProjects = new HashSet<>();

    // Getters and setters
}

