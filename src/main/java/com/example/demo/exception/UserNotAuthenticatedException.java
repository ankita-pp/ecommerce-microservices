package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotAuthenticatedException extends RuntimeException {
    public UserNotAuthenticatedException(String userId) {
        super("User with id " + userId + " not authenticated!");
    }
}
