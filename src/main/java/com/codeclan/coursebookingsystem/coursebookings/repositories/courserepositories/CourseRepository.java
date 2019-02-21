package com.codeclan.coursebookingsystem.coursebookings.repositories.courserepositories;

import com.codeclan.coursebookingsystem.coursebookings.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {
}
