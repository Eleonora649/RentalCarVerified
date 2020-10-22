package com.rental.car.service;

import java.util.List;

import com.rental.car.model.Booking;


public interface BookingService {
	
	List<Booking> getAllBookings();
	
	Booking getBookingById(Long id);
	
	Booking createBooking(Booking booking);
	
	Booking updateBooking(Long id, Booking booking);
	
	void deleteBooking(Long id);

}
