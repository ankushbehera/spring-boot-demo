package com.ankush.springbootdemo.services;


import com.ankush.springbootdemo.model.Product;
import com.ankush.springbootdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product save(Product product, int id) {
        if(id == 0)
            id = Math.abs(new Random().nextInt());
        product.setId(id);
        productRepository.save(product);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }
}