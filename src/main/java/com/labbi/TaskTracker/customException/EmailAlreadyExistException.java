package com.labbi.TaskTracker.customException;

public class EmailAlreadyExistException extends RuntimeException{

    public EmailAlreadyExistException(String msg){
        super(msg);
    }
}
