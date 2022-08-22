package com.example.myshop.service;

import com.example.myshop.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    <S extends Product> S save(S entity);

    Optional<Product> findById(Integer integer);

    void deleteById(Integer integer);

    List<Product> findByName(String name);


}
