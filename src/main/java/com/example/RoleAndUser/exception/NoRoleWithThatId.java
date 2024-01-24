package com.example.RoleAndUser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoRoleWithThatId extends RuntimeException{

    public NoRoleWithThatId(String message){
        super(message);
    }
}
