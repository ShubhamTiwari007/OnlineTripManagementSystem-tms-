package com.cg.tms.exceptions;

/**
 * Custom Exception class to handle Package related exceptions
 */

public class PackageNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7079865084124483764L;

	public PackageNotFoundException() {

	}

	public PackageNotFoundException(String message) {
		super(message);
	}
}