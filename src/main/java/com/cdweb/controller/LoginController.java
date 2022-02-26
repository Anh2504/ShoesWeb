package com.cdweb.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdweb.model.Account;
import com.cdweb.model.LoginModel;
import com.cdweb.model.LoginResponse;
import com.cdweb.model.Product;
import com.cdweb.model.RegisterResponse;
import com.cdweb.service.AccountService;
import com.cdweb.service.ProductImageService;
import com.cdweb.service.ProductService;

@Controller
public class LoginController {

	@Autowired
	AccountService accountService;
	@Autowired
	ProductService productService;
	@Autowired
	ProductImageService productImageService;

	@RequestMapping(value = "/account-login", produces = "text/plain;charset=UTF-8")
	public String accountLogin(Model model) {
		model.addAttribute("loginModel", new LoginModel());
		model.addAttribute("account", new Account());
		return "account";
	}

	@RequestMapping(value = "/account-logined", produces = "text/plain;charset=UTF-8")
	public String accountLogined(@ModelAttribute("loginModel") LoginModel loginModel, HttpSession session,
			Model model) {
		String email = loginModel.getEmail();
		String password = loginModel.getPassword();
		System.out.println(loginModel.getEmail());
		System.out.println(loginModel.getPassword());

		if (accountService.checkLogin(email, password) == true) {
			boolean loginStatus = true;
			session.setAttribute("loginStatus", loginStatus);
			session.setAttribute("username", email);
			ArrayList<Product> productList = productService.findAll();
			model.addAttribute("productList", productList);
			return "index";
		} else {
			model.addAttribute("loginModel", new LoginModel());
			//model.addAttribute("account", new Account());
			return "account";
		}

	}
	
	
}
