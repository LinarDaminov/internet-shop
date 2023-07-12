package ru.skypro.homework.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BadCredentialsControllerAdvice {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> badCredentials() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}