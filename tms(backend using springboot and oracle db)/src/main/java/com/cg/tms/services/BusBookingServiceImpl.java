package com.cg.tms.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.BusBooking;
import com.cg.tms.repositories.IBusBookingRepository;

/**
 * 
 * Class to implement CRUD operations from IBusBookingRepository
 * 
 */
@Service
public class BusBookingServiceImpl implements IBusBookingService {

	@Autowired
	private IBusBookingRepository busBookingRepository;

	@Autowired
	BusServiceImpl busServiceImpl;

	/**
	 * to Store BusBooking in Database
	 * 
	 * @param busBooking
	 * @return BusBooking which is stored
	 */
	public BusBooking addBusBooking(BusBooking busBooking) {
		if (!PaymentService.isPaymentDone().equals("Payment Successfully Done !!, Booking confirmed")) {
			// redirect to payment failed page
		}

		// below statements will update current empty seats in Bus
		busBooking.getBus().setCurrentEmptySeat(busBooking.getBus().getCurrentEmptySeat() - busBooking.getNoOfPass());
		busServiceImpl.updateBus(busBooking.getBus());

		busBooking.setDep(busBooking.getBus().getDep());
		busBooking.setArr(busBooking.getBus().getArr());

		// below statements will calculate Amount of Ticket
		busBooking.setAmount(busBooking.getBus().getAmount() * busBooking.getNoOfPass());
		return busBookingRepository.save(busBooking);
	}

	/**
	 * to get All BusBooking from Database
	 * 
	 * @return List of BusBooking of All BusBookings
	 */
	public List<BusBooking> getAllBusBookings() {
		return busBookingRepository.findAll();
	}

	/**
	 * to update bus booking in database
	 * 
	 * @param busBooking of BusBooking type
	 * @return updated BusBooking
	 */
	public BusBooking updateBusBooking(BusBooking busBooking) {
		return busBookingRepository.save(busBooking);
	}

	/**
	 * to delete bus booking in database
	 * 
	 * @param id of integer type
	 * @return message after deletion
	 */
	public String deleteBusBooking(int id) {
		// below statements will update current empty seats in Bus

		Optional<BusBooking> busBookingOpt = busBookingRepository.findById(id);
		if (!busBookingOpt.isEmpty()) {
			BusBooking busBooing = busBookingOpt.get();
			busBooing.getBus().setCurrentEmptySeat(busBooing.getBus().getCurrentEmptySeat() + busBooing.getNoOfPass());
			busServiceImpl.updateBus(busBooing.getBus());
		}
		busBookingRepository.deleteById(id);
		return "Ticket Deleted !!!";
	}

	/**
	 * to get BusBooking based on BusBooking Id
	 * 
	 * @param id of integer type
	 * @return BusBooking whose Id matches
	 */
	public BusBooking getBusBookingById(int id) {
		return busBookingRepository.findById(id).orElseThrow((NullPointerException::new));
	}

	/**
	 * to get all bus booking based on customer id
	 * 
	 * @param id of type integer
	 * @return List of bus booking whose customer's id matches
	 */
	public List<BusBooking> getBusBookingsByCustomerId(int id) {
		return busBookingRepository.findByCustomerId(id);
	}

	/**
	 * to get all bus booking based on booking date
	 * 
	 * @param bookingDate of LocalDate type
	 * @return List of bus booking whose booking date matches
	 */
	public List<BusBooking> getBusBookingByBookingDate(LocalDate bookingDate) {
		return busBookingRepository.findByBookingDate(bookingDate);
	}

	/**
	 * to get all bus booking based on journey date
	 * 
	 * @param bookingDate of LocalDate type
	 * @return List of bus booking whose journey date matches
	 */
	public List<BusBooking> getBusBookingByJourneyDate(String date) {
		return busBookingRepository.findByJourneyDate(date);
	}
}
