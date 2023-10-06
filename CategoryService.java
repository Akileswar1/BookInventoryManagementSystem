package com.cg.bim.service;
import java.util.List;
import java.util.Optional;

import com.cg.bim.entity.Category;



public interface CategoryService {
    
	Optional<Category> getCategoryById(Long catId);
	void addCategory(Category category);	
	Category updateCategoryDescription(Long catId, String newDescription);
}