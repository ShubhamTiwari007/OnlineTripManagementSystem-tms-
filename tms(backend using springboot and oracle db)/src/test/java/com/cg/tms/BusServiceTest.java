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
import com.cg.tms.entities.Bus;
import com.cg.tms.exceptions.BusNotFoundException;
import com.cg.tms.repositories.IBusRepository;
import com.cg.tms.services.BusServiceImpl;

@SpringBootTest
 class BusServiceTest {

	@MockBean
	private IBusRepository busRepository;
	
	@Autowired
	private BusServiceImpl busServiceImpl;
	
	@Test
	void testAddBus() {
		Bus bus = new Bus();
		bus.setId(12);
		when(busRepository.save(bus)).thenReturn(bus);
		assertEquals(bus, busServiceImpl.addBus(bus));
	}
	
	@Test
	void testNotAddBus() {
		Bus bus1 = new Bus();
		Bus bus2 = new Bus();
		bus1.setId(12);
		bus2.setId(14);
		when(busRepository.save(bus1)).thenReturn(bus1);
		assertNotEquals(bus1, busServiceImpl.addBus(bus2));
	}
	
	@Test
	void testGetAllBus() {
		List<Bus> list = new ArrayList<>();
		list.add(new Bus());
		list.add(new Bus());
		when(busRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), busServiceImpl.getAllBus().size());
	}
	
	@Test
	void testNotGetAllBus() {
		List<Bus> list = new ArrayList<>();
		list.add(new Bus());
		list.add(new Bus());
		when(busRepository.findAll()).thenReturn(list);
		assertNotEquals(3, busServiceImpl.getAllBus().size());
	}
	
	@Test
	void testUpdateBus() {
		Bus bus = new Bus();
		when(busRepository.save(bus)).thenReturn(bus);
		assertEquals(bus, busServiceImpl.updateBus(bus));
	}
	
	@Test
	void testNotUpdateBus() {
		Bus bus1 = new Bus();
		Bus bus2 = new Bus();
		when(busRepository.save(bus1)).thenReturn(bus1);
		assertNotEquals(bus1, busServiceImpl.updateBus(bus2));
	}
	
	@Test
	void testDelete() throws Exception {
		Bus obj = new Bus();
		obj.setId(1);
		doNothing().when(busRepository).deleteById(1);
		when(busRepository.findById(1)).thenReturn(Optional.of(obj));
		assertEquals("Bus with id: "+obj.getId()+" deleted!!", busServiceImpl.delete(1));
	}

	@Test
	void testNotDelete() throws Exception {
		Bus obj = new Bus();
		obj.setId(1);
		doNothing().when(busRepository).deleteById(1);
		when(busRepository.findById(1)).thenReturn(Optional.of(obj));
		Assertions.assertThrows(BusNotFoundException.class, () -> busServiceImpl.delete(2));
	}

	@Test
	 void testGetBusById(){
		Bus expected = new Bus();
		expected.setId(12);
		when(busRepository.findById(12)).thenReturn(Optional.of(expected));
		Bus actual = busServiceImpl.getBusById(12);
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test
	 void testNotGetBusById() {
		Bus expected = new Bus();
		expected.setId(12);
		when(busRepository.findById(12)).thenReturn(Optional.of(expected));
		Assertions.assertThrows(BusNotFoundException.class,()->busServiceImpl.getBusById(20));
	}
	
}