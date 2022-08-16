package com.khoa.af.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.khoa.af.api.admin.Category;
import com.khoa.af.api.admin.Product;
import com.khoa.af.dao.CategoryDAO;
import com.khoa.af.service.CategoryService;

public class ProductRowMapper implements RowMapper<Product>{

	
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product product = new Product();
		
		
		product.setId(rs.getInt("id"));
		product.setName(rs.getNString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setImgUrl(rs.getString("imgUrl"));
		product.setDetails(rs.getString("details"));
		product.setCreatedDate(rs.getDate("createdDate"));
		
		Category category = new Category(rs.getInt("categoryId"), rs.getString("categoryName"));
		
		product.setCategory(category);
		
		return product;
	}

}
