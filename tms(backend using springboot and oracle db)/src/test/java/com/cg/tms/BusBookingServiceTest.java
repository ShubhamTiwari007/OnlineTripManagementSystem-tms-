package com.cg.tms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.tms.entities.BusBooking;
import com.cg.tms.repositories.IBusBookingRepository;
import com.cg.tms.repositories.IBusRepository;
import com.cg.tms.services.BusBookingServiceImpl;
import com.cg.tms.services.BusServiceImpl;

@SpringBootTest
class BusBookingServiceTest {
	
	@MockBean
	private IBusBookingRepository busBookingRepository;
	
	@MockBean
	private IBusRepository busRepository;
	
	@Autowired
	BusBookingServiceImpl busBookingServiceImpl;
	
	@Autowired
	BusServiceImpl busServiceImpl;
	
	@Test
	void testGetAllBusBookings() {
		List<BusBooking>list = new ArrayList<>();
		BusBooking busBooking1 = new BusBooking();
		BusBooking busBooking2 = new BusBooking();
		busBooking1.setId(1);
		busBooking2.setId(2);
		list.add(busBooking1);
		list.add(busBooking2);
		when(busBookingRepository.findAll()).thenReturn(list);
		assertEquals(list.size(),busBookingServiceImpl.getAllBusBookings().size());
	}

	@Test
	void testNotGetAllBusBookings() {
		List<BusBooking>list = new ArrayList<>();
		BusBooking busBooking1 = new BusBooking();
		BusBooking busBooking2 = new BusBooking();
		busBooking1.setId(1);
		busBooking2.setId(2);
		list.add(busBooking1);
		list.add(busBooking2);
		when(busBookingRepository.findAll()).thenReturn(list);
		assertNotEquals(3,busBookingServiceImpl.getAllBusBookings().size());
	}
	
	@Test
	void getBusBookingById() {
		BusBooking expected = new BusBooking();
		expected.setId(1);
		when(busBookingRepository.findById(1)).thenReturn(Optional.of(expected));
		BusBooking actual = busBookingServiceImpl.getBusBookingById(1);
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test
	void getNotBusBookingById() {
		BusBooking expected = new BusBooking();
		expected.setId(1);
		when(busBookingRepository.findById(1)).thenReturn(Optional.of(expected));
		Assertions.assertThrows(NullPointerException.class,()->busBookingServiceImpl.getBusBookingById(4));
	}
}