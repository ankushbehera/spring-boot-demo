package com.ankush.springbootdemo.reactive.services;


import com.ankush.springbootdemo.model.Product;
import com.ankush.springbootdemo.reactive.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;

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