package com.example.backend.controllers;


import com.example.backend.dto.user.UpdatePasswordDto;
import com.example.backend.dto.user.UserCreatorDto;
import com.example.backend.interfaces.UserInterface;

import com.example.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController @RequestMapping("/users")
public class UserController {

    @Autowired
    UserInterface service;

    @PostMapping("")
    public User postUser(@RequestBody UserCreatorDto usercreator)
    {
        return service.newUser(usercreator);
    }

    @PatchMapping("/password")
    public  String changePassword(@RequestBody UpdatePasswordDto updatepassword, @RequestHeader("token") String token){
        return service.changePassword(updatepassword, token);
    }
}
