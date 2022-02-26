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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdweb.model.Account;

import com.cdweb.model.LoginModel;
import com.cdweb.model.Product;
import com.cdweb.model.RegisterResponse;
import com.cdweb.service.AccountService;
import com.cdweb.service.ProductImageService;
import com.cdweb.service.ProductService;

@Controller
public class RegisterController {
	
	
	@Autowired
	AccountService accountService;
	@Autowired
	ProductService productService;
	@Autowired
	ProductImageService productImageService;
	
	
	@RequestMapping(value="/account-register", produces="text/plain;charset=UTF-8")
	public String accountRegister(Model model) {
		model.addAttribute("account", new Account());
		model.addAttribute("loginModel", new LoginModel());
		return "account";
	}
	
//	@RequestMapping(value="/account-registered",produces="text/plain;charset=UTF-8")
//	public String accountRegistered(@ModelAttribute("account")Account account) {
//		accountService.addAccount(account);
//		System.out.println(account.getEmail());
//		System.out.println(account.getPassword());
//		return "index";
//	}
	
	@PostMapping(value = "/account-registered", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public RegisterResponse register(@ModelAttribute @Valid Account account,
                                        BindingResult result) {
 
        RegisterResponse response = new RegisterResponse();
        System.out.println(account.getAddress());
        System.out.println(account.getEmail());
        System.out.println(account.getPhone());
 
        if (result.hasErrors()) {
 
            Map<String, String> errors = result.getFieldErrors().stream()
                    .collect(
                            Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                    );
 
            response.setValidated(false);
            response.setErrorMessages(errors);
        } else {
 
        	accountService.addAccount(account);
            response.setValidated(true);
        }
        return response;
    }
	
	//*****************************************************//
	
	
	
	
	
	

}
