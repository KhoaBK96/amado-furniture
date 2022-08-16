 package com.khoa.af.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.khoa.af.api.admin.Order;
import com.khoa.af.api.admin.OrderDetail;
import com.khoa.af.api.admin.Product;

public class OrderDetailsRowMapper implements RowMapper<OrderDetail> {

	@Override
	public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderDetail orderDetail = new OrderDetail();
		
		Product product = new Product();
		
		product.setId(rs.getInt("p.id"));
		
		product.setName(rs.getString("p.name"));
		
		product.setPrice(rs.getDouble("p.price"));
		
		product.setImgUrl(rs.getString("p.imgUrl"));
				
		orderDetail.setProduct(product);
		
		orderDetail.setPrice(rs.getDouble("od.price"));
		
		orderDetail.setQuantity(rs.getInt("od.quantity"));
		
		return orderDetail;
	}

}
