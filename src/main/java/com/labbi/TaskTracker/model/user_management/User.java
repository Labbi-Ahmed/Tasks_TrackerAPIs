package com.labbi.TaskTracker.model.user_management;

import com.labbi.TaskTracker.model.project_management.Project;
import com.labbi.TaskTracker.model.project_management.UserProject;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email must be provided")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "Phone number is required")
    private String phone;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotEmpty(message = "City is required")
    private String city;

    @NotEmpty(message = "Postcode is required")
    private String postcode;

    @NotEmpty(message = "Password is required")
    @Size(min = 8, message = "Password length must be at least 8 characters")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Project> ownedProjects = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserProject> userProjects = new HashSet<>();

    private Instant createDate;
    private Instant updateDate;

    private boolean active;
    private String profileImage;
}
