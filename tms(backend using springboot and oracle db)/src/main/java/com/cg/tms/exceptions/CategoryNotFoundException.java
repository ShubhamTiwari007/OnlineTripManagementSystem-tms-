package com.cg.tms.exceptions;

/**
 * Custom Exception class to handle Category related exceptions
 */

public class CategoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7079865084124483764L;

	public CategoryNotFoundException() {

	}

	public CategoryNotFoundException(String message) {
		super(message);
	}
}