package com.khoa.af.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khoa.af.api.admin.Order;
import com.khoa.af.api.admin.OrderDetail;
import com.khoa.af.rowmapper.OrderDetailsRowMapper;
import com.khoa.af.rowmapper.OrderRowMapper;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Order> loadOrder() {

		String sql = "SELECT * FROM orders WHERE deleted=0";

		List<Order> theListOfOrder = jdbcTemplate.query(sql, new OrderRowMapper());

		return theListOfOrder;
	}

	@Override
	public void saveOrder(Order order) {

		Object[] sqlParameters = { order.getName(), order.getEmail(), order.getPhone(), order.getAddress(),
				order.getConfirmTime(), order.getPaidTime() };

		String sql = "INSERT INTO orders(name, email, phone, address, confirmTime, paidTime) VALUES(?, ?, ?, ?, ?, ?) ";

		jdbcTemplate.update(sql, sqlParameters);

	}

	@Override
	public Order getOrder(int id) {

		String sql = "SELECT * FROM orders WHERE id=?";

		Order order = jdbcTemplate.queryForObject(sql, new OrderRowMapper(), id);

		return order;
	}

	@Override
	public void updateOrder(Order order) {

		Object[] sqlParameters = { order.getName(), order.getEmail(), order.getPhone(), order.getAddress(),
				order.getConfirmTime(), order.getPaidTime(), order.getId() };

		String sql = "UPDATE orders SET name=?, email=?, phone=?, address=?, confirmTime=?, paidTime=? WHERE id=?";

		jdbcTemplate.update(sql, sqlParameters);

	}

	@Override
	public List<OrderDetail> loadOrderDetails(int id) {
		
		String sql = "SELECT p.id, p.name, p.price, p.imgUrl, od.price, od.quantity FROM ordersDetails od "
					+ "INNER JOIN products p "
					+ "ON od.idProduct = p.id "
					+ "WHERE od.idOrder=? AND od.deleted = 0";
		
		List<OrderDetail> listOfOrderDetails = jdbcTemplate.query(sql, new OrderDetailsRowMapper(), id);
		
		Order order = getOrder(id);
		
		order.setOrdersDetails(listOfOrderDetails);
		
		return listOfOrderDetails;
	}

	public void addOrderDetail(OrderDetail orderDetail) {
		
		Object[] sqlParameters = {orderDetail.getOrder().getId(), orderDetail.getProduct().getId(), orderDetail.getQuantity()};
		
		String sql = "INSERT INTO ordersDetails(idOrder, idProduct, quantity) values(?, ?, ?)";
		
		jdbcTemplate.update(sql, sqlParameters);
		
	}

	@Override
	public boolean deleteOrder(int id) {
		
		String sql = "UPDATE orders SET deleted=1 WHERE id=?";
		
		int affectedRows = jdbcTemplate.update(sql, id);		
				
		return affectedRows == 1;
	}

	
	
	
}
