package com.ankush.springboot.demo.rest;

import com.ankush.springboot.demo.model.Product;
import com.ankush.springboot.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@PathVariable int id, @RequestBody Product product){
        return productService.save(product,id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id){
        productService.deleteProductById(id);
    }

}
