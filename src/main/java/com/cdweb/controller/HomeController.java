package com.cdweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdweb.model.Cart;
import com.cdweb.model.Category;
import com.cdweb.model.Product;
import com.cdweb.repository.CommentRepository;
import com.cdweb.repository.PostRepository;
import com.cdweb.repository.ProductRepository;
import com.cdweb.service.AccountService;
import com.cdweb.service.CategoryService;
import com.cdweb.service.OrderProductService;
import com.cdweb.service.OrderService;
import com.cdweb.service.ProductImageService;
import com.cdweb.service.ProductService;
import com.cdweb.service.ProductService2;

@Controller("usercontroller")
public class HomeController {

	@Autowired
	AccountService accountService;
	@Autowired
	ProductService productService;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderProductService orderProductService;
	@Autowired
	ProductImageService productImageService;
	@Autowired
	ProductService2 productService2;
	@Autowired
	CategoryService categoryService;
	@Autowired
	PostRepository postRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	Cart cart;
	// test
	@Autowired
	ProductRepository productRepository;
	
	
	@RequestMapping(value = "/")
	public String IndexPage(Model model, HttpSession session) {
		List<Product> productList = productService.findAll();
		model.addAttribute("productList", productList);

		List<Category> categoryList = categoryService.findAll();
		session.setAttribute("categoryList", categoryList);

		return "index";
	}


//	@RequestMapping(value = "/payment-form")
//	public String paymentForm(Model model, HttpServletRequest request) {
//		model.addAttribute("paymentForm", new Order());
//		List<Product> productList = cart.getProductList();
//		for (Product p : productList) {
//			System.out.println("ten san pham : " + p.getName());
//			int soLuong = Integer.parseInt(request.getParameter(String.valueOf(p.getId())));
//			cart.getProductAmountList().add(soLuong);
//			System.out.println("so luong san pham : " + soLuong);
//		}
//		return "payment";
//	}
//
//	@RequestMapping(value = "/perform-payment")
//	public String paymentForm(@ModelAttribute("paymentForm") Order paymentForm) {
//		Order order1 = new Order();
//		order1.setUserName(paymentForm.getUserName());
//		order1.setEmail(paymentForm.getEmail());
//		order1.setAddress(paymentForm.getAddress());
//		order1.setCity(paymentForm.getCity());
//
//		orderService.save(order1);
//
//		List<Product> productList = cart.getProductList();
//		List<Integer> productAmountList = cart.getProductAmountList();
//
//		Set<OrderProduct> listOrderProduct1 = new HashSet<OrderProduct>();
//		;
//		Set<OrderProduct> listOrderProduct2;
//		for (Product p : productList) {
//			Product product1 = productService.findById(p.getId());
//
//			OrderProduct orPro = new OrderProduct();
//			orPro.setId(new OrderProductId());
//			orPro.setOrder(order1);
//			orPro.setProduct(product1);
//			orPro.setAmount(productAmountList.get(productList.indexOf(p)));
//
//			listOrderProduct1.add(orPro);
//			listOrderProduct2 = new HashSet<OrderProduct>();
//			listOrderProduct2.add(orPro);
//			product1.setListOrder(listOrderProduct2);
//			orderProductService.save(orPro);
//		}
//
//		orderService.save(order1);
//
//		return "index";
//	}
}
