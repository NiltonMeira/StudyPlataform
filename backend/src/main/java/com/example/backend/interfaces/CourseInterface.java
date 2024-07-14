package com.example.backend.interfaces;

import com.example.backend.dto.course.CourseCreatorDto;
import com.example.backend.model.Course;

import java.util.List;

public interface CourseInterface {
    List<Course> findByName(String name);
    Course newCourse(CourseCreatorDto courseCreatorDto);
}
