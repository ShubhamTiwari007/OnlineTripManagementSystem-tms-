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
 * PackageBooking POJO class
 * 
 */
@Entity
@Table(name = "package_booking")
public class PackageBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private Customer customer;
	private LocalDate bookingDate;
	private int noOfCustomers;
	private double amount;
	private String description;

	@OneToOne
	private Hotel hotel;

	@OneToOne
	private Package packages;

	// no-arg constructor
	public PackageBooking() {
		this.bookingDate = LocalDate.now();
	}

	// parameterized constructor
	public PackageBooking(Customer customer, int noOfCustomers, double amount, String description, Hotel hotel,
			Package packages) {
		super();
		this.customer = customer;
		this.bookingDate = LocalDate.now();
		this.noOfCustomers = noOfCustomers;
		this.amount = amount;
		this.description = description;
		this.hotel = hotel;
		this.packages = packages;
	}

	// getters setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getNoOfCustomers() {
		return noOfCustomers;
	}

	public void setNoOfCustomers(int noOfCustomers) {
		this.noOfCustomers = noOfCustomers;
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Package getPackages() {
		return packages;
	}

	public void setPackages(Package packages) {
		this.packages = packages;
	}

	@Override
	public String toString() {
		return "PackageBooking [id=" + id + ", customer=" + customer + ", bookingDate=" + bookingDate
				+ ", noOfCustomers=" + noOfCustomers + ", amount=" + amount + ", description=" + description
				+ ", hotel=" + hotel + ", packages=" + packages + "]";
	}
}
