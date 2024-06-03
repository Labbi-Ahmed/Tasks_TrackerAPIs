package com.labbi.TaskTracker.utility;


import java.util.Base64;

public class InternalService {

    public static String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}
