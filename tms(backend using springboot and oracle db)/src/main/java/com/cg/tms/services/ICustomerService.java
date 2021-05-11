package com.cg.tms.services;

import java.util.List;

import com.cg.tms.entities.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public Customer updateCustomer(Customer customer);

	public String delete(int id);

	public Customer getCustomerById(int id);

	public List<Customer> getCustomersByName(String name);

	public boolean validateCustomerByUsernameandPassword(String username, String password);
}