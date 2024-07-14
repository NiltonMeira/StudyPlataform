package com.example.backend.controllers;

import com.example.backend.dto.user.UserLoginDto;
import com.example.backend.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("")
    public String login(@RequestBody UserLoginDto user)
    {
        System.out.println("banana");
        return service.doLogin(user) ;
    }
}
