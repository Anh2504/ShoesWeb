package com.cdweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdweb.model.Account;
import com.cdweb.model.LoginModel;
import com.cdweb.model.Product;
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
	
	@RequestMapping("/account")
	public String acount() {
		return "account";
	}
	@RequestMapping(value = "/login", produces = "text/plain;charset=UTF-8")
	public String accountLogin(Model model) {
		model.addAttribute("loginModel", new LoginModel());
		model.addAttribute("account", new Account());
		return "account";
	}

	@RequestMapping(value = "/perform_login", produces = "text/plain;charset=UTF-8")
	public String accountLogined(@ModelAttribute("loginModel") LoginModel loginModel, HttpSession session,
			Model model) {
		String email = loginModel.getEmail();
		String password = loginModel.getPassword();

		if (accountService.checkLogin(email, password) == true) {
			boolean loginStatus = true;
			session.setAttribute("loginStatus", loginStatus);
			session.setAttribute("username", email);
			List<Product> productList = productService.findAll();
			model.addAttribute("productList", productList);
			return "index";
		} else {
			model.addAttribute("loginModel", new LoginModel());
			model.addAttribute("account", new Account());
			model.addAttribute("error","Sai tên đăng nhập hoặc mật khẩu");
			return "account";
		}

	}
	
	@RequestMapping(value = "/logout", produces = "text/plain;charset=UTF-8")
	public String logOut(HttpSession session, Model model) {
		session.setAttribute("loginStatus", false);
		model.addAttribute("loginModel", new LoginModel());
		model.addAttribute("account", new Account());
		return "account";
	}
}
