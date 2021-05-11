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
import com.cg.tms.entities.Bus;
import com.cg.tms.services.BusServiceImpl;
import com.cg.tms.services.IBusService;

/**
 * 
 * Controller class for testing BusServiceImpl
 *
 */
@RestController
@CrossOrigin("*")
public class BusController {

	@Autowired
	private IBusService busService;

	@PostMapping("/addbus")
	public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
		return new ResponseEntity<>(busService.addBus(bus), HttpStatus.OK);
	}

	@GetMapping("/getbuses")
	public List<Bus> getAllBuses() {
		return busService.getAllBus();
	}

	@PutMapping("/updatebus")
	public ResponseEntity<Bus> updateBus(@RequestBody Bus bus) {
		return new ResponseEntity<>(busService.updateBus(bus), HttpStatus.OK);
	}

	@DeleteMapping("/deletebusbyid/{id}")
	public String deleteBus(@PathVariable int id) {
		return busService.delete(id);
	}

	@GetMapping("/getbusbyid/{id}")
	public ResponseEntity<Bus> getBusById(@PathVariable int id) {
		Bus bus = busService.getBusById(id);
		return new ResponseEntity<>(bus, HttpStatus.OK);
	}

	@GetMapping("/getbusbybusnumber/{busnumber}")
	public ResponseEntity<Bus> getBusByBusNumber(@PathVariable String busnumber) {
		return new ResponseEntity<>(busService.getBusByBusNumber(busnumber), HttpStatus.OK);
	}
}
