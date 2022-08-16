package com.khoa.af.dao;

import java.util.List;

import com.khoa.af.api.admin.Order;
import com.khoa.af.api.admin.OrderDetail;

public interface OrderDAO {
	
	List<Order> loadOrder();
	
	void saveOrder(Order order);
	
	Order getOrder(int id);

	void updateOrder(Order order);
	
	List<OrderDetail> loadOrderDetails(int id);

	boolean deleteOrder(int id);


}
