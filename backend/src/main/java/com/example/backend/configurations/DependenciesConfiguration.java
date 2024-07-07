package com.example.backend.configurations;

import com.example.backend.interfaces.UserInterface;

import com.example.backend.services.DatabaseUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class DependenciesConfiguration {
    @Bean(name = "userBean") @Scope("singleton")@Primary
    public UserInterface userService() {
        return new DatabaseUserService();
    }
}