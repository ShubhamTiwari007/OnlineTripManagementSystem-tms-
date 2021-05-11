package com.cg.tms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.tms.entities.Category;
import com.cg.tms.exceptions.CategoryNotFoundException;
import com.cg.tms.repositories.ICategoryRepository;

/**
 * 
 * Class to implement CRUD operations from ICategoryRepository
 * 
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	/**
	 * to add Category in database
	 * 
	 * @param category of Category type
	 * @return category which is stored
	 */
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	/**
	 * to get all categories from database
	 * 
	 * @return List of all customers
	 */

	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	/**
	 * to update category in database
	 * 
	 * @param category of Category type
	 * @return updated category
	 */
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}

	/**
	 * to delete category from database
	 * 
	 * @param id of type integer
	 * @return message after deletion
	 */
	public String delete(int id) {
		Category category = categoryRepository.findById(id).orElseThrow(
				() -> new CategoryNotFoundException("Cannot delete,No category with id: " + id + " found!!"));
		categoryRepository.deleteById(category.getId());
		return "Category with id: " + category.getId() + " deleted!!";
	}

	/**
	 * to get category based on id
	 * 
	 * @param id of integer type
	 * @return Category whose id matches
	 */
	public Category getCategoryById(int id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("No category with id: " + id + " found!!"));
	}

	/**
	 * to get category based on name
	 * 
	 * @param name
	 * @return category whose name matches
	 */
	public Category getCategoryByName(String name) {
		Category category = categoryRepository.findByName(name);
		if (category == null)
			throw new CategoryNotFoundException("Category with Name: " + name + " does not exist");
		return category;
	}
}