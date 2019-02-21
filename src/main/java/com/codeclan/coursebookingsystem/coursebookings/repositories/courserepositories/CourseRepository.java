package com.codeclan.coursebookingsystem.coursebookings.repositories.courserepositories;

import com.codeclan.coursebookingsystem.coursebookings.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {

    List<Course> findCourseByRating(int rating);
}
