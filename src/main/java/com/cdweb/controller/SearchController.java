package com.cdweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdweb.model.Product;
import com.cdweb.service.ProductService;

@Controller
public class SearchController {
	@Autowired
	ProductService productService;
	public static final int PAGE_SIZE = 4;

	// display product by search
	@PostMapping(value = "/search_product")
	public String productByType1(Model model, HttpServletRequest request, HttpSession session) {

		String searchValue = request.getParameter("search-box");
		System.out.println("gia tri search : " + searchValue);
		List<Product> entireList = productService.findByNameContaining(searchValue);
		// first page product
		Page<Product> page = productService.findAllByNameContaining(searchValue, 0, PAGE_SIZE);
		List<Product> productList = page.getContent();
		int totalPage = productService.getTotalPage(entireList, PAGE_SIZE);
		System.out.println("So san pham tim duoc : " + productList.size());

		model.addAttribute("productList", productList);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("searchValue", searchValue);

		int pageIndex = 1;
		model.addAttribute("pageIndex", pageIndex);
		return "search_product";
	}

	// product search pagination
	@RequestMapping(value = "/search_product/{pageIndex}")
	public String productByType1(@PathVariable int pageIndex, Model model, HttpSession session) {

		List<Product> entireList = productService.findByNameContaining((String) session.getAttribute("searchValue"));
		Page<Product> page = productService.findAllByNameContaining((String) session.getAttribute("searchValue"),
				pageIndex - 1, PAGE_SIZE);
		List<Product> productList = page.getContent();
		int totalPage = productService.getTotalPage(entireList, PAGE_SIZE);

		model.addAttribute("productList", productList);
		model.addAttribute("totalPage", totalPage);
		return "search_product";
	}

	// autocomplete search
	@RequestMapping(value = "/autocomplete_search/{value}", produces = "text/plain;charset=UTF-8")
	public String autocompleteSearch(@PathVariable String value, Model model) {
		System.out.println("value : " + value);
		List<Product> productList = productService.findByNameContaining(value);
		model.addAttribute("productList", productList);
		return "search_product";
	}

	// autocomplete link
	@PostMapping(value = "/ajax")
	@ResponseBody
	public Map<String, String> ajax(HttpServletRequest request) {
		System.out.println(request.getParameter("searchVal"));
		List<Product> productList = productService.findTop5ByNameContaining(request.getParameter("searchVal"));
		Map<String, String> productMap = new HashMap<String, String>();

		for (int i = 0; i < 5; i++) {
			int j = productList.size();
			if (i >= j) {
				productMap.put("variable" + i, null);
			} else {
				String productName = productList.get(i).getName();
				productMap.put("variable" + i, productName);
			}
		}
		System.out.println("Ket qua : " + productMap);
		return productMap;
	}
}
