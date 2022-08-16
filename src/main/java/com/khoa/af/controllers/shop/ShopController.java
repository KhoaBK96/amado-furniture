package com.khoa.af.controllers.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.khoa.af.api.admin.Category;
import com.khoa.af.api.admin.SortType;
import com.khoa.af.api.admin.dto.ShopPageDTO;
import com.khoa.af.service.CategoryService;
import com.khoa.af.service.ProductService;
import com.khoa.af.service.ShopPageDTOService;

@Controller
public class ShopController {
	
	private static final String SHOP_PAGE = "shop/shop";
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ShopPageDTOService shopPageDTOService;

	@ModelAttribute("categoryList")
	public List<Category> categoryList() {

		return categoryService.loadCategory();
	}

	@GetMapping("/shop")
	public String showProducts(@ModelAttribute("dto") ShopPageDTO dto,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "sort", defaultValue = "default") String sort) {
		dto.setPage(page);
		dto.setSortType(SortType.parseValue(sort));
		shopPageDTOService.fillDTO(dto);

		return SHOP_PAGE ;

	}
	
	@GetMapping("/shop/{categoryId}")
	public String showProductByCategory(@PathVariable(name = "categoryId") int categoryId,
			@ModelAttribute("dto") ShopPageDTO dto,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "sort", defaultValue = "default") String sort) {
		
		dto.setPage(page);
		dto.setSortType(SortType.parseValue(sort));
		dto.setCategoryId(categoryId);
		shopPageDTOService.fillDTO(dto);
		
		return SHOP_PAGE;
		
	}
	
	

}
