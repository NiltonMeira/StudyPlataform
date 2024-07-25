package com.example.backend.exceptions;

public class InvalidtokenException extends ResponseException {
    public InvalidtokenException() {
        super("invalid login ", 400);
    }
}
