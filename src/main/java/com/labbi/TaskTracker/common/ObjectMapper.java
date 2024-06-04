package com.labbi.TaskTracker.common;

import com.labbi.TaskTracker.model.dao.UpdateUserDAO;
import com.labbi.TaskTracker.model.dao.UserDAO;
import com.labbi.TaskTracker.model.User;

import java.time.Instant;

public class ObjectMapper {

    public static User createUserMapper(UserDAO userDAO){
        User user = new User();
        user.setFirstName(userDAO.getFirstName());
        user.setLastName(userDAO.getLastName());
        user.setEmail(userDAO.getEmail());
        user.setAddress(userDAO.getAddress());
        user.setPhone(userDAO.getPhone());
        user.setCity(userDAO.getCity());
        user.setPostcode(userDAO.getPostcode());
        user.setPassword(userDAO.getPassword());
        user.setCreateDate(Instant.now());

        return user;
    }
    public static User updateUserMapper(User user,UpdateUserDAO userDAO){


        if(userDAO.getFirstName() != null)
            user.setFirstName(userDAO.getFirstName());

        if(userDAO.getLastName() != null)
            user.setLastName(userDAO.getLastName());

        if(userDAO.getPhone() != null)
            user.setPhone(userDAO.getPhone());

        if(userDAO.getAddress() != null)
            user.setAddress(userDAO.getAddress());

        if(userDAO.getCity() != null)
            user.setCity(userDAO.getCity());

        if(userDAO.getPostcode() != null)
            user.setPostcode(userDAO.getPostcode());

        if(userDAO.getProfileImage() != null)
            user.setProfileImage(userDAO.getProfileImage());

        user.setUpdateDate(Instant.now());

        return user;
    }


}
