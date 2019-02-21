package com.codeclan.coursebookingsystem.coursebookings;

import com.codeclan.coursebookingsystem.coursebookings.models.Booking;
import com.codeclan.coursebookingsystem.coursebookings.models.Course;
import com.codeclan.coursebookingsystem.coursebookings.models.Customer;
import com.codeclan.coursebookingsystem.coursebookings.repositories.bookingrepositories.BookingRepository;
import com.codeclan.coursebookingsystem.coursebookings.repositories.courserepositories.CourseRepository;
import com.codeclan.coursebookingsystem.coursebookings.repositories.customerrepositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursebookingsApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canMakeNewCustomer() {
		Customer customer = new Customer("Steven", "Glasgow", 25);
		customerRepository.save(customer);
		assertEquals(4, customerRepository.count());
	}

	@Test
	public void canMakeNewCourse(){
		Course course = new Course("Learn Python", "Glasgow", 4);
		courseRepository.save(course);
		assertEquals(3, courseRepository.count());
	}

	@Test
	public void canMakeNewBooking() {
		Customer customer = new Customer("Steven", "Glasgow", 25);
		customerRepository.save(customer);

		Course course = new Course("Learn Python", "Glasgow", 4);
		courseRepository.save(course);

		Booking booking = new Booking(course, customer, "21-02-19");
		bookingRepository.save(booking);

		assertEquals(5, bookingRepository.count());

	}

	@Test
	public void canFindCourseByRating() {
		List<Course> result = courseRepository.findCourseByRating(4);
		assertEquals(1, result.size());
	}

	@Test
	public void canFindBookingByDate() {
		List<Booking> result = bookingRepository.findBookingByDate("19-03-19");
		assertEquals(2, result.size());
	}

	@Test
	public void canFindCustomersForCourse() {
		List<Customer> result = customerRepository.findCustomersForCourse(2L);
		assertEquals(2, result.size());
 	}

	@Test
	public void canFindCoursesForCustomer() {
		List<Course> result = courseRepository.findCoursesByCustomer(1L);
		assertEquals(2, result.size());
	}

	@Test
	public void canFindCustomersInCourseByTown() {
		List<Customer> result = customerRepository.findCustomerTownByCourse(1L, "Glasgow");
		assertEquals(2, result.size());
	}

	@Test
	public void canFindCustomersInCourseByTownOverAge() {
		List<Customer> result = customerRepository.findCustomersInTownOverAgeByCourse(1L, "Glasgow", 25);
		assertEquals(1, result.size());
	}
}
