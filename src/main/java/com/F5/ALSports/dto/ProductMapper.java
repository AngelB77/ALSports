package com.F5.ALSports.dto;

import com.F5.ALSports.model.Category;
import com.F5.ALSports.model.Product;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ProductMapper {
    public static Product dtoToEntity(ProductRequest productRequest) {
        return new Product(productRequest.name(), productRequest.price(),
          productRequest.ImageUrl());
    }
    public static ProductResponse entityTodto(Product product) {
        return new ProductResponse(product.getName(), //product.getPrice(),
                product.getImageUrl());

        }
    }

