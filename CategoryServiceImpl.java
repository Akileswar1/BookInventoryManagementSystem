package com.cg.bim.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.cg.bim.entity.Category;
import com.cg.bim.exception.CategoryNotFoundException;
import com.cg.bim.repository.CategoryRepository;
import com.cg.bim.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> getCategoryById(Long catId) {
        return categoryRepository.findById(catId);
                
    }
    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
}

    public Category updateCategoryDescription(Long catId, String newDescription) {
        Optional<Category> categoryOptional = categoryRepository.findById(catId);
        
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setCatDescription(newDescription);
            return categoryRepository.save(category);
        } else {
            throw new CategoryNotFoundException("Category not found with ID: " + catId);
        }
    }
}
