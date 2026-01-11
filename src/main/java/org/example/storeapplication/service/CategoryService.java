package org.example.storeapplication.service;

import org.example.storeapplication.dto.CategoryDTO;
import org.example.storeapplication.entity.Category;
import org.example.storeapplication.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(CategoryDTO categoryDTO) {
        if (categoryRepository.existsByName(categoryDTO.getName())) {
            throw new IllegalStateException("Category already exists");
        }

        Category category = new Category();
        category.setName(categoryDTO.getName());

        return categoryRepository.save(category);
    }
}
