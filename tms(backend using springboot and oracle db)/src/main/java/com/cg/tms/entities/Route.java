package com.cg.tms.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Route POJO class
 * 
 */
@Entity
@Table(name = "route")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private Station from;

	@OneToOne
	private Station to;

	@OneToMany
	List<Bus> buses;

	// no-arg constructor
	public Route() {

	}

	// parameterized constructor
	public Route(Station from, Station to, List<Bus> buses) {
		super();
		this.from = from;
		this.to = to;
		this.buses = buses;
	}

	// getters setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Station getFrom() {
		return from;
	}

	public void setFrom(Station from) {
		this.from = from;
	}

	public Station getTo() {
		return to;
	}

	public void setTo(Station to) {
		this.to = to;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", from=" + from + ", to=" + to + ", buses=" + buses + "]";
	}

}