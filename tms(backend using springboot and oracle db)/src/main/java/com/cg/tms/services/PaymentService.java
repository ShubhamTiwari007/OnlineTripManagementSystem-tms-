package com.cg.tms.services;

/**
 * to Handle Payment Gateway
 * 
 * @author Team 6
 *
 */
public class PaymentService {

	static String str = "";

	// private constructor
	private PaymentService() {

	}

	/**
	 * 
	 * @return message after successful payment;
	 */
	public static String isPaymentDone() {
		str = "Payment Successfully Done !!, Booking confirmed";
		return str;
	}
}