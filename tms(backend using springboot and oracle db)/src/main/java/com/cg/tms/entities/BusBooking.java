package com.cg.tms.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * BusBooking POJO class
 *
 */
@Entity
@Table(name = "bus_booking")
public class BusBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int noOfPass;
	private double amount;
	private LocalDate bookingDate;
	@Column(name="jdate")
	private String journeyDate;
	private String dep;
	private String arr;

	@OneToOne
	Customer customer;

	@OneToOne
	private Station from;

	@OneToOne
	private Station to;

	@OneToOne
	Bus bus;

	// non-arg constructor
	public BusBooking() {
		this.bookingDate = LocalDate.now();
	}

	// parameterized constructor
	public BusBooking(Customer customer, int noOfPass, double amount, String journeyDate, String dep, String arr,
			Bus bus, Station from, Station to) {
		this.customer = customer;
		this.noOfPass = noOfPass;
		this.amount = amount;
		this.bookingDate = LocalDate.now();
		this.journeyDate = journeyDate;
		this.dep = dep;
		this.arr = arr;
		this.bus = bus;
		this.from = from;
		this.to = to;
	}

	// getters - setters
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

	public int getNoOfPass() {
		return noOfPass;
	}

	public void setNoOfPass(int noOfPass) {
		this.noOfPass = noOfPass;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
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

	@Override
	public String toString() {
		return "BusBooking [id=" + id + ", customer=" + customer + ", noOfPass=" + noOfPass + ", amount=" + amount
				+ ", bookingDate=" + bookingDate + ", journeyDate=" + journeyDate + ", dep=" + dep + ", arr=" + arr
				+ ", bus=" + bus + ", from=" + from + ", to=" + to + "]";
	}
}