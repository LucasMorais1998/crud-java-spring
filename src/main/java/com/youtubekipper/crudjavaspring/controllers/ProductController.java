package com.youtubekipper.crudjavaspring.controllers;

import com.youtubekipper.crudjavaspring.domain.product.Product;
import com.youtubekipper.crudjavaspring.repositories.ProductRepository;
import com.youtubekipper.crudjavaspring.domain.product.ProductRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProducts() {
        var allProducts = repository.findAllByActiveTrue();

        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid ProductRequestDTO data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid ProductRequestDTO data) {
        Optional<Product> optionalProduct = repository.findById(data.id());

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            product.setName(data.name());
            product.setPrice(data.price());

            return ResponseEntity.ok(product);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable String id) {
        Optional<Product> optionalProduct = repository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setActive(false);

            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
