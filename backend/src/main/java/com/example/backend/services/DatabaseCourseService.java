package com.example.backend.services;

import com.example.backend.dto.course.CourseCreatorDto;
import com.example.backend.interfaces.CourseInterface;
import com.example.backend.model.Course;
import com.example.backend.repositories.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DatabaseCourseService implements CourseInterface {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    CourseJpaRepository repo;

    @Override
    public List<Course> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Course newCourse(CourseCreatorDto courseCreatorDto) {

        return null;
    }
}
