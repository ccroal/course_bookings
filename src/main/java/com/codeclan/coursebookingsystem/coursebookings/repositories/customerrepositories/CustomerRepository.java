package com.codeclan.coursebookingsystem.coursebookings.repositories.customerrepositories;

import com.codeclan.coursebookingsystem.coursebookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
