package com.cdweb.controller.admin;

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
import com.cdweb.repository.ProductRepository;
import com.cdweb.service.ProductImageService;
import com.cdweb.service.ProductService;
import com.cdweb.service.ProductService2;

@Controller("admincontroller")
public class HomeController {
	
	@Autowired
	ProductService productService;
	@Autowired
	ProductService2 productService2;
	
	// test
	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping(value = "/testaddproduct")
	public String addproducttest() {
		Product product = new Product();
		
		product.setName("kgjsldgjdslkgj");
		product.setPrice(100000);
		product.setContent(null);
		product.setImage(null);
		
		//productService2.addProduct(product);
		productRepository.save(product);
		return "dashboard";
	}
	
	@RequestMapping(value = "/admin")
	public String admin() {

		return "admin/dashboard";
	}
	
	
	
	@RequestMapping(value = "/table")
	public String table(Model model) {
		ArrayList<Product> productList = productService2.findNext1();
    	model.addAttribute("productList", productList);
    	return "admin/table";
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
		return "admin/table";
	}
	// xoa san pham
	@RequestMapping(value="/deleteproduct/{id}")
	public String delete(@PathVariable int id, Model model) {
		productService2.deleteProduct(id);
		ArrayList<Product> productList = productService2.findNext1();
    	model.addAttribute("productList", productList);
    	return "admin/table";
	}
	
	// them san pham
	
	@RequestMapping(value = "/addproduct")
	public String addproduct(Model model) {
		model.addAttribute("productForm", new ProductForm());
		return "admin/add_form";
	}
	
	@RequestMapping(value = "/addedproduct", method=RequestMethod.POST)
	public String addedproduct(@ModelAttribute("productForm") ProductForm productForm) {
		Product product = new Product();
		System.out.println("ID la :" + productForm.getId());
		System.out.println("Name la :" + productForm.getName());
		System.out.println("Price la :" + productForm.getPrice());
		product.setId(productForm.getId());
		product.setName(productForm.getName());
		product.setPrice(productForm.getPrice());
		product.setContent(null);
		product.setImage(null);
		productService2.addProduct(product);
		return "admin/dashboard";
	}
	
	// Sua san pham
	
	@RequestMapping(value = "/editForm")
	public String editForm(Model model) {
		model.addAttribute("productForm", new ProductForm());
		return "admin/edit_form";
	}
	
	@RequestMapping(value = "/editProduct", method=RequestMethod.POST)
	public String editProduct(@ModelAttribute("productForm") ProductForm productForm) {
		Product product = new Product();
		System.out.println("ID la :" + productForm.getId());
		System.out.println("Name la :" + productForm.getName());
		System.out.println("Price la :" + productForm.getPrice());
		product.setId(productForm.getId());
		product.setName(productForm.getName());
		product.setPrice(productForm.getPrice());
		product.setContent(null);
		product.setImage(null);
		productService2.addProduct(product);
		return "admin/dashboard";
	}
}
