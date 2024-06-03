package com.labbi.TaskTracker.repogitory;

import com.labbi.TaskTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepogitory extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}
