package com.example.RoleAndUser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ExceptionGlobal {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleexception(ResponseStatusException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no such route here");
    }

    @ExceptionHandler(NoRoleWithThatId.class)
    public ResponseEntity<String> custom(NoRoleWithThatId e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
