package com.ankush.springbootdemo.services;

import com.ankush.springbootdemo.model.*;
import com.ankush.springbootdemo.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import reactor.core.publisher.*;

import java.time.*;
import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> save(Product product, int id) {
        if(id == 0)
            id = Math.abs(new Random().nextInt());
        product.setId(id);
        return productRepository.save(product).delayElement(Duration.ofMillis(1));
    }

    public Mono<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Mono<Void> deleteProductById(int id) {
        return productRepository.deleteById(id);
    }
}