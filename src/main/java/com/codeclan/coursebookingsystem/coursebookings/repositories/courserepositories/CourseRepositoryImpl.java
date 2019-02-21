package com.codeclan.coursebookingsystem.coursebookings.repositories.courserepositories;

import com.codeclan.coursebookingsystem.coursebookings.models.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom {


    @Autowired
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Course> findCoursesByCustomer(Long id) {
        List<Course> results = null;

        Criteria cr = null;

        try{
            Session session = entityManager.unwrap(Session.class);
            cr = session.createCriteria(Course.class);
            cr.createAlias("bookings", "booking" );
            cr.add(Restrictions.eq("booking.customer.id", id));

        }catch (HibernateException e){
            e.printStackTrace();
        }

        results = cr.list();
        return results;
    }
}
