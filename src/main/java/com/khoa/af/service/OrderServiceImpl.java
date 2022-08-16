package com.khoa.af.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khoa.af.api.admin.Order;
import com.khoa.af.api.admin.OrderDetail;
import com.khoa.af.dao.OrderDAOImpl;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDAOImpl orderDAOImpl;
	
	@Override
	public List<Order> loadOrder() {
		
		return orderDAOImpl.loadOrder();
	}

	@Override
	public void saveOrder(Order order) {
		orderDAOImpl.saveOrder(order);
	}

	@Override
	public Order getOrder(int id) {
		return orderDAOImpl.getOrder(id);
	}

	@Override
	public void updateOrder(Order order) {
		orderDAOImpl.updateOrder(order);
	}

	@Override
	public List<OrderDetail> loadOrderDetails(int id) {
		return orderDAOImpl.loadOrderDetails(id);
	}

	@Override
	public double getTotal(List<OrderDetail> ordersDetails) {
		
		double total = 0;
		for(int i = 0; i< ordersDetails.size(); i = i+1) {
			OrderDetail currentDetails = ordersDetails.get(i);
			total += currentDetails.getProduct().getPrice() * currentDetails.getQuantity();
		}
		
		return total;
	}

	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		
		orderDAOImpl.addOrderDetail(orderDetail);
		
	}

	@Override
	public boolean deleteOrder(int id) {
		return orderDAOImpl.deleteOrder(id);
	}

}
