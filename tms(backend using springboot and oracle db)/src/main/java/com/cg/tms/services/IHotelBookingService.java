package com.cg.tms.services;

import java.time.LocalDate;
import java.util.List;

import com.cg.tms.entities.HotelBooking;

public interface IHotelBookingService {

	public HotelBooking addHotelBooking(HotelBooking hotelBooking);

	public List<HotelBooking> getAllBookings();

	public HotelBooking updateHotelBooking(HotelBooking hotelBooking);

	public String deleteByHotelBookingById(int id);

	public HotelBooking getHotelBookingById(int id);

	public List<HotelBooking> getHotelBookingsByCustomerId(int id);

	public List<HotelBooking> getHotelBookingsByBookingDate(LocalDate bookingDate);
}