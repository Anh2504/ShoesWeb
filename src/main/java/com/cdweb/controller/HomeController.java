package com.cdweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdweb.model.Product;
import com.cdweb.model.ProductForm;
import com.cdweb.service.AccountService;
import com.cdweb.service.ProductImageService;
import com.cdweb.service.ProductService;
import com.cdweb.service.ProductService2;

@Controller
public class HomeController {

//	@Autowired
//	OrderRepository orderRepository;
//	@Autowired
//	OrderDetailRepository orderDetailRepository;

	@Autowired
	AccountService accountService;
	@Autowired
	ProductService productService;
	@Autowired
	ProductImageService productImageService;
	@Autowired
	ProductService2 productService2;
	
	@RequestMapping(value = "/testaddproduct")
	public String addproducttest() {
		Product product = new Product();
		
		product.setName("oooooooooooooooooooo");
		product.setPrice(999999);
		product.setContent(null);
		product.setImage(null);
		
		productService2.addProduct(product);
		return "dashboard";
	}
	
	@RequestMapping(value = "/admin")
	public String admin() {

		return "dashboard";
	}
	
	@RequestMapping(value = "/table")
	public String table(Model model) {
		ArrayList<Product> productList = productService2.findNext1();
    	model.addAttribute("productList", productList);
    	return "table";
	}
	@RequestMapping(value="/table/{id}")
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
		return "table";
	}
	// xoa san pham
	@RequestMapping(value="/deleteproduct/{id}")
	public String delete(@PathVariable int id, Model model) {
		productService2.deleteProduct(id);
		ArrayList<Product> productList = productService2.findNext1();
    	model.addAttribute("productList", productList);
    	return "table";
	}
	
	// them san pham
	
	@RequestMapping(value = "/addproduct")
	public String addproduct(Model model) {
		model.addAttribute("productForm", new ProductForm());
		return "add_form";
	}
	
	@RequestMapping(value = "/addedproduct", method=RequestMethod.POST)
	public String addedproduct(@ModelAttribute("productForm") ProductForm productForm) {
		Product product = new Product();
		System.out.println("ID :" + productForm.getId());
		System.out.println("ID :" + productForm.getName());
		System.out.println("ID :" + productForm.getPrice());
		product.setId(productForm.getId());
		product.setName(productForm.getName());
		product.setPrice(productForm.getPrice());
		product.setContent(null);
		product.setImage(null);
		productService2.addProduct(product);
		return "admin";
	}
	
	@RequestMapping(value = "/trangchu")
	public String IndexPage() {

		return "index";
	}

//	@RequestMapping(value="/productdetail/{id}")
//	public String productDetail(@PathVariable int id, Model model) {
//		ProductImage productImage = productImageService.findById(id);
//		Product product = productService.findById(id);
//		model.addAttribute("productImage", productImage);
//		model.addAttribute("product", product);
//		return "product_detail";
//	}
//	
//	@RequestMapping(value="/trangchu1")
//    public String IndexPage1(Model model) {
//    	ArrayList<Product> productList = productService.findAll();
//    	model.addAttribute("productList", productList);
//    	return "index";
//    }

	

	

	@RequestMapping("/account")
	public String acount() {
		return "account";
	}

	

	

	

	

	

	
}
