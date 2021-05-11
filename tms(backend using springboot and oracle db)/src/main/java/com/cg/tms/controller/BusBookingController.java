package com.cg.tms.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entities.BusBooking;
import com.cg.tms.services.BusBookingServiceImpl;
import com.cg.tms.services.IBusBookingService;

/**
 * 
 * Controller class for testing BusBookingServiceImpl
 *
 */
@RestController
@CrossOrigin("*")
public class BusBookingController {

	@Autowired
	private IBusBookingService busBookingService;

	@PostMapping("/addbusbooking")
	public ResponseEntity<BusBooking> addBusBooking(@RequestBody BusBooking busBooking) {
		return new ResponseEntity<>(busBookingService.addBusBooking(busBooking), HttpStatus.OK);
	}

	@GetMapping("/getbusbookings")
	public List<BusBooking> getAllBusBookings() {
		return busBookingService.getAllBusBookings();
	}

	@PutMapping("/updatebusbooking")
	public ResponseEntity<BusBooking> updateBusBooking(@RequestBody BusBooking busBooking) {
		return new ResponseEntity<>(busBookingService.updateBusBooking(busBooking), HttpStatus.OK);
	}

	@DeleteMapping("/deletebusbooking/{id}")
	public String deleteBusBookingById(@PathVariable int id) {
		return busBookingService.deleteBusBooking(id);
	}

	@GetMapping("/getbusbookingbyid/{id}")
	public ResponseEntity<BusBooking> getBusBookingById(@PathVariable int id) {
		return new ResponseEntity<>(busBookingService.getBusBookingById(id), HttpStatus.OK);
	}

	@GetMapping("/getbusbookingsbycustomerid/{id}")
	public List<BusBooking> getBusBookingsByCustomerId(@PathVariable int id) {
		return busBookingService.getBusBookingsByCustomerId(id);
	}

	@GetMapping("/getbusbookingbybookingdate/{bookingDate}")
	public List<BusBooking> getBusBookingsByBookingDate(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate bookingDate) {
		return busBookingService.getBusBookingByBookingDate(bookingDate);
	}

	@GetMapping("/getbusbookingbyjourneydate/{journeyDate}")
	public List<BusBooking> getBusBookingsByJourneyDate(@PathVariable String journeyDate) {
		return busBookingService.getBusBookingByJourneyDate(journeyDate);
	}
}
