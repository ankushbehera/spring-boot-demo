package com.ankush.springboot.demo.services;


import com.ankush.springboot.demo.model.Product;
import com.ankush.springboot.demo.repository.ReactiveProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;

@Service
public class ReactiveProductService {

    @Autowired
    private ReactiveProductRepository reactiveProductRepository;

    public Flux<Product> getAllProducts() {
        return reactiveProductRepository.findAll();
    }

    public Mono<Product> save(Product product, int id) {
        if(id == 0)
            id = Math.abs(new Random().nextInt());
        product.setId(id);
        return reactiveProductRepository.save(product).delayElement(Duration.ofMillis(1000));
    }

    public Mono<Product> getProductById(int id) {
        return reactiveProductRepository.findById(id);
    }

    public Mono<Void> deleteProductById(int id) {
        return reactiveProductRepository.deleteById(id);
    }
}