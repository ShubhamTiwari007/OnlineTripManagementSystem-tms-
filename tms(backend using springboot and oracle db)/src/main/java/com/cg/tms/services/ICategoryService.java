package com.cg.tms.services;

import java.util.List;

import com.cg.tms.entities.Category;

public interface ICategoryService {

	public Category addCategory(Category category);

	public List<Category> getAllCategory();

	public Category updateCategory(Category category);

	public String delete(int id);

	public Category getCategoryById(int id);

	public Category getCategoryByName(String name);

}