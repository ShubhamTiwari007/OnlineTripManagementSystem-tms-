package com.cg.tms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Route;

public interface IRouteRepository extends JpaRepository<Route, Integer> {

	public Route findRouteById(int id);

	public List<Route> findByFromName(String name);

	public List<Route> findByToName(String name);

	public List<Route> findByFromNameAndToName(String from, String to);

}