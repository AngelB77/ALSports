package com.F5.ALSports.service;

import com.F5.ALSports.dto.category.CategoryMapper;
import com.F5.ALSports.dto.category.CategoryRequest;
import com.F5.ALSports.dto.category.CategoryResponse;
import com.F5.ALSports.exeptions.EmptyException;
import com.F5.ALSports.model.Category;
import com.F5.ALSports.repository.CategoryRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse saveCategory(CategoryRequest categoryRequest) {
        Category newCategory = CategoryMapper.dtoToEntity(categoryRequest);
        Category saveCategory = categoryRepository.save(newCategory);
        return CategoryMapper.EntityToDto(saveCategory);
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

    public Category updateCategory(int id, Category updateCategory) {
        Optional<Category> foundCategory = categoryRepository.findById(id);

        if (foundCategory.isPresent()) {
            Category existingCategory = foundCategory.get();

            existingCategory.setName(updateCategory.getName());

            return categoryRepository.save(existingCategory);
        }

        throw new RuntimeException("Category not found with id: " + id);
    }

    public List<CategoryResponse> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()) throw  new EmptyException();
        return categories.stream().map(category -> CategoryMapper.EntityToDto(category)).toList();
    }

}
