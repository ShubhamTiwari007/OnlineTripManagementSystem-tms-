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
import com.cg.tms.entities.Package;
import com.cg.tms.entities.PackageBooking;
import com.cg.tms.repositories.IHotelRepository;
import com.cg.tms.repositories.IPackageBookingRepository;
import com.cg.tms.repositories.IPackageRepository;
import com.cg.tms.services.PackageBookingServiceImpl;

@SpringBootTest
class PackageBookingServiceTest {

	@MockBean
	private IPackageBookingRepository packageBookingRepository;
	
	@MockBean
	private IPackageRepository packageRepository;
	
	@MockBean
	private IHotelRepository hotelRespository;
	
	@Autowired
	private PackageBookingServiceImpl packageBookingServiceImpl;
	
	@Test
	void testAddPackageBooking() {
		com.cg.tms.entities.Package pack = new Package();
		pack.setPrice(5000);
		Hotel hotel = new Hotel();
		hotel.setRent(2000);
		PackageBooking pb = new PackageBooking();
		pb.setId(1);
		pb.setPackages(pack);
		pb.setHotel(hotel);
		when(packageRepository.save(pack)).thenReturn(pack);
		when(hotelRespository.save(hotel)).thenReturn(hotel);
		when(packageBookingRepository.save(pb)).thenReturn(pb);
		assertEquals(pb, packageBookingServiceImpl.addPackageBooking(pb));
	}
	
	@Test
	void testNotAddPackageBooking() {
		com.cg.tms.entities.Package pack = new Package();
		pack.setPrice(5000);
		Hotel hotel = new Hotel();
		hotel.setRent(2000);
		PackageBooking pb1 = new PackageBooking();
		pb1.setId(1);
		pb1.setHotel(hotel);
		pb1.setPackages(pack);
		PackageBooking pb2 = new PackageBooking();
		pb2.setId(2);
		when(packageRepository.save(pack)).thenReturn(pack);
		when(hotelRespository.save(hotel)).thenReturn(hotel);
		when(packageBookingRepository.save(pb1)).thenReturn(pb1);
		assertNotEquals(pb2, packageBookingServiceImpl.addPackageBooking(pb1));
	}
	
	@Test 
	void testGetAllPackageBooking() {
		List<PackageBooking>list = new ArrayList<>();
		PackageBooking pb1 = new PackageBooking();
		pb1.setId(1);
		PackageBooking pb2 = new PackageBooking();
		pb2.setId(2);
		list.add(pb1);
		list.add(pb2);
		when(packageBookingRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), packageBookingServiceImpl.getAllPackageBookings().size());
	}
	
	@Test 
	void testNotGetAllPackageBooking() {
		List<PackageBooking>list = new ArrayList<>();
		PackageBooking pb1 = new PackageBooking();
		pb1.setId(1);
		PackageBooking pb2 = new PackageBooking();
		pb2.setId(2);
		list.add(pb1);
		list.add(pb2);
		when(packageBookingRepository.findAll()).thenReturn(list);
		assertNotEquals(3, packageBookingServiceImpl.getAllPackageBookings().size());
	}
	
	@Test
	void testDeleteByPackageBookingById() {
		PackageBooking pb = new PackageBooking();
		pb.setId(1);
		doNothing().when(packageBookingRepository).deleteById(1);
		when(packageBookingRepository.findById(1)).thenReturn(Optional.of(pb));
		assertEquals("PackageBooking with id: "+pb.getId()+" deleted!!", packageBookingServiceImpl.deletePackageBookingById(1));
	}
	
	@Test
	void testNotDeleteByPackageBookingById() {
		PackageBooking pb = new PackageBooking();
		pb.setId(1);
		doNothing().when(packageBookingRepository).deleteById(1);
		when(packageBookingRepository.findById(1)).thenReturn(Optional.of(pb));
		Assertions.assertThrows(NullPointerException.class, ()-> packageBookingServiceImpl.deletePackageBookingById(3));
	}
}

