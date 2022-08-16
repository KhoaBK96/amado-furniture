package com.khoa.af.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khoa.af.api.admin.Product;
import com.khoa.af.api.admin.SortType;
import com.khoa.af.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public List<Product> loadProduct() {
		
		return productDAO.loadProduct();
		
	}

	@Override
	public void saveProduct(Product product) {
		
		productDAO.saveProduct(product);
		
	}

	@Override
	public Product getProduct(int id) {
		
		return productDAO.getProduct(id);
	}

	@Override
	public void updateProduct(Product product) {
		
		productDAO.updateProduct(product);
		
	}

	@Override
	public boolean deleteProduct(int id) {
		
		return productDAO.deleteProduct(id);
		
	}

	@Override
	public List<Product> getObjsWithPagination(int itemsPerPage, int page, SortType sort, Object... args) {
		return productDAO.getObjsWithPagination(itemsPerPage, page, sort, args);
	}

	@Override
	public List<Product> getObjsWithPagination(int itemsPerPage, int page, SortType sort) {
		return productDAO.getObjsWithPagination(itemsPerPage, page, sort);
	}

	@Override
	public int getMaxPages(int itemsPerPage, Object... args) {
		return productDAO.getMaxPages(itemsPerPage, args);
	}

	@Override
	public int getMaxPages(int itemsPerPage) {
		return productDAO.getMaxPages(itemsPerPage);
	}

}
