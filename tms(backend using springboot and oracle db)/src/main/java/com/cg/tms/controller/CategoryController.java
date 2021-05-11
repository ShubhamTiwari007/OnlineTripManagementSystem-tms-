package com.cg.tms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entities.Category;
import com.cg.tms.services.CategoryServiceImpl;
import com.cg.tms.services.ICategoryService;

/**
 * 
 * Controller class for testing CategoryServiceImpl
 *
 */
@RestController
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
	}

	@GetMapping("/getcategories")
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}

	@PutMapping("/updatecategies")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
	}

	@DeleteMapping("/deletecategorybyid/{id}")
	public String deleteCategory(@PathVariable int id) {
		return categoryService.delete(id);
	}

	@GetMapping("/getcategorybyid/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
		Category category = categoryService.getCategoryById(id);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@GetMapping("/getcategorybyname/{name}")
	public ResponseEntity<Category> getCategoryByName(@PathVariable String name) {
		return new ResponseEntity<>(categoryService.getCategoryByName(name), HttpStatus.OK);
	}
}