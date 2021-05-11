package com.cg.tms.services;

import java.util.List;

import com.cg.tms.entities.Route;

public interface IRouteService {

	public Route addRoute(Route route);

	public List<Route> getAllRoute();

	public Route updateRoute(Route route);

	public String delete(int id);

	public Route getRouteById(int id);

	public List<Route> getRouteByFromStation(String name);

	public List<Route> getRouteByToStation(String name);

	public List<Route> getRouteByFromAndToStation(String from, String to);
}