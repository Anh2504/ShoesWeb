package com.cdweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdweb.model.Cart;
import com.cdweb.model.Product;
import com.cdweb.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	Cart cart;
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/addtocart/{product_id}")
	public String addToCart(@PathVariable int product_id,Model model) {
		Product product = productService.findById(product_id);
		cart.addToCart(product);
		model.addAttribute("cart", cart);
		return "cart";
	}
}
