package com.labbi.TaskTracker.model.dto;

import com.labbi.TaskTracker.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String postcode;
    private String profileImage;



    public UserDTO(User user){
        this.firstname = user.getFirstName();
        this.lastname = user.getLastName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.city = user.getCity();
        this.postcode = user.getPostcode();
        this.profileImage = user.getProfileImage();
    }

}
