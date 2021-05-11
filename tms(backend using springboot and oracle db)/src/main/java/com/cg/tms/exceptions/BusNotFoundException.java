package com.cg.tms.exceptions;

/**
 * Custom Exception class to handle Bus related exceptions
 */
public class BusNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -751417530479271921L;

	public BusNotFoundException() {

	}

	public BusNotFoundException(String message) {
		super(message);
	}
}
