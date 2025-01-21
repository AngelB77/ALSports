package com.F5.ALSports.controller;


import com.F5.ALSports.model.Product;
import com.F5.ALSports.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @PostMapping("/products")
    public void creteProduct(@RequestBody Product newProduct) {
        productService.addProduct(newProduct);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
