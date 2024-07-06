package controllers;

import dto.user.UserCreator;
import interfaces.UserInterface;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repositoriess.UserJPARepository;

@RestController
public class UserController {

    @Autowired
    UserInterface service;

    @Autowired
    UserJPARepository repo;



    @PostMapping
    public User postUser(@RequestBody UserCreator usercreator)
    {
        User user = service.newUser(usercreator);
        repo.save(user);
        return user;
    }
}
