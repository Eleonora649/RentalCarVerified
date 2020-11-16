package com.rental.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.car.dto.BookingDTO;
import com.rental.car.facade.BookingFacade;
import com.rental.car.request.BookingRequest;

@RestController
@RequestMapping(value="/bookings")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {
	
	@Autowired
	private BookingFacade bookingFacade;
	
	@GetMapping("/list-bookings")
	public List<BookingDTO> getAllBookings() {
		List<BookingDTO> bookings = bookingFacade.getAllBookings();
		return bookings;
	}
	
	@GetMapping("/list-bookings/{id}")
	public ResponseEntity<BookingDTO> getBookingById(@PathVariable(value="id") Long id) {
		BookingDTO booking = bookingFacade.getBookingDtoById(id);
		return new ResponseEntity<>(booking, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingRequest bookDto) throws Exception {
		BookingDTO booking = bookingFacade.createBooking(bookDto);
		if(booking==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(booking, HttpStatus.CREATED);
		}
	}

	@PutMapping
	public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO bookingDto) {
		try {
			Long id = bookingDto.getId();
			bookingFacade.updateBooking(id, bookingDto);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		/*if(bookingFacade.updateBooking(bookingDto.getId(), bookingDto) != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}*/
	}
	
	@DeleteMapping("/delete-bookings/{id}")
	public ResponseEntity<HttpStatus> deleteBooking(@PathVariable Long id) {
		bookingFacade.deleteBookingDto(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
