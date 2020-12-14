package com.ankush.springbootdemo.model;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.io.Serializable;

@Document
@Getter
@Setter
public class Product {
    @Id
    private int id;
    private String title;
}