package com.cg.tms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * Customer POJO class
 * 
 */
@Entity
@Table(name = "customers_detail")
public class Customer extends User {

	private String name;
	private String address;
	private String mobileNo;
	@Column(nullable = false, unique = true)
	private String email;

	// no-arg constructor
	public Customer() {

	}

	// parameterized constructor
	public Customer(String name, String address, String mobileNo, String email, String username, String password) {
		super(username, password);
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	// getters setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + super.getId() + ", name=" + name + ", address=" + address + ", mobileNo=" + mobileNo
				+ ", email=" + email + "]";
	}
}
