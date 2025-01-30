package com.F5.ALSports.service;

import com.F5.ALSports.model.Category;
import com.F5.ALSports.model.Product;
import com.F5.ALSports.repository.CategoryRepository;
import com.F5.ALSports.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product addProduct(Product newProduct){
        int categoryId = newProduct.getCategory().getId();
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            newProduct.setCategory(category);
            return productRepository.save(newProduct);
        }
        throw  new RuntimeException("Category not found");
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
