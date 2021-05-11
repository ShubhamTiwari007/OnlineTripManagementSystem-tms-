package com.cg.tms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.repositories.ICustomerRepository;

/**
 * 
 * Class to implement CRUD operations from ICustomerRepository
 * 
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	/**
	 * to Insert Customer details in Database
	 * 
	 * @param customer of Customer type
	 */
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	/**
	 * to get All Customer
	 * 
	 * @return List of all Customers
	 */
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	/**
	 * to Update Customer details
	 * 
	 * @param customer
	 * @return updated Customer
	 */
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	/**
	 * to Delete Customer based on Id
	 * 
	 * @param id of integer type
	 * 
	 */
	public String delete(int id) {
		Customer customer = customerRepository.findById(id).orElseThrow(
				() -> new CustomerNotFoundException("Cannot delete, No cusotmer with id: " + id + " found!!"));
		customerRepository.deleteById(customer.getId());
		return "Customer with id: " + id + " deleted!!";

	}

	/**
	 * to Get Customer based on Id
	 * 
	 * @param id of integer type
	 * @return Customer whose id matches
	 */
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("No cusotmer with id: " + id + " found!!"));
	}

	/**
	 * to Get Customer based on Name
	 * 
	 * @param name of String type
	 * @return List of Customer whose name matches
	 */
	public List<Customer> getCustomersByName(String name) {
		List<Customer> customer = customerRepository.findByName(name);
		if (customer.isEmpty())
			throw new CustomerNotFoundException("No cusotmer with Name: " + name + " found!!");
		return customer;
	}

	/**
	 * to Validate Customer
	 * 
	 * @param username of String type
	 * @param password of String type
	 * @return true if Customer is found with same user name and password.
	 */
	public boolean validateCustomerByUsernameandPassword(String username, String password) {
		return customerRepository.findByUsernameAndPassword(username, password) != null;
	}
}