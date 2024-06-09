package com.labbi.TaskTracker.model.project_management;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Adjust fetch type based on your requirement
    @JoinColumn(name = "projectId", referencedColumnName = "projectId")
    private Project project;

    @NotBlank
    private String name;
}
