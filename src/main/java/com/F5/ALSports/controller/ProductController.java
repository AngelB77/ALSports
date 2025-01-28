package com.F5.ALSports.controller;


import com.F5.ALSports.model.Product;
import com.F5.ALSports.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable int id) {
        Optional<Product> foundProduct = productService.findProduct(id);

        if(foundProduct.isPresent()) {
            return new ResponseEntity<>(foundProduct.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody  Product
            updatedProduct) {

        try {
            //actualizar los campos del product en el caso de que encuentre
            Product product = productService.updatedProduct(id, updatedProduct);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            //En el caso de que no se encuentre devuelve no found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
