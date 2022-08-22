package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	private static List<Product> list = new ArrayList<>();
	
	static {
		list.add(new Product(1, "A", 10, 100));
		list.add(new Product(2, "B", 20, 200));
		list.add(new Product(3, "C", 30, 300));
		list.add(new Product(4, "D", 50, 400));
		list.add(new Product(5, "E", 50, 500));
	}
	
	@Override
	public void add(Product product) {
		list.add(product);
	}
	
	@Override
	public void remove(int  productId) {
		list.removeIf(item->item.getProductId() == productId);
	}
	
	@Override
	public void update(Product product) {
		for (int i = 0; i < list.size(); i++) {
			Product item = list.get(i);
			if(item.getProductId() == product.getProductId()) {
				list.set(i,product);
				break;
			}
		}
	}
	
	@Override
	public List<Product> finAll(){
		return list;
	}
	
	@Override
	public Product finById(int productId) {
		Optional<Product> opt = list.stream().filter(item->item.getProductId() == productId).findFirst();
		
		if(opt.isPresent()) {
			return opt.get();
		}
		
		return null;
	}
}
