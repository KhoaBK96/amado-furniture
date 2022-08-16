package com.khoa.af.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khoa.af.api.admin.Category;
import com.khoa.af.dao.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	public List<Category> loadCategory() {
		
		return categoryDAO.loadCategory();
	}

	@Override
	public void saveCategory(Category category) {

		categoryDAO.saveCategory(category);
		
	}

	@Override
	public Category getCategory(int id) {
		
		return categoryDAO.getCategory(id);
	}

	@Override
	public void updateCategory(Category category) {

		categoryDAO.updateCategory(category);
		
	}

	@Override
	public boolean deleteCategory(int id) {
		
		return categoryDAO.deleteCategory(id);
		
	}

}
