package com.khoa.af.dao;

import java.util.List;

import com.khoa.af.api.admin.Category;

public interface CategoryDAO {
	
	List<Category> loadCategory();
	
	void saveCategory(Category category);
	
	Category getCategory(int id);

	void updateCategory(Category category);

	boolean deleteCategory(int id);


}
