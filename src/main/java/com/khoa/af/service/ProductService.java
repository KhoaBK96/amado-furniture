package com.khoa.af.service;

import java.util.List;

import com.khoa.af.api.admin.Product;
import com.khoa.af.api.admin.SortType;

public interface ProductService {

	List<Product> loadProduct();

	void saveProduct(Product product);

	Product getProduct(int id);

	void updateProduct(Product product);

	boolean deleteProduct(int id);
	
	List<Product> getObjsWithPagination(int size, int page, SortType sort, Object... args);

	List<Product> getObjsWithPagination(int size, int page, SortType sort);

	int getMaxPages(int size, Object... args);

	int getMaxPages(int size);

}
