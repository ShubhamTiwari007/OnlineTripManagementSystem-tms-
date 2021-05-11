package com.cg.tms.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * Package POJO class
 * 
 */
@Entity
@Table(name = "Package")
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	private String destination;
	private String duration;
	private String description;
	private double price;
	private String profile;

	@ManyToMany
	private List<Category> categories;

	@ManyToMany
	private List<Hotel> hotels;

	@OneToMany
	private List<Feedback> feedbacks;

	// no-arg constructor
	public Package() {

	}

	// parameterized constructor
	public Package(String name, String destination, String duration, String description, double price,String profile,
			List<Category> categories, List<Hotel> hotels, List<Feedback> feedbacks) {
		super();
		this.name = name;
		this.destination = destination;
		this.duration = duration;
		this.description = description;
		this.price = price;
		this.profile = profile;
		this.categories = categories;
		this.hotels = hotels;
		this.feedbacks = feedbacks;
	}

	// getter setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Package [id=" + id + ", name=" + name + ", destination=" + destination + ", duration=" + duration
				+ ", description=" + description + ", price=" + price + "]";
	}
}