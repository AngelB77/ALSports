package com.F5.ALSports.dto.category;

import com.F5.ALSports.dto.products.ProductResponse;


import java.util.List;

public record CategoryResponse(
        String name,
        List<ProductResponse> products
){
}