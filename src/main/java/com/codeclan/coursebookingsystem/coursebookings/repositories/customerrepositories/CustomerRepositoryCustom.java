package com.codeclan.coursebookingsystem.coursebookings.repositories.customerrepositories;

import com.codeclan.coursebookingsystem.coursebookings.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<Customer> findCustomersForCourse(Long id);

    List<Customer> findCustomerTownByCourse(Long id, String town);

    List<Customer> findCustomersInTownOverAgeByCourse(Long id, String town, int age);
}
