package com.cg.tms.controller;

import java.time.LocalDate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.cg.tms.entities.HotelBooking;
import com.cg.tms.services.IHotelBookingService;

/**
 * 
 * Controller class for testing HotelBookingServiceImpl
 *
 */
@RestController
@CrossOrigin("*")
public class HotelBookingController {

	@Autowired
	private IHotelBookingService hotelBookingService;

	@PostMapping("/addhotelbooking")
	public ResponseEntity<HotelBooking> addHotelBookingService(@RequestBody HotelBooking hoteBooking) {
		return new ResponseEntity<>(hotelBookingService.addHotelBooking(hoteBooking), HttpStatus.OK);
	}

	@GetMapping("/gethotelbookings")
	public List<HotelBooking> getAllHotelBookings() {
		return hotelBookingService.getAllBookings();
	}

	@PutMapping("/updatehotelbooking")
	public ResponseEntity<HotelBooking> updateHotelBookingService(@RequestBody HotelBooking hoteBooking) {
		return new ResponseEntity<>(hotelBookingService.updateHotelBooking(hoteBooking), HttpStatus.OK);
	}

	@DeleteMapping("/deletehotelbooking/{id}")
	public String deleteHotelBooking(@PathVariable int id) {
		return hotelBookingService.deleteByHotelBookingById(id);
	}

	@GetMapping("/gethotelbookingbyid/{id}")
	public ResponseEntity<HotelBooking> getHotelBookingById(@PathVariable int id) {
		return new ResponseEntity<HotelBooking>(hotelBookingService.getHotelBookingById(id), HttpStatus.OK);
	}

	@GetMapping("/gethotelbookingsbycustomerid/{id}")
	public List<HotelBooking> getHotelBookingsByCustomerId(@PathVariable int id) {
		return hotelBookingService.getHotelBookingsByCustomerId(id);
	}

	@GetMapping("/gethotelbookingsbybookingdate/{bookingDate}")
	public List<HotelBooking> getHotelBookingsByBookingDate(@PathVariable LocalDate bookingDate) {
		return hotelBookingService.getHotelBookingsByBookingDate(bookingDate);
	}
}
