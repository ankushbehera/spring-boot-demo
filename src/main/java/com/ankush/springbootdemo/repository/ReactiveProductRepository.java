package com.ankush.springbootdemo.repository;

import com.ankush.springbootdemo.model.*;
import org.springframework.data.repository.reactive.*;
import org.springframework.stereotype.*;

@Repository
public interface ReactiveProductRepository extends ReactiveCrudRepository<Product, Integer> {
}