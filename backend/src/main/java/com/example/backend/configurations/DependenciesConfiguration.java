package com.example.backend.configurations;

import com.example.backend.interfaces.CourseInterface;
import com.example.backend.interfaces.UserInterface;

import com.example.backend.model.Course;
import com.example.backend.services.DatabaseCourseService;
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

    @Bean (name = "corseBean") @Scope("singleton")@Primary
    public CourseInterface courseService() {
        return new DatabaseCourseService();
    }
}