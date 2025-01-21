package com.F5.ALSports.service;

import com.F5.ALSports.model.Product;
import com.F5.ALSports.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product addProduct(Product newProduct){
        return productRepository.save(newProduct);
    }
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }


}
