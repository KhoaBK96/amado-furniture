package com.khoa.af.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.khoa.af.api.admin.Product;
import com.khoa.af.api.admin.SortType;
import com.khoa.af.rowmapper.ProductRowMapper;
import com.khoa.af.service.CategoryService;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	CategoryService categoryService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> loadProduct() {

		String sql = "SELECT pr.id, pr.name, pr.price, pr.imgUrl, pr.details, pr.createdDate, pr.categoryId, ct.name as categoryName "
				+ "FROM products pr " + "inner join categories ct " + "on pr.categoryId = ct.id "
				+ "WHERE pr.deleted=0";

		List<Product> productList = jdbcTemplate.query(sql, new ProductRowMapper());

		return productList;
	}

	@Override
	public void saveProduct(Product product) {

		Object[] sqlParameters = { product.getName(), product.getPrice(), product.getImgUrl(), product.getDetails(),
				product.getCreatedDate(), product.getCategory().getId() };

		System.out.println(sqlParameters);

		String sql = "INSERT INTO products(name, price, imgUrl, details, createdDate, categoryId) values(?, ?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, sqlParameters);
	}

	@Override
	public Product getProduct(int id) {

		String sql = "SELECT pr.id, pr.name, pr.price, pr.imgUrl, pr.details, pr.createdDate, pr.categoryId, ct.name as categoryName "
				+ "FROM products pr " + "inner join categories ct " + "on pr.categoryId = ct.id " + "WHERE pr.id=?";

		Product product = jdbcTemplate.queryForObject(sql, new ProductRowMapper(), id);

		return product;
	}

	@Override
	public void updateProduct(Product product) {

		Object[] sqlParameters = { product.getName(), product.getPrice(), product.getImgUrl(), product.getDetails(),
				product.getCreatedDate(), product.getCategory().getId(), product.getId() };

		String sql = "UPDATE products SET name=?, price=?, imgUrl=?, details=?, createdDate=?, categoryId=? WHERE id=?";

		jdbcTemplate.update(sql, sqlParameters);
	}

	@Override
	public boolean deleteProduct(int id) {

		String sql = "UPDATE products SET deleted=1 WHERE id=?";

		int affectedRows = jdbcTemplate.update(sql, id);

		return affectedRows == 1;

	}


	@Override
	public List<Product> getObjsWithPagination(int itemsPerPage, int page, SortType sort) {
		
		String sqlTemplate = "SELECT * FROM v_productDetail ORDER BY %s LIMIT %d OFFSET %d";
		String sql = preparePaginationSqlFormat(itemsPerPage, page, sort, sqlTemplate);
		
		return jdbcTemplate.query(sql, new ProductRowMapper());
	
	}
	
	private String preparePaginationSqlFormat(int itemsPerPage, int page, SortType sort, String sqlTemplate) {
		int offset = getOffset(itemsPerPage, page);
		String condition = getSortCondittion(sort);

		return String.format(sqlTemplate, condition, itemsPerPage, offset);
	}
	
	@Override
	public int getMaxPages(int itemsPerPage,Object...args) {
		String sql = "SELECT COUNT(id) FROM products WHERE categoryId=?";
		int total = jdbcTemplate.queryForObject(sql, Integer.class, args);
		
		return getNumberOfPage(total, itemsPerPage);
		
	}
	
	@Override
	public int getMaxPages(int itemsPerPage) {
		String sql = "SELECT COUNT(id) FROM products";
		int total = jdbcTemplate.queryForObject(sql, Integer.class);
		return getNumberOfPage(total, itemsPerPage);
	} 
	
	private int getNumberOfPage(int total, int itemsPerPage) {
		return (int) Math.ceil(total / (float) itemsPerPage);
	}

	private String getSortCondittion(SortType type) {
		switch (type) {
		case BY_PRICE_ASC:
			return "price ASC";
		case BY_PRICE_DESC:
			return "price DESC";
		default:
			return "createdDate DESC";

		}
	}

	private int getOffset(int itemsPerPage, int page) {
		return itemsPerPage * (page - 1);
	}

	@Override
	public List<Product> getObjsWithPagination(int itemsPerPage, int page, SortType sort, Object... args) {
		String sqlTemplate = "SELECT * FROM v_productDetail WHERE categoryId=? " + "ORDER BY %s LIMIT %d OFFSET %d";

		String sql = preparePaginationSqlFormat(itemsPerPage, page, sort, sqlTemplate);

		return jdbcTemplate.query(sql, new ProductRowMapper(), args);

	}

}
