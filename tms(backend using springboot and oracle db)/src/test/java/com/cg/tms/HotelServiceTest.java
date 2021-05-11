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
import com.cg.tms.exceptions.HotelNotFoundException;
import com.cg.tms.repositories.IHotelRepository;
import com.cg.tms.services.HotelServiceImpl;

@SpringBootTest
 class HotelServiceTest {

	@MockBean
	private IHotelRepository hotelRepository;
	
	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	@Test
	void testAddHotel() {
		Hotel h = new Hotel();
		h.setId(1);
		when(hotelRepository.save(h)).thenReturn(h);
		assertEquals(h, hotelServiceImpl.addHotel(h));
	}
	
	@Test
	void testNotAddHotel() {
		Hotel h1 = new Hotel();
		h1.setId(1);
		Hotel h2 = new Hotel();
		h2.setId(2);
		when(hotelRepository.save(h1)).thenReturn(h1);
		assertNotEquals(h1, hotelServiceImpl.addHotel(h2));
	}
	
	@Test
	void testGetAllHotel() {
		List<Hotel>list = new ArrayList<>();
		Hotel h1 = new Hotel();
		h1.setId(1);
		Hotel h2 = new Hotel();
		h2.setId(2);
		list.add(h1);
		list.add(h2);
		when(hotelRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), hotelServiceImpl.getAllHotel().size());
	}
	

	@Test
	void testNotGetAllHotel() {
		List<Hotel>list = new ArrayList<>();
		Hotel h1 = new Hotel();
		h1.setId(1);
		Hotel h2 = new Hotel();
		h2.setId(2);
		list.add(h1);
		list.add(h2);
		when(hotelRepository.findAll()).thenReturn(list);
		assertNotEquals(3, hotelServiceImpl.getAllHotel().size());
	}
	
	@Test
	void testDelete() {
		Hotel h = new Hotel();
		h.setId(1);
		doNothing().when(hotelRepository).deleteById(1);
		when(hotelRepository.findById(1)).thenReturn(Optional.of(h));
		assertEquals("Hotel with id: "+h.getId()+" deleted!!", hotelServiceImpl.delete(1));
	}
	
	@Test
	void testNotDelete() {
		Hotel h = new Hotel();
		h.setId(1);
		doNothing().when(hotelRepository).deleteById(1);
		when(hotelRepository.findById(1)).thenReturn(Optional.of(h));
		Assertions.assertThrows(HotelNotFoundException.class, ()-> hotelServiceImpl.delete(3));
	}
	

}