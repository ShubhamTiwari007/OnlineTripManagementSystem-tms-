package com.cg.tms.exceptions;

/**
 * Custom Exception class to handle Station related exceptions
 */

public class StationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7079865084124483764L;

	public StationNotFoundException() {

	}

	public StationNotFoundException(String message) {
		super(message);
	}
}