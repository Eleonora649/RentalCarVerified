package com.rental.car.exception;

import java.util.Date;

public class ErrorResponse {

	private Date date;
	private int code;
	private String message;

	public ErrorResponse() {
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorResponse [date=" + date + ", code=" + code + ", message=" + message + "]";
	}
}