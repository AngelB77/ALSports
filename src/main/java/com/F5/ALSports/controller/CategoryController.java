package com.F5.ALSports.controller;

import com.F5.ALSports.dtosCategory.CategoryRequest;
import com.F5.ALSports.dtosCategory.CategoryResponse;
import com.F5.ALSports.model.Category;
import com.F5.ALSports.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @PostMapping
    public void createCategory(@RequestBody Category newCategory){
        categoryService.addCategory(newCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable int id) {
        Optional<Category> foundCategory = categoryService.findCategory(id);

        if(foundCategory.isPresent()) {
            return new ResponseEntity<>(foundCategory.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category updatedCategory) {
        try {
            Category category = categoryService.updateCategory(id,updatedCategory);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Category not found with id: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        CategoryResponse newCategoryResponse = categoryService.saveCategory(categoryRequest);
        return  new ResponseEntity<>(newCategoryResponse,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }
}

