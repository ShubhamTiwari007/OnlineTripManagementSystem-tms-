package com.cg.tms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.cg.tms.entities.Customer;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.repositories.ICustomerRepository;
import com.cg.tms.services.CustomerServiceImpl;

@SpringBootTest
class CustomerServiceTest {

	@MockBean
	private ICustomerRepository customerRepository;

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@Test
	void testAddCustomer() {
		Customer customer = new Customer();
		customer.setId(12);
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerServiceImpl.addCustomer(customer));
	}

	@Test
	void testNotAddCustomer() {
		Customer customer1 = new Customer();
		customer1.setId(12);
		Customer customer2 = new Customer();
		customer2.setId(13);
		when(customerRepository.save(customer1)).thenReturn(customer1);
		assertNotEquals(customer1, customerServiceImpl.addCustomer(customer2));
	}

	@Test
	void testGetAllCustomer() {
		List<Customer> list = new ArrayList<>();
		list.add(new Customer("Sonu", "Delhi", "4830248934", "sonu@gamil.com", "sonu!@12", "4321"));
		list.add(new Customer("Monu", "Mumbai", "4832348934", "monu@gamil.com", "monu!@12", "3421"));
		when(customerRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), customerServiceImpl.getAllCustomer().size());
	}

	@Test
	void testNotGetAllCustomer() {
		List<Customer> list = new ArrayList<>();
		list.add(new Customer("Sonu", "Delhi", "4830248934", "sonu@gamil.com", "sonu!@12", "4321"));
		list.add(new Customer("Monu", "Mumbai", "4832348934", "monu@gamil.com", "monu!@12", "3421"));
		when(customerRepository.findAll()).thenReturn(list);
		assertNotEquals(3, customerServiceImpl.getAllCustomer().size());
	}

	@Test
	void testUpdateCustomer() {
		Customer customer = new Customer();
		customer.setId(12);
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerServiceImpl.updateCustomer(customer));
	}

	@Test
	void testNotUpdateCustomer() {
		Customer customer1 = new Customer();
		customer1.setId(12);
		Customer customer2 = new Customer();
		customer2.setId(13);
		when(customerRepository.save(customer1)).thenReturn(customer1);
		assertNotEquals(customer1, customerServiceImpl.updateCustomer(customer2));
	}

	@Test
	void testDelete() {
		Customer obj = new Customer();
		obj.setId(1);
		doNothing().when(customerRepository).deleteById(1);
		when(customerRepository.findById(1)).thenReturn(Optional.of(obj));
		assertEquals("Customer with id: " + obj.getId() + " deleted!!", customerServiceImpl.delete(1));
	}

	@Test
	void testNotDelete() {
		Customer obj = new Customer();
		obj.setId(1);
		doNothing().when(customerRepository).deleteById(1);
		when(customerRepository.findById(1)).thenReturn(Optional.of(obj));
		Assertions.assertThrows(CustomerNotFoundException.class, () -> customerServiceImpl.delete(2));
	}

	@Test
	void testGetCustomerById() {
		Customer expected = new Customer();
		expected.setId(10);
		when(customerRepository.findById(10)).thenReturn(Optional.of(expected));
		Customer actual = customerServiceImpl.getCustomerById(10);
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	void testNotGetCustomerById() {
		Customer expected = new Customer();
		expected.setId(10);
		when(customerRepository.findById(10)).thenReturn(Optional.of(expected));
		Assertions.assertThrows(CustomerNotFoundException.class, () -> customerServiceImpl.getCustomerById(20));
	}

	@Test
	void testValidCustomer() {
		Customer expected = new Customer();
		expected.setUsername("sonu!@12");
		expected.setPassword("4321");
		when(customerRepository.findByUsernameAndPassword("sonu!@12", "4321")).thenReturn(expected);
		boolean value = customerServiceImpl.validateCustomerByUsernameandPassword("sonu!@12", "4321");
		assertEquals(true, value);
	}

	@Test
	void testNotValidCustomer() {
		Customer expected = new Customer();
		expected.setUsername("sonu!@12");
		expected.setPassword("4321");
		when(customerRepository.findByUsernameAndPassword("sonu!@12", "4321")).thenReturn(expected);
		boolean value = customerServiceImpl.validateCustomerByUsernameandPassword("sonu!@12", "3421");
		assertNotEquals(true, value);
	}
}