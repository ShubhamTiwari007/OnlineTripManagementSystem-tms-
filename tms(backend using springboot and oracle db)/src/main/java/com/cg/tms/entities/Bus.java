package com.cg.tms.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * Bus POJO class
 * 
 */
@Entity
@Table(name = "bus")
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String busNumber;
	private int currentEmptySeat;
	private String driver;
	private String conductor;
	private String dep;
	private String arr;
	private double amount;

	@OneToMany
	private List<Feedback> feedbacks;

	// no-arg constructor
	public Bus() {

	}

	// parameterized constructor
	public Bus(String busNumber, int currentEmptySeat, String driver, String conductor, String dep, String arr,
			double amount, List<Feedback> feedbacks) {
		super();
		this.busNumber = busNumber;
		this.currentEmptySeat = currentEmptySeat;
		this.driver = driver;
		this.conductor = conductor;
		this.dep = dep;
		this.arr = arr;
		this.amount = amount;
		this.feedbacks = feedbacks;
	}

	// getters setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getConductor() {
		return conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public int getCurrentEmptySeat() {
		return currentEmptySeat;
	}

	public void setCurrentEmptySeat(int currentEmptySeat) {
		this.currentEmptySeat = currentEmptySeat;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", busNumber=" + busNumber + ", currentEmptySeat=" + currentEmptySeat + ", driver="
				+ driver + ", conductor=" + conductor + ", dep=" + dep + ", arr=" + arr + ", amount=" + amount
				+ ", feedbacks=" + feedbacks + "]";
	}
}