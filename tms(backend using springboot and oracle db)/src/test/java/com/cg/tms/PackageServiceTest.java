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
import com.cg.tms.entities.Package;
import com.cg.tms.exceptions.PackageNotFoundException;
import com.cg.tms.repositories.IPackageRepository;
import com.cg.tms.services.PackageServiceImpl;

@SpringBootTest
 class PackageServiceTest {

	@MockBean
	private IPackageRepository packageRepository;
	
	@Autowired
	private PackageServiceImpl packageServiceImpl;
	
	@Test
	void testAddPackage() {
		Package p = new Package();
		p.setId(1);
		when(packageRepository.save(p)).thenReturn(p);
		assertEquals(p, packageRepository.save(p));
	}
	
	@Test
	void testNotAddPackage() {
		Package p1 = new Package();
		p1.setId(1);
		Package p2 = new Package();
		p2.setId(2);
		when(packageRepository.save(p1)).thenReturn(p1);
		assertNotEquals(p1, packageRepository.save(p2));
	}
	
	@Test
	void testGetAllPackage() {
		List<Package>list = new ArrayList<>();
		Package p1 = new Package();
		p1.setId(1);
		Package p2 = new Package();
		p2.setId(2);
		list.add(p1);
		list.add(p2);
		when(packageRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), packageServiceImpl.getAllPackage().size());
	}
	
	@Test
	void testNotGetAllPackage() {
		List<Package>list = new ArrayList<>();
		Package p1 = new Package();
		p1.setId(1);
		Package p2 = new Package();
		p2.setId(2);
		list.add(p1);
		list.add(p2);
		when(packageRepository.findAll()).thenReturn(list);
		assertNotEquals(3, packageServiceImpl.getAllPackage().size());
	}

	@Test
	 void testUpdatePackage() {
		Package p = new Package();
		p.setId(1);
		when(packageRepository.save(p)).thenReturn(p);
		assertEquals(p,packageServiceImpl.updatePackage(p));
	}
	
	@Test
	 void testNotUpdatePackage() {
		Package p1 = new Package();
		p1.setId(1);
		Package p2 = new Package();
		p2.setId(2);
		when(packageRepository.save(p1)).thenReturn(p1);
		assertNotEquals(p1,packageServiceImpl.updatePackage(p2));
	}
	
	@Test
	void testDelete() {
		Package p = new Package();
		p.setId(1);
		doNothing().when(packageRepository).deleteById(1);
		when(packageRepository.findById(1)).thenReturn(Optional.of(p));
		assertEquals("Package with id: "+p.getId()+" deleted!!", packageServiceImpl.delete(1));
	}
	
	@Test
	void testNotDelete() {
		Package p = new Package();
		p.setId(1);
		doNothing().when(packageRepository).deleteById(1);
		when(packageRepository.findById(1)).thenReturn(Optional.of(p));
		Assertions.assertThrows(PackageNotFoundException.class, ()-> packageServiceImpl.delete(3));
	}
	
	@Test
	void getPackageById() {
		Package expected = new Package();
		expected.setId(1);
		when(packageRepository.findById(1)).thenReturn(Optional.of(expected));
		Package actual = packageServiceImpl.getPackageById(1);
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test
	void getNotPackageById() {
		Package expected = new Package();
		expected.setId(1);
		when(packageRepository.findById(1)).thenReturn(Optional.of(expected));
		Assertions.assertThrows(PackageNotFoundException.class,()->packageServiceImpl.getPackageById(4));
	}
}