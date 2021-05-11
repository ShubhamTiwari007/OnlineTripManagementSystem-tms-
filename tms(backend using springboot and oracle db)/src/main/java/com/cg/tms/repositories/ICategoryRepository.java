package com.cg.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.tms.entities.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

	public Category findByName(String name);

}