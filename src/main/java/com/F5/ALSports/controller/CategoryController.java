package com.F5.ALSports.controller;

import com.F5.ALSports.model.Category;
import com.F5.ALSports.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
