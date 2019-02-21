package com.codeclan.coursebookingsystem.coursebookings.repositories.bookingrepositories;

import com.codeclan.coursebookingsystem.coursebookings.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {

}
