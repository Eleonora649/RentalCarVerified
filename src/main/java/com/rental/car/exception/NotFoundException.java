package com.rental.car.exception;

public class NotFoundException extends Exception{

	private static final long serialVersionUID = 106854245652969952L;
	
	private String message = "Search item not found";

	public NotFoundException(String Message) {
		super(Message);
		this.message = Message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}