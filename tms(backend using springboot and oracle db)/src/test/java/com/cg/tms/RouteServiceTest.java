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
import com.cg.tms.entities.Route;
import com.cg.tms.exceptions.RouteNotFoundException;
import com.cg.tms.repositories.IRouteRepository;
import com.cg.tms.services.RouteServiceImpl;

@SpringBootTest
class RouteServiceTest {

	@MockBean
	private IRouteRepository routeRepository;
	
	@Autowired
	private RouteServiceImpl routeServiceImpl;
	
	@Test
	void testAddRoute() {
		Route r = new Route();
		r.setId(1);
		when(routeRepository.save(r)).thenReturn(r);
		assertEquals(r, routeRepository.save(r));
	}
	
	@Test
	void testNotAddRoute() {
		Route r1 = new Route();
		r1.setId(1);
		Route r2 = new Route();
		r2.setId(2);
		when(routeRepository.save(r1)).thenReturn(r1);
		assertNotEquals(r1, routeRepository.save(r2));
	}
	
	@Test
	void testGetAllRoute() {
		List<Route>list = new ArrayList<>();
		Route r1 = new Route();
		r1.setId(1);
		Route r2 = new Route();
		r2.setId(2);
		list.add(r1);
		list.add(r2);
		when(routeRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), routeServiceImpl.getAllRoute().size());
	}
	
	@Test
	void testNotGetAllRoute() {
		List<Route>list = new ArrayList<>();
		Route r1 = new Route();
		r1.setId(1);
		Route r2 = new Route();
		r2.setId(2);
		list.add(r1);
		list.add(r2);
		when(routeRepository.findAll()).thenReturn(list);
		assertNotEquals(3, routeServiceImpl.getAllRoute().size());
	}

	@Test
	void testDelete() {
		Route r = new Route();
		r.setId(1);
		doNothing().when(routeRepository).deleteById(1);
		when(routeRepository.findById(1)).thenReturn(Optional.of(r));
		assertEquals("Route with id: "+r.getId()+" deleted!!", routeServiceImpl.delete(1));
	}
	
	@Test
	void testNotDelete() {
		Route r = new Route();
		r.setId(1);
		doNothing().when(routeRepository).deleteById(1);
		when(routeRepository.findById(1)).thenReturn(Optional.of(r));
		Assertions.assertThrows(RouteNotFoundException.class, ()-> routeServiceImpl.delete(3));
	}
	
	@Test
	void getRouteById() {
		Route expected = new Route();
		expected.setId(1);
		when(routeRepository.findById(1)).thenReturn(Optional.of(expected));
		Route actual = routeServiceImpl.getRouteById(1);
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test
	void getNotRouteById() {
		Route expected = new Route();
		expected.setId(1);
		when(routeRepository.findById(1)).thenReturn(Optional.of(expected));
		Assertions.assertThrows(RouteNotFoundException.class,()->routeServiceImpl.getRouteById(4));
	}
}
