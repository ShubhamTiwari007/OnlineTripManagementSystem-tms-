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
import com.cg.tms.entities.Station;
import com.cg.tms.exceptions.StationNotFoundException;
import com.cg.tms.repositories.IStationRepository;
import com.cg.tms.services.StationServiceImpl;

@SpringBootTest
class StationServiceTest {

	@MockBean
	private IStationRepository stationRepository;
	
	@Autowired
	private StationServiceImpl stationServiceImpl;
	
	@Test
	void testAddStation() {
		Station s = new Station();
		s.setId(1);
		when(stationRepository.save(s)).thenReturn(s);
		assertEquals(s, stationRepository.save(s));
	}
	
	@Test
	void testNotAddStation() {
		Station s1 = new Station();
		s1.setId(1);
		Station s2 = new Station();
		s2.setId(2);
		when(stationRepository.save(s1)).thenReturn(s1);
		assertNotEquals(s1, stationRepository.save(s2));
	}
	
	@Test
	void testGetAllStation() {
		List<Station>list = new ArrayList<>();
		Station s1 = new Station();
		s1.setId(1);
		Station s2 = new Station();
		s2.setId(2);
		list.add(s1);
		list.add(s2);
		when(stationRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), stationServiceImpl.getAllStation().size());
	}
	
	@Test
	void testNotGetAllStation() {
		List<Station>list = new ArrayList<>();
		Station s1 = new Station();
		s1.setId(1);
		Station s2 = new Station();
		s2.setId(2);
		list.add(s1);
		list.add(s2);
		when(stationRepository.findAll()).thenReturn(list);
		assertNotEquals(3, stationServiceImpl.getAllStation().size());
	}

	@Test
	void testDelete() {
		Station s = new Station();
		s.setId(1);
		doNothing().when(stationRepository).deleteById(1);
		when(stationRepository.findById(1)).thenReturn(Optional.of(s));
		assertEquals("Station with id: "+s.getId()+" deleted!!", stationServiceImpl.deleteById(1));
	}
	
	@Test
	void testNotDelete() {
		Station s = new Station();
		s.setId(1);
		doNothing().when(stationRepository).deleteById(1);
		when(stationRepository.findById(1)).thenReturn(Optional.of(s));
		Assertions.assertThrows(StationNotFoundException.class, ()-> stationServiceImpl.deleteById(3));
	}
	
	@Test
	void getStationById() {
		Station expected = new Station();
		expected.setId(1);
		when(stationRepository.findById(1)).thenReturn(Optional.of(expected));
		Station actual = stationServiceImpl.getStationById(1);
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test
	void getNotStationById() {
		Station expected = new Station();
		expected.setId(1);
		when(stationRepository.findById(1)).thenReturn(Optional.of(expected));
		Assertions.assertThrows(StationNotFoundException.class,()->stationServiceImpl.getStationById(4));
	}

}