package com.cg.tms.controller;

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
import com.cg.tms.entities.Hotel;
import com.cg.tms.services.IHotelService;

/**
 * 
 * Controller class for testing HotelServiceImpl
 *
 */
@RestController
@CrossOrigin("*")
public class HotelController {

	@Autowired
	private IHotelService hotelService;

	@PostMapping("/addhotels")
	public ResponseEntity<Hotel> addhotel(@RequestBody Hotel hotel) {
		return new ResponseEntity<Hotel>(hotelService.addHotel(hotel), HttpStatus.OK);
	}

	@GetMapping("/gethotel")
	public List<Hotel> getAllhotel() {
		return hotelService.getAllHotel();
	}

	@PutMapping("/updatehotel")
	public ResponseEntity<Hotel> updateHotelById(@RequestBody Hotel hotel) {
		return new ResponseEntity<>(hotelService.updateHotel(hotel), HttpStatus.OK);
	}

	@DeleteMapping("/deletehotelbyid/{id}")
	public String deleteHotel(@PathVariable int id) {
		return hotelService.delete(id);
	}

	@GetMapping("/gethotelbyid/{id}")
	public Hotel getAllHotels(@PathVariable int id) {
		return hotelService.getHotelById(id);
	}

	@GetMapping("/gethotelsbycity/{city}")
	public List<Hotel> getHotelsByCity(@PathVariable String city) {
		return hotelService.getHotelsByCityName(city);
	}
}
