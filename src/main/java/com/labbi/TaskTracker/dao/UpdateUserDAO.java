package com.labbi.TaskTracker.dao;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
