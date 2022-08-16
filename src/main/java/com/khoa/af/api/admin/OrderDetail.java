package com.khoa.af.api.admin;

public class OrderDetail {
	
	private Order order;
	private Product product;
	private Double price;
	private int quantity;
	
	public OrderDetail() {
		super();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	@Override
	public String toString() {
		return "OrderDetails [order=" + order + ", product=" + product + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

	
	
}
