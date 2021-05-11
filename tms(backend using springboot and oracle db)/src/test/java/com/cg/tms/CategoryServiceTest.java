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
import com.cg.tms.entities.Category;
import com.cg.tms.exceptions.CategoryNotFoundException;
import com.cg.tms.repositories.ICategoryRepository;
import com.cg.tms.services.CategoryServiceImpl;

@SpringBootTest
 class CategoryServiceTest {
	
	@MockBean
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@Test
	void testAddCategory() {
		Category c = new Category();
		c.setId(1);
		when(categoryRepository.save(c)).thenReturn(c);
		assertEquals(c, categoryServiceImpl.addCategory(c));
	}
	
	@Test
	void testNotAddCategory() {
		Category c1 = new Category();
		c1.setId(1);
		Category c2 = new Category();
		c2.setId(2);
		when(categoryRepository.save(c1)).thenReturn(c1);
		assertNotEquals(c1, categoryServiceImpl.addCategory(c2));
	}
	
	@Test
	void testGetAllCategory() {
		List<Category>list = new ArrayList<>();
		Category c1 = new Category();
		c1.setId(1);
		Category c2 = new Category();
		c2.setId(2);
		list.add(c1);
		list.add(c2);
		when(categoryRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), categoryServiceImpl.getAllCategory().size());
	}
	

	@Test
	void testNotGetAllCategory() {
		List<Category>list = new ArrayList<>();
		Category c1 = new Category();
		c1.setId(1);
		Category c2 = new Category();
		c2.setId(2);
		list.add(c1);
		list.add(c2);
		when(categoryRepository.findAll()).thenReturn(list);
		assertNotEquals(3, categoryServiceImpl.getAllCategory().size());
	}
	
	@Test
	void testDelete() {
		Category c = new Category();
		c.setId(1);
		doNothing().when(categoryRepository).deleteById(1);
		when(categoryRepository.findById(1)).thenReturn(Optional.of(c));
		assertEquals("Category with id: "+c.getId()+" deleted!!", categoryServiceImpl.delete(1));
	}
	
	@Test
	void testNotDelete() {
		Category c = new Category();
		c.setId(1);
		doNothing().when(categoryRepository).deleteById(1);
		when(categoryRepository.findById(1)).thenReturn(Optional.of(c));
		Assertions.assertThrows(CategoryNotFoundException.class, ()-> categoryServiceImpl.delete(3));
	}
	
	@Test
	void getCategoryById() {
		Category expected = new Category();
		expected.setId(1);
		when(categoryRepository.findById(1)).thenReturn(Optional.of(expected));
		Category actual = categoryServiceImpl.getCategoryById(1);
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test
	void getNotCategoryById() {
		Category expected = new Category();
		expected.setId(1);
		when(categoryRepository.findById(1)).thenReturn(Optional.of(expected));
		Assertions.assertThrows(CategoryNotFoundException.class,()->categoryServiceImpl.getCategoryById(4));
	}
}
