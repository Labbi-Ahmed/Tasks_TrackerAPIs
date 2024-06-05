package com.labbi.TaskTracker.repogitory.user_management;

import com.labbi.TaskTracker.model.user_management.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepogitory extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}
