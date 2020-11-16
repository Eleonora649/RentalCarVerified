package com.rental.car.exception;

public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = -8053090608013129747L;
	
	public AuthenticationException(String message,Throwable cause) {
		super(message,cause);
	}
	
}