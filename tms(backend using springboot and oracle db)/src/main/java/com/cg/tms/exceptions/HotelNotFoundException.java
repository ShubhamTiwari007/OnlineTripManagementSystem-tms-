package com.cg.tms.exceptions;

/**
 * Custom Exception class to handle Hotel related exceptions
 */

public class HotelNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7079865084124483764L;

	public HotelNotFoundException() {

	}

	public HotelNotFoundException(String message) {
		super(message);
	}
}