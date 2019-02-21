package com.codeclan.coursebookingsystem.coursebookings.components;

import com.codeclan.coursebookingsystem.coursebookings.models.Booking;
import com.codeclan.coursebookingsystem.coursebookings.models.Course;
import com.codeclan.coursebookingsystem.coursebookings.models.Customer;
import com.codeclan.coursebookingsystem.coursebookings.repositories.bookingrepositories.BookingRepository;
import com.codeclan.coursebookingsystem.coursebookings.repositories.courserepositories.CourseRepository;
import com.codeclan.coursebookingsystem.coursebookings.repositories.customerrepositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.swing.text.EditorKit;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer1 = new Customer("Steven", "Glasgow", 23);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Sarah", "Glasgow", 30);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Lesley", "Edinburgh", 45);
        customerRepository.save(customer3);


        Course course1 = new Course("Learn Python", "Glasgow", 4);
        courseRepository.save(course1);

        Course course2 = new Course("learn Java", "Edinburgh", 3);
        courseRepository.save(course2);

        Booking booking1 = new Booking(course1, customer1, "30/03/19");
        bookingRepository.save(booking1);

        Booking booking2 = new Booking(course1, customer2, "25/04/19");
        bookingRepository.save(booking2);

        Booking booking3 = new Booking(course2, customer3, "19/03/19");
        bookingRepository.save(booking3);

        Booking booking4 = new Booking(course2, customer1, "19/03/19");
        bookingRepository.save(booking4);

    }
}
