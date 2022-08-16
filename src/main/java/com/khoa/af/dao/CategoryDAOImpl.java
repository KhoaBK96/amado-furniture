package com.khoa.af.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.khoa.af.api.admin.Category;
import com.khoa.af.rowmapper.CategoryRowMapper;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Category> loadCategory() {
		
		String sql = "SELECT * FROM categories WHERE deleted=0";
		
		List<Category> theListOfCategory = jdbcTemplate.query(sql, new CategoryRowMapper());
		
		return theListOfCategory;
	}

	@Override
	public void saveCategory(Category category) {
		
		Object[] sqlParameters = {category.getName()};
		
		String sql = "INSERT INTO categories(name) values (?)";
		
		jdbcTemplate.update(sql, sqlParameters);
		
	}

	@Override
	public Category getCategory(int id) {
		
		String sql = "SELECT * FROM categories WHERE id=?";
		
		Category category = jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), id);
		
		System.out.println(category);
		
		return category;
	}

	@Override
	public void updateCategory(Category category) {
		
		String sql = "UPDATE categories SET name=? WHERE id=?";
		
		jdbcTemplate.update(sql, category.getName(), category.getId());
		
	}

	@Override
	public boolean deleteCategory(int id) {

		String sql = "UPDATE categories SET deleted=1 WHERE id=?";
		
		int affectedRows = jdbcTemplate.update(sql, id);
		
		return affectedRows == 1;
	}

}
