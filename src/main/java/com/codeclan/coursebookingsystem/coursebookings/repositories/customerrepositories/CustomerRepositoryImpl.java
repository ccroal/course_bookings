package com.codeclan.coursebookingsystem.coursebookings.repositories.customerrepositories;

import com.codeclan.coursebookingsystem.coursebookings.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Customer> findCustomersForCourse(Long id){
        List<Customer> results = null;

        Criteria cr =null;

        try{
            Session session = entityManager.unwrap(Session.class);
            cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.course.id", id ));
        }catch(HibernateException e){
            e.printStackTrace();
        }
        results = cr.list();
        return results;
    }

    @Transactional
    @Override
    public List<Customer> findCustomerTownByCourse(Long id, String town) {
        List<Customer> results = null;

        Criteria cr = null;

        try{
            Session session = entityManager.unwrap(Session.class);
            cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.course.id", id));
            cr.add(Restrictions.eq("town", town));
        } catch (HibernateException e){
            e.printStackTrace();
        }

        results = cr.list();
        return results;
    }

    @Transactional
    @Override
    public List<Customer> findCustomersInTownOverAgeByCourse(Long id, String town, int age) {
        List<Customer> results = null;

        Criteria cr = null;

        try{
            Session session = entityManager.unwrap(Session.class);
            cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.course.id", id));
            cr.add(Restrictions.eq("town", town));
            cr.add(Restrictions.gt("age", age));
        } catch (HibernateException e){
            e.printStackTrace();
        }

        results = cr.list();
        return results;
    }
}
