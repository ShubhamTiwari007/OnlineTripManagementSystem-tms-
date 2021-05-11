package com.cg.tms.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * HotelBooking POJO class
 * 
 */
@Entity
@Table(name = "hotel_booking")
public class HotelBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private LocalDate bookingDate;
	private int noOfCustomer;
	private double amount;
	private String description;
	private String duration;
	private String checkin;
	private String checkOut;

	@OneToOne
	Customer customer;

	@OneToOne
	Hotel hotel;

	// no-arg constructor
	public HotelBooking() {
		this.bookingDate = LocalDate.now();
	}

	// parameterized constructor
	public HotelBooking(int noOfCustomer, double amount, String description, String duration,
			String checkin, String checkOut, Customer customer, Hotel hotel) {
		this.bookingDate = LocalDate.now();
		this.noOfCustomer = noOfCustomer;
		this.amount = amount;
		this.description = description;
		this.duration = duration;
		this.checkin = checkin;
		this.checkOut = checkOut;
		this.customer = customer;
		this.hotel = hotel;
	}

	// getter setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getNoOfCustomer() {
		return noOfCustomer;
	}

	public void setNoOfCustomer(int noOfCustomer) {
		this.noOfCustomer = noOfCustomer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "HotelBooking [id=" + id + ", bookingDate=" + bookingDate + ", noOfCustomer=" + noOfCustomer
				+ ", amount=" + amount + ", description=" + description + ", duration=" + duration + ", checkin="
				+ checkin + ", checkOut=" + checkOut + ", customer=" + customer + ", hotel=" + hotel + "]";
	}

}