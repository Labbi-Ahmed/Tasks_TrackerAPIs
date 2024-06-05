package com.labbi.TaskTracker.model.project_management;

import com.labbi.TaskTracker.model.user_management.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userProjectId;



    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Instant createdAt;
    private Instant updatedAt;

    // Getters and setters

    public enum Role {
        DEVELOPER, WORKER
    }
}
