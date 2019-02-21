package com.codeclan.coursebookingsystem.coursebookings.controllers;

import com.codeclan.coursebookingsystem.coursebookings.models.Booking;
import com.codeclan.coursebookingsystem.coursebookings.repositories.bookingrepositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "date/{date}")
    public List<Booking> findBookingByDate(@PathVariable String date){
        return bookingRepository.findBookingByDate(date);
    }
}
