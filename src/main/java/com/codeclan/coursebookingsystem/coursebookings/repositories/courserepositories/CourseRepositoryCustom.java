package com.codeclan.coursebookingsystem.coursebookings.repositories.courserepositories;

import com.codeclan.coursebookingsystem.coursebookings.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {

    List<Course> findCourseByRating(int rating);
}
