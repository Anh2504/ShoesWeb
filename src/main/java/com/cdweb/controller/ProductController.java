package com.cdweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdweb.model.Category;
import com.cdweb.model.Product;
import com.cdweb.model.ProductImage;
import com.cdweb.service.CategoryService;
import com.cdweb.service.ProductImageService;
import com.cdweb.service.ProductService;
import com.cdweb.service.ProductService2;

@Controller
public class ProductController {
	
	//private static final Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	@Autowired
	ProductService2 productService2;
	@Autowired
	ProductImageService productImageService;
	@Autowired
	CategoryService categoryService;
	
	public static final int PAGE_SIZE = 4;
	
	@RequestMapping(value = "/index")
	public String IndexPage(Model model) {
		List<Product> entireList = productService.findAll();
		Page<Product> page = productService.findAll(0,PAGE_SIZE);
		List<Product> productList = page.getContent();
		int totalPage = productService.getTotalPage(entireList, PAGE_SIZE); 
		
		model.addAttribute("productList", productList);
		model.addAttribute("totalPage", totalPage);
		
		int pageIndex = 1;
		model.addAttribute("pageIndex", pageIndex);
		return "index";
	}

	@RequestMapping(value = "/product")
	public String product(Model model) {
		List<Product> entireList = productService.findAll();
		Page<Product> page = productService.findAll(0,PAGE_SIZE);
		List<Product> productList = page.getContent();
		int totalPage = productService.getTotalPage(entireList, PAGE_SIZE); 
		
		model.addAttribute("productList", productList);
		model.addAttribute("totalPage", totalPage);
//		logger.debug("debug log");
//	    logger.error("error log");
//	    logger.info("info log");
		int pageIndex = 1;
		model.addAttribute("pageIndex", pageIndex);
		return "product";
	}
	// product pagination
	@RequestMapping(value = "/product/{pageIndex}")
	public String productByType1(@PathVariable int pageIndex, Model model, HttpSession session) {

		List<Product> entireList = productService.findAll();
		Page<Product> page = productService.findAll(pageIndex - 1, PAGE_SIZE);
		List<Product> productList = page.getContent();
		int totalPage = productService.getTotalPage(entireList, PAGE_SIZE);

		model.addAttribute("productList", productList);
		model.addAttribute("totalPage", totalPage);
		return "product";
	}
	
	// display product by category and sex
	@RequestMapping(value = "/product/{sex}/{id}")
	public String productByType(@PathVariable String sex, @PathVariable long id, Model model) {
		Category category = categoryService.findById(id);
		List<Product> entireList = productService.findBySexContainingAndCategory(sex, category);
		// first page product
		Page<Product> page = productService.findAllBySexContainingAndCategory(sex, category, 0, PAGE_SIZE);
		List<Product> productList = page.getContent();
		int totalPage = productService.getTotalPage(entireList, PAGE_SIZE);
		
		model.addAttribute("productList", productList);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("sex",sex);
		model.addAttribute("id",id);
		int pageIndex = 1;
		model.addAttribute("pageIndex",pageIndex);
		System.out.println("tong so trang : "+totalPage);
		System.out.println("tong so san pham : "+productService.findBySexContainingAndCategory(sex, category).size());
		return "product_by_category";
	}
	
	// product pagination
	@RequestMapping(value = "/product/{sex}/{id}/{pageIndex}")
	public String productByType(@PathVariable String sex, @PathVariable long id, @PathVariable int pageIndex, Model model) {
		
		Category category = categoryService.findById(id);
		List<Product> entireList = productService.findBySexContainingAndCategory(sex, category);
		Page<Product> page = productService.findAllBySexContainingAndCategory(sex, category, pageIndex-1, PAGE_SIZE);
		List<Product> productList = page.getContent();
		int totalPage = productService.getTotalPage(entireList, PAGE_SIZE);
		
		model.addAttribute("productList",productList);
		model.addAttribute("totalPage", totalPage);
		return "product_by_category";
	}

	
	
	// product detail page
	@RequestMapping(value = "/productdetail/{id}")
	public String productDetail(@PathVariable long id, Model model) {
		ProductImage productImage = productImageService.findById(id);
		Product product = productService.findById(id);
		model.addAttribute("productImage", productImage);
		model.addAttribute("product", product);
		return "product_detail";
	}
	
	
		
		
}
