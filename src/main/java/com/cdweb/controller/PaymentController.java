package com.cdweb.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdweb.model.Cart;
import com.cdweb.model.Order;
import com.cdweb.model.OrderProduct;
import com.cdweb.model.OrderProductId;
import com.cdweb.model.Product;
import com.cdweb.service.OrderProductService;
import com.cdweb.service.OrderService;
import com.cdweb.service.ProductService;

@Controller
public class PaymentController {
	@Autowired
	Cart cart;
	@Autowired
	OrderService orderService;
	@Autowired
	ProductService productService;
	@Autowired
	OrderProductService orderProductService;
	
	@RequestMapping(value = "/payment-form")
	public String paymentForm(Model model, HttpServletRequest request) {
		model.addAttribute("paymentForm", new Order());
		
		List<Product> productList = cart.getProductList();
		for (Product p : productList) {
			System.out.println("ten san pham : " + p.getName());
			// request parameter name is product id 
			int soLuong = Integer.parseInt(request.getParameter(String.valueOf(p.getId())));
			cart.getProductAmountList().add(soLuong);
			System.out.println("so luong san pham : " + soLuong);
			System.out.println("********************************");
		}
		
		for(int i = 0; i < cart.getProductList().size(); i++) {
			System.out.println("san pham " + i + " : " + cart.getProductList().get(i).getName());
		}
		
		model.addAttribute("productList",productList);
		return "payment";
	}

	@RequestMapping(value = "/perform-payment")
	public String paymentForm(@ModelAttribute("paymentForm") Order paymentForm) {
		Order order1 = new Order();
		order1.setUserName(paymentForm.getUserName());
		order1.setEmail(paymentForm.getEmail());
		order1.setAddress(paymentForm.getAddress());
		order1.setCity(paymentForm.getCity());

		orderService.save(order1);

		List<Product> productList = cart.getProductList();
		List<Integer> productAmountList = cart.getProductAmountList();

		Set<OrderProduct> listOrderProduct1 = new HashSet<OrderProduct>();
		;
		Set<OrderProduct> listOrderProduct2;
		for (Product p : productList) {
			Product product1 = productService.findById(p.getId());

			OrderProduct orPro = new OrderProduct();
			orPro.setId(new OrderProductId());
			orPro.setOrder(order1);
			orPro.setProduct(product1);
			orPro.setAmount(productAmountList.get(productList.indexOf(p)));

			listOrderProduct1.add(orPro);
			listOrderProduct2 = new HashSet<OrderProduct>();
			listOrderProduct2.add(orPro);
			product1.setListOrder(listOrderProduct2);
			orderProductService.save(orPro);
		}

		orderService.save(order1);

		return "index";
	}
}
