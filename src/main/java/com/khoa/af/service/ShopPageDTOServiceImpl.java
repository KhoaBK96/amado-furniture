package com.khoa.af.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khoa.af.api.admin.Product;
import com.khoa.af.api.admin.SortType;
import com.khoa.af.api.admin.dto.ShopPageDTO;

@Service
public class ShopPageDTOServiceImpl implements ShopPageDTOService {
	
	@Autowired
	ProductService productService;	
	
	@Override
	public ShopPageDTO fillDTO(ShopPageDTO dto) {
		
		try {
			int itemsPerPage = dto.getItemsPerPage();
			SortType sortType = dto.getSortType();
			int categoryId = dto.getCategoryId();
			int maxPage = dto.getMaxPage();
			List<Product> products;
			
			if(categoryId == 0) {
				maxPage = productService.getMaxPages(itemsPerPage);
				products = productService.getObjsWithPagination(itemsPerPage, dto.getPage(), sortType);
			} else {
				maxPage = productService.getMaxPages(itemsPerPage, categoryId);
				products = productService.getObjsWithPagination(itemsPerPage, dto.getPage(), sortType, categoryId);
			}
			
			dto.setMaxPage(maxPage);
			dto.setProducts(products);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return dto;
		
	}

}
