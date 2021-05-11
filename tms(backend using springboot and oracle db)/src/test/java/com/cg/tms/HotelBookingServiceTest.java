package com.cg.tms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.tms.entities.Hotel;
import com.cg.tms.entities.HotelBooking;
import com.cg.tms.repositories.IHotelBookingRepository;
import com.cg.tms.repositories.IHotelRepository;
import com.cg.tms.services.HotelBookingServiceImpl;

@SpringBootTest
 class HotelBookingServiceTest {

	@MockBean
	private IHotelBookingRepository hotelBookingRepository;
	
	@MockBean
	private IHotelRepository hotelRepository;
	
	@Autowired
	private HotelBookingServiceImpl hotelBookingServiceImpl;
	
	@Test
	void testAddHotelBooking() {
		HotelBooking hb = new HotelBooking();
		hb.setId(1);
		Hotel hotel = new Hotel();
		hotel.setRent(2300);
		hb.setHotel(hotel);
		when(hotelRepository.save(hotel)).thenReturn(hotel);
		when(hotelBookingRepository.save(hb)).thenReturn(hb);
		assertEquals(hb, hotelBookingServiceImpl.addHotelBooking(hb));
	}
	
	@Test
	void testNotAddHotelBooking() {
		HotelBooking hb1 = new HotelBooking();
		hb1.setId(1);
		Hotel hotel = new Hotel();
		hotel.setRent(2300);
		hb1.setHotel(hotel);
		HotelBooking hb2 = new HotelBooking();
		hb2.setId(2);
		when(hotelRepository.save(hotel)).thenReturn(hotel);
		when(hotelBookingRepository.save(hb1)).thenReturn(hb1);
		assertNotEquals(hb2, hotelBookingServiceImpl.addHotelBooking(hb1));
	}
	
	@Test 
	void testGetAllHotelBooking() {
		List<HotelBooking>list = new ArrayList<>();
		HotelBooking hb1 = new HotelBooking();
		hb1.setId(1);
		HotelBooking hb2 = new HotelBooking();
		hb2.setId(2);
		list.add(hb1);
		list.add(hb2);
		when(hotelBookingRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), hotelBookingServiceImpl.getAllBookings().size());
	}
	
	@Test 
	void testNotGetAllHotelBooking() {
		List<HotelBooking>list = new ArrayList<>();
		HotelBooking hb1 = new HotelBooking();
		hb1.setId(1);
		HotelBooking hb2 = new HotelBooking();
		hb2.setId(2);
		list.add(hb1);
		list.add(hb2);
		when(hotelBookingRepository.findAll()).thenReturn(list);
		assertNotEquals(3, hotelBookingServiceImpl.getAllBookings().size());
	}
	
	@Test
	void testDeleteByHotelBookingById() {
		HotelBooking hb = new HotelBooking();
		hb.setId(1);
		doNothing().when(hotelBookingRepository).deleteById(1);
		when(hotelBookingRepository.findById(1)).thenReturn(Optional.of(hb));
		assertEquals("HotelBooking with id: "+hb.getId()+" deleted!!", hotelBookingServiceImpl.deleteByHotelBookingById(1));
	}
	
	@Test
	void testNotDeleteByHotelBookingById() {
		HotelBooking hb = new HotelBooking();
		hb.setId(1);
		doNothing().when(hotelBookingRepository).deleteById(1);
		when(hotelBookingRepository.findById(1)).thenReturn(Optional.of(hb));
		Assertions.assertThrows(NullPointerException.class, ()-> hotelBookingServiceImpl.deleteByHotelBookingById(3));
	}
	
//	@Test
//	void testGetAllBookingsByCustomerId() {
//		List<HotelBooking>list = new ArrayList<>();
//		Customer customer1 = new Customer();
//		Customer customer2 = new Customer();
//		HotelBooking hb1 = new HotelBooking();
//		HotelBooking hb2 = new HotelBooking();
//		customer1.setId(1);
//		customer2.setId(1);
//		hb1.setCustomer(customer1);
//		hb2.setCustomer(customer2);
//		list.add(hb1);
//		list.add(hb2);
//		when(hotelBookingRepository.findAll()).thenReturn(list);
//		assertEquals(list.size(), hotelBookingServiceImpl.getAllBookingsByCustomerId(1).size());
//	}
	
//	@Test
//	void testNotGetAllBookingsByCustomerId() {
//		List<HotelBooking>list = new ArrayList<>();
//		HotelBooking hb1 = new HotelBooking();
//		hb1.setId(1);
//		HotelBooking hb2 = new HotelBooking();
//		hb2.setId(2);
//		list.add(hb1);
//		list.add(hb2);
//		when(hotelBookingRepository.findAll()).thenReturn(list);
//		assertEquals(list.size(), hotelBookingServiceImpl.getAllBookings().size());
//	}
}