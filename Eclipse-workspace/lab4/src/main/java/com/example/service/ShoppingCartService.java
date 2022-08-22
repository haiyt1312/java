package com.example.service;

import java.util.Collection;

import com.example.model.CartItem;

public interface ShoppingCartService {

	int getCount();

	double getAmount();

	void update(int productId, int quantity);

	void clear();

	Collection<CartItem> getCartItems();

	void remove(int productId);

	void add(CartItem item);
	
}
