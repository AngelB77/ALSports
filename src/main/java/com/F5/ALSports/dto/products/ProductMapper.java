package com.F5.ALSports.dto.products;

import com.F5.ALSports.model.Category;
import com.F5.ALSports.model.Product;

public class ProductMapper {
    public static Product dtoToEntity(ProductRequest productRequest, Category category) {
        return new Product(productRequest.name(), productRequest.price(),
                productRequest.ImageUrl(),category);
    }
    public static ProductResponse entityTodto(Product product) {
        return new ProductResponse(product.getName(), //product.getPrice(),
                product.getImageUrl(),product.getCategory().getName());

    }
}
