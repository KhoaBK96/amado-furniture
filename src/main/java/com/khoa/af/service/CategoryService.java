package com.khoa.af.service;

import java.util.List;

import com.khoa.af.api.admin.Category;

public interface CategoryService {

	List<Category> loadCategory();

	void saveCategory(Category category);

	Category getCategory(int id);

	void updateCategory(Category category);

	boolean deleteCategory(int id);

}
