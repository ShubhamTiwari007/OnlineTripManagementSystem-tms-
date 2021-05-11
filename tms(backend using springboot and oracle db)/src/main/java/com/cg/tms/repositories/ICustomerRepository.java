package com.cg.tms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.tms.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByUsernameAndPassword(String username, String password);

	public List<Customer> findByName(String name);

}
