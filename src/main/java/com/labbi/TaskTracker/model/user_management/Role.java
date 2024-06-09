package com.labbi.TaskTracker.model.user_management;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Role name is required")
    @NotBlank
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
