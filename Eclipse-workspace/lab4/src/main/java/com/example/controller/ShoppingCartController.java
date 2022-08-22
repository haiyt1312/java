package com.example.controller;

import java.util.Collection;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.CartItem;
import com.example.model.Product;
import com.example.service.ProductService;
import com.example.service.ShoppingCartService;

@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController {
	@Autowired
	ProductService productService;

	@Autowired
	ShoppingCartService shoppingCartService;

	@GetMapping("list")
	public String list(Model model) {
		Collection<CartItem> cartItems = shoppingCartService.getCartItems();

		model.addAttribute("cartItems", cartItems);
		model.addAttribute("total", shoppingCartService.getAmount());
		model.addAttribute("NoOfItems", shoppingCartService.getCount());

		return "shoppingCart/list";
	}

	@GetMapping("add/{productId}")
	public String add(@PathVariable("productId") Integer productId) {
		Product product = productService.finById(productId);

		if (product != null) {
			CartItem item = new CartItem();
			BeanUtils.copyProperties(product, item);
			item.setQuantity(1);
			shoppingCartService.add(item);
		}

		return "redirect:/shoppingCart/list";
	}

	@GetMapping("remove/{productId}")
	public String remove(@PathVariable("productId") Integer producId) {
		shoppingCartService.remove(producId);

		return "redirect:/shoppingCart/list";
	}

	@PostMapping("update")
	public String update(@RequestParam("productId") Integer producId, @RequestParam("quantity") Integer quantity) {
		shoppingCartService.update(producId, quantity);
		
		return "redirect:/shoppingCart/list";
	}

	@GetMapping("clear")
	public String clear() {
		return "redirect:/shoppingCart/list";
	}
}
