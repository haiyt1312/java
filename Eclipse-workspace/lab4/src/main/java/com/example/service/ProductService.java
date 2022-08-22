package com.example.service;

import java.util.List;

import com.example.model.Product;

public interface ProductService {

	List<Product> finAll();

	void update(Product product);

	void remove(int  productId);

	void add(Product product);

	Product finById(int productId);

}
