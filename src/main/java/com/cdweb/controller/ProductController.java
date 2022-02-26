package com.cdweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdweb.model.Product;
import com.cdweb.model.ProductImage;
import com.cdweb.service.ProductImageService;
import com.cdweb.service.ProductService;
import com.cdweb.service.ProductService2;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	@Autowired
	ProductService2 productService2;
	@Autowired
	ProductImageService productImageService;
	
	@RequestMapping(value="/productdetail/{id}")
	public String productDetail(@PathVariable int id, Model model) {
		ProductImage productImage = productImageService.findById(id);
		Product product = productService.findById(id);
		model.addAttribute("productImage", productImage);
		model.addAttribute("product", product);
		return "product_detail";
	}
	
	@RequestMapping(value="/product/{id}")
	public String product(@PathVariable int id, Model model) {
		ArrayList<Product> productList = productService2.findNext1();
		if(id==1) {
			productList = productService2.findNext1();
		}else if(id ==2) {
			productList = productService2.findNext2();
		}else if(id ==3) {
			productList = productService2.findNext3();
		}else if(id ==4) {
			productList = productService2.findNext4();
		}else {
			productList = productService2.findNext5();
		}
    	model.addAttribute("productList", productList);
		return "product";
	}
	
	@RequestMapping(value="/index")
    public String IndexPage(Model model) {
    	ArrayList<Product> productList = productService.findAll();
    	model.addAttribute("productList", productList);
    	return "index";
    }
	
	@RequestMapping(value="/product")
    public String product(Model model) {
    	ArrayList<Product> productList = productService2.findNext2();
    	model.addAttribute("productList", productList);
    	return "product";
    }
	
	@RequestMapping(value="/trangchu2")
    public String IndexPage2(Model model) {
    	List<Product> productList = productService2.findNext2();
    	model.addAttribute("productList", productList);
    	return "index";
    }
}
