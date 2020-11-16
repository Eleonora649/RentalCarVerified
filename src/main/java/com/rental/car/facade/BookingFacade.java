package com.rental.car.facade;

import java.util.List;

import com.rental.car.dto.BookingDTO;
import com.rental.car.request.BookingRequest;

public interface BookingFacade {
	
	BookingDTO getBookingDtoById(Long id);
	
	List<BookingDTO> getAllBookings();
	
	BookingDTO createBooking(BookingRequest bookRequest) throws Exception;
	
	BookingDTO updateBooking(Long id, BookingDTO bookDto) throws Exception;

	void deleteBookingDto(Long id);

}
