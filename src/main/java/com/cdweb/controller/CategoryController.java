package com.cdweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cdweb.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;
}
