package com.F5.ALSports.dto.category;

import com.F5.ALSports.dto.products.ProductMapper;
import com.F5.ALSports.dto.products.ProductResponse;
import com.F5.ALSports.model.Category;
import com.F5.ALSports.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static Category dtoToEntity(CategoryRequest categoryRequest) {
        return new Category(categoryRequest.name());
    }

    public static CategoryResponse EntityToDto(Category category) {
        List<ProductResponse> productDTO = category.getProducts().stream()
                .map(ProductMapper::entityTodto)
                .collect(Collectors.toList());
        return new CategoryResponse(category.getName(),productDTO);
    }
}