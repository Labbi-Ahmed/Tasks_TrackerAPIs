package com.labbi.TaskTracker.repogitory.user_management;

import com.labbi.TaskTracker.model.user_management.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String user);
}
