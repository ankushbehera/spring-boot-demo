package com.ankush.springbootdemo.rest;

import com.ankush.springbootdemo.model.*;
import com.ankush.springbootdemo.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> createProduct(@PathVariable int id, @RequestBody Product product){
        return productService.save(product,id);
    }

    @GetMapping
    public Flux<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProductById(@PathVariable int id){
        return productService.deleteProductById(id);
    }

}
