package org.example.storeapplication.controller;

import org.example.storeapplication.dto.CategoryDTO;
import org.example.storeapplication.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) { this.categoryService = categoryService; }

    @PostMapping
    public void createCategory(@RequestBody CategoryDTO category) {
        categoryService.createCategory(category);
    }
}
