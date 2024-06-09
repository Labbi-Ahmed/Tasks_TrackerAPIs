package com.labbi.TaskTracker.model.project_management;

import com.labbi.TaskTracker.model.user_management.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userProjectRole")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProjectRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private ProjectRole projectRole;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "pro_id")
    private Project project;

}
