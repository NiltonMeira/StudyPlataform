package com.example.backend.controllers;


import com.example.backend.dto.UserCreator;
import com.example.backend.interfaces.UserInterface;

import com.example.backend.model.User;
import com.example.backend.repositories.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController @RequestMapping("/users")
public class UserController {

    @Autowired
    UserInterface service;

    @Autowired
    UserJPARepository repo;

    @PostMapping("")
    public User postUser(@RequestBody UserCreator usercreator)
    {
        User user = service.newUser(usercreator);
        repo.save(user);
        return user;
    }
}