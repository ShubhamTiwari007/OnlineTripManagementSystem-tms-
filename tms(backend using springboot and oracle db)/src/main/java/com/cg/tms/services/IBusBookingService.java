package com.cg.tms.services;

import java.time.LocalDate;
import java.util.List;

import com.cg.tms.entities.BusBooking;

public interface IBusBookingService {

	public BusBooking addBusBooking(BusBooking busBooking);

	public List<BusBooking> getAllBusBookings();

	public BusBooking updateBusBooking(BusBooking busBooking);

	public String deleteBusBooking(int id);

	public BusBooking getBusBookingById(int id);

	public List<BusBooking> getBusBookingsByCustomerId(int id);

	public List<BusBooking> getBusBookingByBookingDate(LocalDate bookingDate);

	public List<BusBooking> getBusBookingByJourneyDate(String date);
}