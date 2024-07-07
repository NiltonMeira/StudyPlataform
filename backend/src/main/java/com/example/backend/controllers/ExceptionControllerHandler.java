package com.example.backend.controllers;


import com.example.backend.exceptions.ResponseException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class    ExceptionControllerHandler {
    public record Message (String message){}

    public ResponseEntity<Message> responseError(ResponseException ex, HttpServletRequest request){
        return ResponseEntity
                .status(ex.getStatusCode())
                .body(new Message(ex.getMessage()));
    }
}
