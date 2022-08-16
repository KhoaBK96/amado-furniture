package com.khoa.af.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khoa.af.api.admin.Category;
import com.khoa.af.api.admin.Product;
import com.khoa.af.service.CategoryService;
import com.khoa.af.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/admin/product")
	public String showProduct(Model model) {
		
		List<Product> productList = productService.loadProduct();
		
		System.out.println(productList);
		
		model.addAttribute("products", productList);
		
		return "admin/product-list";
	}
	
	@GetMapping("/admin/addProduct")
	public String addProduct(Model model) {
		
		Product product = new Product();
		
		List<Category> categoryList = categoryService.loadCategory();
		
		model.addAttribute("product", product);
		
		model.addAttribute("categories", categoryList);
		
		return "admin/add-product";
		
	}
	
	@PostMapping("/admin/save-product")
	public String saveProduct(Product product) {
		
		if(product.getId() == 0) {
			
			productService.saveProduct(product);
			
		}else {
			
			productService.updateProduct(product);
			
		}
		
		
		return "redirect:/admin/product";
	}
	
	@GetMapping("/admin/updateProduct")
	public String updateProduct(@RequestParam("productId") int id, Model model) {
		
		Product product = productService.getProduct(id);
		
		List<Category> categoryList = categoryService.loadCategory();
		
		model.addAttribute("product", product);
		
		model.addAttribute("categories", categoryList);
		
		return "admin/add-product";
		
	}
	
	@ResponseBody
	@PostMapping("/admin/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int id) {
		
		boolean result = productService.deleteProduct(id);
		
		return String.valueOf(result);
		
	}
}
