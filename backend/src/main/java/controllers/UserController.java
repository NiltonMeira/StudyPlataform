package controllers;

import dto.user.UserCreator;
import interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserInterface service;



    @PostMapping
    public String postUser(@RequestBody UserCreator usercreator)
    {
        return "banana";
    }
}
