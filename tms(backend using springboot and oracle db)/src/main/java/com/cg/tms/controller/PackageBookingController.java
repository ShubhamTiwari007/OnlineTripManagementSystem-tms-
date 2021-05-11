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

import com.cg.tms.entities.PackageBooking;
import com.cg.tms.services.IPackageBookingService;

/**
 * 
 * Controller class for testing PackageBookingServiceImpl
 *
 */
@RestController
@CrossOrigin("*")
public class PackageBookingController {
	@Autowired
	private IPackageBookingService packageBookingService;

	@PostMapping("/addpackagebooking")
	public ResponseEntity<PackageBooking> addPackageBooking(@RequestBody PackageBooking packageBooking) {
		return new ResponseEntity<>(packageBookingService.addPackageBooking(packageBooking), HttpStatus.OK);
	}

	@GetMapping("/getpackagebookings")
	public List<PackageBooking> getAllPackageBookings() {
		return packageBookingService.getAllPackageBookings();
	}

	@PutMapping("/updatepackagebookings")
	public ResponseEntity<PackageBooking> updatePackageBooking(@RequestBody PackageBooking packageBooking) {
		return new ResponseEntity<>(packageBookingService.updatePackageBooking(packageBooking), HttpStatus.OK);
	}

	@DeleteMapping("/deletepackagebooking/{id}")
	public String deleteMapping(@PathVariable int id) {
		return packageBookingService.deletePackageBookingById(id);
	}

	@GetMapping("/getpackagebookingbyid/{id}")
	public ResponseEntity<PackageBooking> getPackageBookingById(@PathVariable int id) {
		return new ResponseEntity<>(packageBookingService.getPackageBookingById(id), HttpStatus.OK);
	}

	@GetMapping("/getpackagebookingbycustomerid/{id}")
	public List<PackageBooking> getPackageBookingByCustomerId(@PathVariable int id) {
		return packageBookingService.getAllPackageBookingsByCustomerId(id);
	}

	@GetMapping("/getpackagebookingbybookingdate/{bookingDate}")
	public List<PackageBooking> getPacakgeBookingByBookingDate(@PathVariable LocalDate bookingDate) {
		return packageBookingService.getAllPackageBookingByBookingDate(bookingDate);
	}
}
