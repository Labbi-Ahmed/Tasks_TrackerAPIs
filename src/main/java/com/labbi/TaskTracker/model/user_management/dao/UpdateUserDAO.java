package com.labbi.TaskTracker.model.user_management.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDAO {
    private String firstName;

    private String lastName;

    private String phone;

    private String address;

    private String city;

    private String postcode;

    private String profileImage;
}
