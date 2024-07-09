package com.example.backend.exceptions;

public class ObjectNotFindException extends ResponseException{
    public ObjectNotFindException() {
        super("This email don't exist", 400);
    }
}
