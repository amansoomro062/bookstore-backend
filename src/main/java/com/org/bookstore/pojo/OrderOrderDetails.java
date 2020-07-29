package com.org.bookstore.pojo;

import java.util.List;

import com.org.bookstore.bean.Order;
import com.org.bookstore.bean.OrderDetails;

public class OrderOrderDetails {
	private Order order;
	private List<OrderDetails> orderDetailsList;
	
	public OrderOrderDetails() {
	}
	
	public OrderOrderDetails(Order order, List<OrderDetails> orderDetailsList) {
		super();
		this.order = order;
		this.orderDetailsList = orderDetailsList;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderDetails> getOrderDetailsList() {
		return orderDetailsList;
	}

	public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
		this.orderDetailsList = orderDetailsList;
	}

	

}

//public class OrderCartDetails {
//	private Order order;
//	private List<CartDetails> cartDetailsList;
//
//
//	public OrderCartDetails() {
//	}
//
//
//	public OrderCartDetails(Order order, List<CartDetails> cartDetailsList) {
//		super();
//		this.order = order;
//		this.cartDetailsList = cartDetailsList;
//	}
//
//
//	public Order getOrder() {
//		return order;
//	}
//
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//
//
//	public List<CartDetails> getCartDetailsList() {
//		return cartDetailsList;
//	}
//
//
//	public void setCartDetailsList(List<CartDetails> cartDetailsList) {
//		this.cartDetailsList = cartDetailsList;
//	}
//
//}
