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
import com.khoa.af.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/admin/category")
	public String showCategory(Model model) {

		List<Category> categoryList = categoryService.loadCategory();

		model.addAttribute("categories", categoryList);

		return "admin/category-list";
	}

	@GetMapping("/admin/addCategory")
	public String addCategory(Model model) {

		Category category = new Category();

		model.addAttribute("category", category);

		return "admin/add-category";
	}

	@PostMapping("admin/save-category")
	public String saveCategory(Category category) {

		if (category.getId() == 0) {

			categoryService.saveCategory(category);

		}else {
			
			categoryService.updateCategory(category);
			
		}

		return "redirect:/admin/category";
	}

	@GetMapping("admin/updateCategory")
	public String updateCategory(@RequestParam("categoryId") int id, Model model) {

		Category category = categoryService.getCategory(id);

		model.addAttribute("category", category);

		return "admin/add-category";
	}
	
	@ResponseBody
	@PostMapping("admin/deleteCategory")
	public String deleteCategory(@RequestParam("categoryId") int id) {
		
		boolean result = categoryService.deleteCategory(id);
		
		return String.valueOf(result);
	}
	
}
