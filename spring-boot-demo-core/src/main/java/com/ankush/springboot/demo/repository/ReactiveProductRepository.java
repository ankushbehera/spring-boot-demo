package com.ankush.springboot.demo.repository;


import com.ankush.springboot.demo.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveProductRepository extends ReactiveMongoRepository<Product, Integer> {
}