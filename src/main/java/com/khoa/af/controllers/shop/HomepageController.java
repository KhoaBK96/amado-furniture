package com.khoa.af.controllers.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khoa.af.api.admin.Product;
import com.khoa.af.service.ProductService;

@Controller
public class HomepageController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String showHomePage(Model model) {
		
		List<Product> productList = productService.loadProduct();
		
		model.addAttribute("products", productList);
		
		return "shop/index";
	}
	
}
