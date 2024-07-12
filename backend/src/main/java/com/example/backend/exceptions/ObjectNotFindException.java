package com.example.backend.exceptions;

public class ObjectNotFindException extends ResponseException{
    public ObjectNotFindException() {
        super("This user don't exist", 400);
    }
}
