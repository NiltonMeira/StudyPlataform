package com.example.backend.exceptions;

public class InvalidEmailException extends ResponseException {
    public InvalidEmailException() {
        super("Your email has a invalid syntax",400);
    }
}
