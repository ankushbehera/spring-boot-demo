package com.ankush.springbootdemo.rest;

import com.ankush.springbootdemo.model.Product;
import com.ankush.springbootdemo.services.ReactiveProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v2/product")
public class ReactiveProductController {
    @Autowired
    private ReactiveProductService reactiveProductService;

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> createProduct(@PathVariable int id, @RequestBody Product product){
        return reactiveProductService.save(product,id);
    }

    @GetMapping
    public Flux<Product> getAllProducts(){
        return reactiveProductService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable int id){
        return reactiveProductService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProductById(@PathVariable int id){
        return reactiveProductService.deleteProductById(id);
    }

}
