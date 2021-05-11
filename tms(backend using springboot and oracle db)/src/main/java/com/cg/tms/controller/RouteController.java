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

import com.cg.tms.entities.Route;
import com.cg.tms.services.IRouteService;

/**
 * 
 * Controller class for testing RouteServiceImpl
 *
 */
@RestController
@CrossOrigin("*")
public class RouteController {

	@Autowired
	private IRouteService routeService;

	@PostMapping("/addroute")
	public ResponseEntity<Route> addRoute(@RequestBody Route route) {
		return new ResponseEntity(routeService.addRoute(route),HttpStatus.OK);
	}

	@GetMapping("/getroutes")
	public List<Route> getAllRoutesId() {
		return routeService.getAllRoute();
	}

	@GetMapping("/getroutebyid/{id}")
	public ResponseEntity<Route> getRouteById(@PathVariable int id) {
		Route route = routeService.getRouteById(id);
		return new ResponseEntity<>(route, HttpStatus.OK);
	}

	@PutMapping("/updateroute")
	public ResponseEntity<Route> updateRoute(@RequestBody Route route) {
		return new ResponseEntity(routeService.updateRoute(route),HttpStatus.OK);
	}
	@DeleteMapping("/deleteroutebyid/{id}")
	public String deleteRoute(@PathVariable int id) {
		return routeService.delete(id);
	}

	@GetMapping("/getroutebyfromstation/{name}")
	public List<Route> getAllRoutesByfromStation(@PathVariable String name) {
		return routeService.getRouteByFromStation(name);
	}

	@GetMapping("/getroutebytostation/{name}")
	public List<Route> getAllRoutesByToStation(@PathVariable String name) {
		return routeService.getRouteByToStation(name);
	}

	@GetMapping("/getroutebytostation/{from}/{to}")
	public List<Route> getAllRoutesByToStation(@PathVariable String from, @PathVariable String to) {
		return routeService.getRouteByFromAndToStation(from, to);
	}
}