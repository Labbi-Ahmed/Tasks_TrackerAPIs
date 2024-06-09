package com.labbi.TaskTracker.utility;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Base64;

public class InternalService {

    public static String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static String getAuthenticatedUser(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String email = authentication.getName();
        System.out.println(email);
        return email;
    }
}
