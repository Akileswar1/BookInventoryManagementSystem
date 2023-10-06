package com.cg.bim.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bim.entity.Category;
import com.cg.bim.service.CategoryService;



@RestController
@RequestMapping("/api")
public class CategoryController<CategoryUpdateRequest> {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/category/post")
    public ResponseEntity<String> addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return ResponseEntity.ok("Category added successfully");
    }
    @GetMapping("/category/{catId}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable("catId") Long catId) {
        Optional<Category> category = categoryService.getCategoryById(catId);
        return ResponseEntity.ok(category);
    }
    @PutMapping("/category/update/description/{catId}")
    public ResponseEntity<Category> updateCategoryDescription(@PathVariable Long catId,@RequestBody String newDescription) {
        Category updatedCategory = categoryService.updateCategoryDescription(catId, newDescription);
        return ResponseEntity.ok(updatedCategory);
}
    
}