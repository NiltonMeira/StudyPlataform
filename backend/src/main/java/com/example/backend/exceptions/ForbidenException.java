package com.example.backend.exceptions;

public class ForbidenException extends ResponseException{
    public ForbidenException() {
        super("You dont have authorization to do that", 403);
    }
}
