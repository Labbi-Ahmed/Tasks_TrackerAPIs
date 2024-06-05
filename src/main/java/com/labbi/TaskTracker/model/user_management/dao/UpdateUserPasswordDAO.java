package com.labbi.TaskTracker.model.user_management.dao;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserPasswordDAO {


    @Size(min= 8, max = 64)
    private String oldPassword;

    @Size(min= 8, max = 64)
    private String newPassword;

    @Size(min= 8, max = 64)
    private String newConfirmPassword;
}
