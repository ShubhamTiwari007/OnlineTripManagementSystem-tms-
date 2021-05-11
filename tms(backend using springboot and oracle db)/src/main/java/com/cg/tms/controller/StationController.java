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

import com.cg.tms.entities.Station;
import com.cg.tms.services.IStationService;

/**
 * 
 * Controller class for testing StationServiceImpl
 *
 */
@RestController
@CrossOrigin("*")
public class StationController {

	@Autowired
	private IStationService stationService;

	@PostMapping("/addstation")
	public ResponseEntity<Station> addStation(@RequestBody Station station) {
		return new ResponseEntity<>(stationService.addSatation(station), HttpStatus.OK);
	}

	@GetMapping("/getstations")
	public List<Station> getAllStations() {
		return stationService.getAllStation();
	}

	@PutMapping("/updatestation")
	public ResponseEntity<Station> updateStation(@RequestBody Station station) {
		return new ResponseEntity<>(stationService.updateStation(station), HttpStatus.OK);
	}

	@DeleteMapping("/deletestationbyid/{id}")
	public String deleteStation(@PathVariable int id) {
		return stationService.deleteById(id);
	}

	@GetMapping("/getstationbyid/{id}")
	public ResponseEntity<Station> getStationById(@PathVariable int id) {
		Station station = stationService.getStationById(id);
		return new ResponseEntity<>(station, HttpStatus.OK);
	}

	@GetMapping("/getstationbycode/{code}")
	public ResponseEntity<Station> getStationByCode(@PathVariable String code) {
		return new ResponseEntity<>(stationService.getStationByCode(code), HttpStatus.OK);
	}

	@GetMapping("/getstationbyname/{name}")
	public ResponseEntity<Station> getStationByName(@PathVariable String name) {
		return new ResponseEntity<>(stationService.getStationByName(name), HttpStatus.OK);
	}
}