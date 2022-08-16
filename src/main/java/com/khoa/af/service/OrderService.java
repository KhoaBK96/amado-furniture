package com.khoa.af.service;

import java.util.List;

import com.khoa.af.api.admin.Order;
import com.khoa.af.api.admin.OrderDetail;

public interface OrderService {
	
	List<Order> loadOrder();

	void saveOrder(Order order);

	Order getOrder(int id);

	void updateOrder(Order order);

	List<OrderDetail> loadOrderDetails(int id);
	
	double getTotal(List<OrderDetail> ordersDetails);

	void addOrderDetail(OrderDetail orderDetail);

	boolean deleteOrder(int id);
}
