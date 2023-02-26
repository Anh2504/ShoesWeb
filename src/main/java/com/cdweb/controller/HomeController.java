package com.cdweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*import com.cdweb.model.Account;

import com.cdweb.model.LoginModel;
import com.cdweb.model.Order;
import com.cdweb.model.OrderDetail;

import com.cdweb.model.RegisterResponse;
import com.cdweb.repository.OrderDetailRepository;
import com.cdweb.repository.OrderRepository;
import com.cdweb.service.AccountService;
import com.cdweb.service.ProductImageService; */
import com.cdweb.service.ProductService;
import com.cdweb.model.Product;

@Controller
public class HomeController {

	
//	  @Autowired OrderRepository orderRepository;
//	  
//	  @Autowired OrderDetailRepository orderDetailRepository;
//	  
//	  @Autowired AccountService accountService;
	  
	  @Autowired ProductService productService;
	  
//	  @Autowired ProductImageService productImageService;
	 
	
	
	

	
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

	
	@RequestMapping("/welcome1")
	public String page2() {
		Product p1 = productService.findById(1);
		System.out.println(p1.getName());
		System.out.println(p1.getPrice());
		System.out.println(p1.getContent());
		System.out.println(p1.getImage());
		return "welcome";
	}
	

	

	

	

	
}
