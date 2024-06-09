package com.labbi.TaskTracker.extra;


import com.labbi.TaskTracker.model.project_management.ProjectRole;
import com.labbi.TaskTracker.model.user_management.Role;
import com.labbi.TaskTracker.repository.project_management.ProjectRoleRepository;
import com.labbi.TaskTracker.repository.user_management.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final ProjectRoleRepository projectRoleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName("USER") == null) {
            Role roleUser = new Role();
            roleUser.setName("USER");
            roleRepository.save(roleUser);
        }

        if (roleRepository.findByName("ADMIN") == null) {
            Role roleAdmin = new Role();
            roleAdmin.setName("ADMIN");
            roleRepository.save(roleAdmin);
        }

        if(projectRoleRepository.findByName("WORKER") == null){
            ProjectRole role = new ProjectRole();
            role.setName("WORKER");
            projectRoleRepository.save(role);
        }

        if(projectRoleRepository.findByName("MANAGER") == null){
            ProjectRole role = new ProjectRole();
            role.setName("MANAGER");
            projectRoleRepository.save(role);
        }
    }
}
