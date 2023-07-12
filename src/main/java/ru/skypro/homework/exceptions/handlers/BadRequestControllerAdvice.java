package ru.skypro.homework.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.skypro.homework.exceptions.IncorrectArgumentException;
import ru.skypro.homework.exceptions.IncorrectUserNameException;

public class BadRequestControllerAdvice {

    @ExceptionHandler(IncorrectUserNameException.class)
    public ResponseEntity<?> incorrectUsername() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(IncorrectArgumentException.class)
    public ResponseEntity<?> incorrectArgument() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}