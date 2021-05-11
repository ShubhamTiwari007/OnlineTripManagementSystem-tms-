package com.cg.tms.exceptions;

import java.util.Date;

/**
 * This class is used for printing the error message along with error details
 * and time at which error occurred
 */
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

	// parameterized constructor
	public ErrorDetails(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	// getters setters
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}