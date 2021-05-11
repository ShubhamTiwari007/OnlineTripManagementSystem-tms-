package com.cg.tms.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.HotelBooking;
import com.cg.tms.repositories.IHotelBookingRepository;

/**
 * 
 * Class to implement CRUD operations from IHotelBookingRepository
 * 
 */
@Service
public class HotelBookingServiceImpl implements IHotelBookingService {

	@Autowired
	private IHotelBookingRepository hotelRepository;

	/**
	 * to store Hotel in Database
	 * 
	 * @param hotelBooking of HotelBooking type
	 * @return hotelbooking which is stored
	 */
	public HotelBooking addHotelBooking(HotelBooking hotelBooking) {
		if (!PaymentService.isPaymentDone().equals("Payment Successfully Done !!, Booking confirmed")) {
			// redirect to payment failed page
		}
		hotelBooking.setAmount(hotelBooking.getHotel().getRent() * hotelBooking.getNoOfCustomer());
		return hotelRepository.save(hotelBooking);
	}

	/**
	 * to get all hotelbookings from database
	 * 
	 * @return list of all hotelbookings
	 */
	public List<HotelBooking> getAllBookings() {
		return hotelRepository.findAll();
	}

	/**
	 * to update hotelbooking in database
	 * 
	 * @param hotelBooking
	 * @return update hotelbooking
	 */
	public HotelBooking updateHotelBooking(HotelBooking hotelBooking) {
		return hotelRepository.save(hotelBooking);
	}

	/**
	 * to delete hotelbooking from database
	 * 
	 * @param id of int type
	 * @return message after deletion
	 */
	public String deleteByHotelBookingById(int id) {
		HotelBooking hotelBooking = hotelRepository.findById(id)
				.orElseThrow(() -> new NullPointerException("No Any Booking"));
		hotelRepository.deleteById(hotelBooking.getId());
		return "HotelBooking with id: " + hotelBooking.getId() + " deleted!!";
	}

	public HotelBooking getHotelBookingById(int id) {
		return hotelRepository.findById(id).orElseThrow(() -> new NullPointerException("No Any Booking"));
	}

	/**
	 * to get all hotelbookings based on customer's id
	 * 
	 * @param id of int type
	 * @return list of all hotels whose customer's id matches
	 */
	public List<HotelBooking> getHotelBookingsByCustomerId(int id) {
		return hotelRepository.findAllByCustomerId(id);
	}

	/**
	 * to get all hotelbookings based on booking date
	 * 
	 * @param bookingDate of LocalDate type
	 * @return list of all hotels whose bookingdate matches
	 */
	public List<HotelBooking> getHotelBookingsByBookingDate(LocalDate bookingDate) {
		return hotelRepository.findByBookingDate(bookingDate);
	}

}
