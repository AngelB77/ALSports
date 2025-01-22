package com.F5.ALSports.service;

import com.F5.ALSports.model.Category;
import com.F5.ALSports.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category addCategory(Category newCategory) {
       return categoryRepository.save(newCategory);
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> findCategory(int id) {
        return categoryRepository.findById(id);
    }

    public Category updatedCategory(int id, Category updatedCategory) {
        Optional<Category> foundCategory = categoryRepository.findById(id);

        if (foundCategory.isPresent()) {
            Category existingCategory = foundCategory.get();

            existingCategory.setName(updatedCategory.getName());

            return categoryRepository.save(existingCategory);
        }

        throw new RuntimeException("Category not found with id: " + id);
    }
}
