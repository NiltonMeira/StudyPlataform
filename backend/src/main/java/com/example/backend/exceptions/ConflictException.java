package com.example.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

public class ConflictException extends ResponseException {
    public ConflictException(){

        super("You can't create a user that already exists",400);
    }

}
