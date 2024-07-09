package com.example.backend.exceptions;

public class InvalidtokenException extends ResponseException {
    public InvalidtokenException() {
        super("Was not possible create a JWT Token", 400);
    }
}
