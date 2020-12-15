package com.ankush.springboot.demo.rest;

import com.ankush.springboot.demo.api.model.ProductModel;
import com.ankush.springboot.demo.api.resource.ProductApi;
import com.ankush.springboot.demo.model.Product;
import com.ankush.springboot.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductApiImpl implements ProductApi {

    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<ProductModel> createProduct(@Valid ProductModel body) {
        productService.save(Product.builder().id(body.getId()).title(body.getTitle()).build(), body.getId());
        return new ResponseEntity<>(
                body,
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductModel>> listProduct() {
        List<ProductModel> productModels = productService.getAllProducts().stream()
                .map(product -> new ProductModel().id(product.getId()).title(product.getTitle())).collect(Collectors.toList());

        return new ResponseEntity<>(
                productModels,
                HttpStatus.OK);

    }
}
