package com.khoa.af.api.admin;

import java.sql.Date;
import java.util.List;

public class Order {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private Date createdTime;
	private Date confirmTime;
	private Date paidTime;
	private List<OrderDetail> orderDetail;
	
	public Order() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public Date getPaidTime() {
		return paidTime;
	}

	public void setPaidTime(Date paidTime) {
		this.paidTime = paidTime;
	}
	
	

	public List<OrderDetail> getOrdersDetails() {
		return orderDetail;
	}

	public void setOrdersDetails(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	public void addOrdersDetails(OrderDetail orderDetail) {
		this.orderDetail.add(orderDetail);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", createdTime=" + createdTime + ", confirmTime=" + confirmTime + ", paidTime=" + paidTime
				+ ", ordersDetails=" + orderDetail + "]";
	}

	

}
