package com.F5.ALSports.dtosCategory;

import com.F5.ALSports.model.Category;

public class CategoryMapper {
    public static Category dtoToEntity(CategoryRequest categoryRequest) {
        return new Category(categoryRequest.name());
    }

    public static CategoryResponse categoryToDto(Category category) {
        return new CategoryResponse(category.getName());
    }
}