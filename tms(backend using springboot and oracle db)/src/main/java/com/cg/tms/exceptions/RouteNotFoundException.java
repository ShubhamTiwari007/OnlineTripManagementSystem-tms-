package com.cg.tms.exceptions;

/**
 * Custom Exception class to handle Route related exceptions
 */

public class RouteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7079865084124483764L;

	public RouteNotFoundException() {

	}

	public RouteNotFoundException(String message) {
		super(message);
	}
}
