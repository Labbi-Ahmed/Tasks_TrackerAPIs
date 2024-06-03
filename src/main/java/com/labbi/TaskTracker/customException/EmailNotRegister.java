package com.labbi.TaskTracker.customException;

public class EmailNotRegister extends RuntimeException{

    public EmailNotRegister(String msg){
        super(msg);
    }
}
