package com.rental.car.converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rental.car.dto.BookingDTO;
import com.rental.car.model.Booking;
import com.rental.car.request.BookingRequest;

@Component("bookingConverter")
public class BookingConverterImpl implements BookingConverter {

	@Autowired
	private CarConverter carConverter;
	
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public Booking convert(BookingDTO bookingDto) throws Exception {
		Booking booking = new Booking();
		Date dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(bookingDto.getStartBooking());
		Date dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(bookingDto.getEndOfBooking());
		
		booking.setIdBooking(bookingDto.getId());
		booking.setStartBooking(dateStart);
		booking.setEndOfBooking(dateEnd);
		booking.setCar(carConverter.convert(bookingDto.getCar()));
		booking.setUser(userConverter.convert(bookingDto.getUser()));
		
		return booking;
	}

	@Override
	public Booking convert(BookingRequest bookingRequest) throws Exception {
		Booking booking = new Booking();
		
		booking.setIdBooking(bookingRequest.getId());
		booking.setStartBooking(bookingRequest.getStartBooking());
		booking.setEndOfBooking(bookingRequest.getEndOfBooking());
		booking.setCar(carConverter.convert(bookingRequest.getCar()));
		booking.setUser(userConverter.convert(bookingRequest.getUser()));
		
		return booking;
	}
	
	@Override
	public List<Booking> convertAll(List<BookingDTO> bookingDto) throws Exception {
		List<Booking> bookings = new ArrayList<Booking>();
		Iterator<BookingDTO> bookDto = bookingDto.iterator();
		
		while(bookDto.hasNext()) {
			BookingDTO result = bookDto.next();
			bookings.add(this.convert(result));
		}
		return bookings;
	}

	@Override
	public BookingDTO reverseConvert(Booking booking) {
		BookingDTO bookDto = new BookingDTO();
		String dateStart = new SimpleDateFormat("dd/MM/yyyy").format(booking.getStartBooking());
		String dateEnd = new SimpleDateFormat("dd/MM/yyyy").format(booking.getEndOfBooking());
		
		bookDto.setId(booking.getIdBooking());
		bookDto.setStartBooking(dateStart);
		bookDto.setEndOfBooking(dateEnd);
		bookDto.setCar(carConverter.reverseConvert(booking.getCar()));
		bookDto.setUser(userConverter.reverseConvert(booking.getUser()));
		
		return bookDto;
	}

	@Override
	public List<BookingDTO> reverseConvertAll(List<Booking> bookings) {
		List<BookingDTO> bookingDto = new ArrayList<>();
		Iterator<Booking> booking = bookings.iterator();
		
		while(booking.hasNext()) {
			Booking result = booking.next();
			bookingDto.add(this.reverseConvert(result));
		}
		return bookingDto;
	}

}