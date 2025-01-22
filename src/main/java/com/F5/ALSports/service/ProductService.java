package com.F5.ALSports.service;

import com.F5.ALSports.model.Product;
import com.F5.ALSports.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public Optional<Product> findProduct(int id) {
        return productRepository.findById(id);
    }

    public Product updatedProduct(int id, Product updatedProduct) {
        //Buscar producto por id
        Optional<Product> foundProduct = productRepository.findById(id);

        if(foundProduct.isPresent()) {
            Product existingProduct = foundProduct.get();

            //Actualizar los campos
            existingProduct.setName(updatedProduct.getName());

            //Guarda el producto
            return productRepository.save(existingProduct);

        }
        //Enviar mensaje al usuario
        throw new RuntimeException("Product not found with id: " + id);
    }
}
