package com.example.backend.controllers;

import com.example.backend.dto.UserLoginDto;
import com.example.backend.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping
    public String login(@RequestParam UserLoginDto user) {
        return service.doLogin(user) ;
    }
}
