package com.rental.car.exception;

public class DuplicateException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public DuplicateException() {
		super();
	}

	public DuplicateException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}