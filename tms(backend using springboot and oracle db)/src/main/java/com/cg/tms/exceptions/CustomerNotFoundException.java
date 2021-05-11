package com.cg.tms.exceptions;

/**
 * Custom Exception class to handle Customer related exceptions
 */

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7079865084124483764L;

	public CustomerNotFoundException() {

	}

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
