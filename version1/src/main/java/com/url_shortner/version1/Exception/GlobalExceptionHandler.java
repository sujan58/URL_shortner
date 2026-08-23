package com.url_shortner.version1.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundHandler.class)
    public ResponseEntity<String> HandleNotFound(String message){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
