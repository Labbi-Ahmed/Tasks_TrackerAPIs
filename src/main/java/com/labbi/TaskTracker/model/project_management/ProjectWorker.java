package com.labbi.TaskTracker.model.project_management;

import com.labbi.TaskTracker.model.user_management.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "project_worker")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectWorker {

    @EmbeddedId
    private ProjectWorkerId projectWorkerId;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "projectId")
    private Project project_worker;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "userId")
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
