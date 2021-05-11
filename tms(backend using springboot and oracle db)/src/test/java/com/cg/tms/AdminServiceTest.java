package com.cg.tms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.tms.entities.Admin;
import com.cg.tms.repositories.IAdminRepository;
import com.cg.tms.services.AdminServiceImpl;

@SpringBootTest
class AdminServiceTest {

	@MockBean
	private IAdminRepository adminRepository;

	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@Test
	void testValidCustomer() {
		Admin expected = new Admin();
		expected.setUsername("sonu!@12");
		expected.setPassword("4321");
		when(adminRepository.findByUsernameAndPassword("sonu!@12", "4321")).thenReturn(expected);
		boolean value = adminServiceImpl.isValidAdmin("sonu!@12", "4321");
		assertEquals(true, value);
	}

	@Test
	void testNotValidCustomer() {
		Admin expected = new Admin();
		expected.setUsername("sonu!@12");
		expected.setPassword("4321");
		when(adminRepository.findByUsernameAndPassword("sonu!@12", "4321")).thenReturn(expected);
		boolean value = adminServiceImpl.isValidAdmin("sonu!@12", "3421");
		assertNotEquals(true, value);
	}
}
