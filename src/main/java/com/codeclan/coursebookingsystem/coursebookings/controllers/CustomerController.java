package com.codeclan.coursebookingsystem.coursebookings.controllers;

import com.codeclan.coursebookingsystem.coursebookings.models.Customer;
import com.codeclan.coursebookingsystem.coursebookings.repositories.customerrepositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "course/{id}")
    public List<Customer> findCustomersforCourse(@PathVariable Long id){
        return customerRepository.findCustomersForCourse(id);
    }

    @GetMapping(value = "town/{town}/course/{id}")
    public List<Customer> findCustomersInTownForCourse(@PathVariable Long id, @PathVariable String town){
        return customerRepository.findCustomerTownByCourse(id, town);
    }

    @GetMapping(value = "town/{town}/course/{id}/age/{age}")
    public List<Customer> findCustomersInTownForCourseOverAge(@PathVariable Long id, @PathVariable String town, @PathVariable int age){
        return customerRepository.findCustomersInTownOverAgeByCourse(id, town, age);
    }
}
