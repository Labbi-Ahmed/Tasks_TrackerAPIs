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
    @JoinColumn(name = "project_id")
    private Project projectWorker;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "worker_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workerProjectRole",referencedColumnName = "id")
    private ProjectRole role;

    private Instant createdAt;
    private Instant updatedAt;

    // Getters and setters
    public enum Role {
         WORKER,MANAGER
    }
}
