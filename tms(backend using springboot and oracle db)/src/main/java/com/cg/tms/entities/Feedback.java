package com.cg.tms.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Feedback POJO class
 * 
 */
@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String description;
	private int rating;
	private LocalDate submitDate;

	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Customer customer;

	// no-arg constructor
	public Feedback() {
		this.submitDate = LocalDate.now();
	}

	// parameterized constructor
	public Feedback(String description, int rating, Customer customer) {
		this.description = description;
		this.submitDate = LocalDate.now();
		this.rating = rating;
		this.customer = customer;
	}

	// getters setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", description=" + description + ", rating=" + rating + ", submitDate="
				+ submitDate + ", customer=" + customer + "]";
	}
}