package com.rental.car.request;

import java.io.Serializable;
import java.util.Date;

import com.rental.car.dto.CarDTO;
import com.rental.car.dto.UserDTO;

public class BookingRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private Date startBooking;
	private Date endOfBooking;
	private UserDTO user;
	private CarDTO car;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartBooking() {
		return startBooking;
	}
	public void setStartBooking(Date startBooking) {
		this.startBooking = startBooking;
	}
	public Date getEndOfBooking() {
		return endOfBooking;
	}
	public void setEndOfBooking(Date endOfBooking) {
		this.endOfBooking = endOfBooking;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public CarDTO getCar() {
		return car;
	}
	public void setCar(CarDTO car) {
		this.car = car;
	}
	
}
