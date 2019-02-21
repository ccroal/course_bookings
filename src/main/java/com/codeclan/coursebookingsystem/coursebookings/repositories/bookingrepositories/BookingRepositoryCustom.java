package com.codeclan.coursebookingsystem.coursebookings.repositories.bookingrepositories;

import com.codeclan.coursebookingsystem.coursebookings.models.Booking;

import java.util.List;

public interface BookingRepositoryCustom {

    List<Booking> findBookingByDate(String date);
}
