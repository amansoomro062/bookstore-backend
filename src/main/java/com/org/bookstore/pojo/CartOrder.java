package com.org.bookstore.pojo;

import java.util.List;

import com.org.bookstore.bean.Cart;
import com.org.bookstore.bean.Order;

public class CartOrder {

	private Order order;
	private List<Cart> carts;

	public CartOrder() {
	}

	public CartOrder(Order order, List<Cart> carts) {
		super();
		this.order = order;
		this.carts = carts;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
}
