package com.codeclan.coursebookingsystem.coursebookings.controllers;

import com.codeclan.coursebookingsystem.coursebookings.models.Course;
import com.codeclan.coursebookingsystem.coursebookings.repositories.courserepositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "rating/{rating}")
    public List<Course> findCoursesByRating(@PathVariable int rating){
        return courseRepository.findCourseByRating(rating);
    }
}
