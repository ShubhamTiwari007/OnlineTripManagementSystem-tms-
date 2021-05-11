package com.cg.tms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.tms.entities.Route;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repositories.IRouteRepository;

/**
 * 
 * Class to implement CRUD operations from IRouteRepository
 * 
 */
@Service
public class RouteServiceImpl implements IRouteService {

	@Autowired
	private IRouteRepository routeRepository;

	/**
	 * to Create Route in Database
	 * 
	 * @param route of Route type
	 * @return route which is stored
	 */
	public Route addRoute(Route route) {
		return routeRepository.save(route);
	}

	/**
	 * to get All Routes from Database
	 * 
	 * @return List of all Route
	 */
	public List<Route> getAllRoute() {
		return routeRepository.findAll();
	}

	/**
	 * to Update Route in Database
	 * 
	 * @param route of Route type
	 * @return updated Route
	 */
	public Route updateRoute(Route route) {
		return routeRepository.save(route);
	}

	/**
	 * to Delete Route from Database
	 * 
	 * @param id of integer type
	 */
	public String delete(int id) {
		Route route = routeRepository.findById(id)
				.orElseThrow(() -> new RouteNotFoundException("Cannot delete,No route with id: " + id + " found!!"));
		routeRepository.deleteById(route.getId());
		return "Route with id: " + route.getId() + " deleted!!";
	}

	/**
	 * to get Route based on Id
	 * 
	 * @param id of integer type
	 * @return Route whose id matches
	 */
	public Route getRouteById(int id) {
		return routeRepository.findById(id)
				.orElseThrow(() -> new RouteNotFoundException("No route with id: " + id + " found!!"));
	}

	public List<Route> getRouteByFromStation(String name) {
		return routeRepository.findByFromName(name);
	}

	public List<Route> getRouteByToStation(String name) {
		return routeRepository.findByToName(name);
	}

	public List<Route> getRouteByFromAndToStation(String from, String to) {
		return routeRepository.findByFromNameAndToName(from, to);
	}
}