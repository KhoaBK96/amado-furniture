package com.khoa.af.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.khoa.af.api.admin.Order;

public class OrderRowMapper implements RowMapper<Order>{

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Order order = new Order();
		
		order.setId(rs.getInt("id"));
		order.setName(rs.getString("name"));
		order.setEmail(rs.getString("email"));
		order.setPhone(rs.getString("phone"));
		order.setAddress(rs.getString("address"));
		order.setCreatedTime(rs.getDate("createdTime"));
		order.setConfirmTime(rs.getDate("confirmTime"));
		order.setPaidTime(rs.getDate("paidTime"));
		
		return order;
	}

}
