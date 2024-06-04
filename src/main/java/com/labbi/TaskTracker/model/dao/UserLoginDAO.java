package com.labbi.TaskTracker.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginDAO {
    private String email;
    private String password;
}
