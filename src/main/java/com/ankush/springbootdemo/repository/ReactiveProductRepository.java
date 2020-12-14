package com.ankush.springbootdemo.repository;


import com.ankush.springbootdemo.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveProductRepository extends ReactiveMongoRepository<Product, Integer> {
}