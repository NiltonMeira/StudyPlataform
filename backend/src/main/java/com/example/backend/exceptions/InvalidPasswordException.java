package com.example.backend.exceptions;

public class InvalidPasswordException extends ResponseException{
    public InvalidPasswordException() {
        super("The new password is to weak", 400);
    }
}
