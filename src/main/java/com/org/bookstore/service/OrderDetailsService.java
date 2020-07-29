package com.org.bookstore.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.bookstore.bean.Cart;
import com.org.bookstore.bean.Order;
import com.org.bookstore.bean.OrderDetails;
import com.org.bookstore.dao.OrderDetailsRepo;

@Component
public class OrderDetailsService {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;
	

	
	public List<OrderDetails> addOrderDetails(Order order) {
	List<Cart> carts =	this.cartService.getCart();
	List<OrderDetails> orderDetailsList = new ArrayList<>();

		for (Cart cart : carts) {
			OrderDetails orderDetails = new OrderDetails(cart.getBook().getId(), cart.getBook().getImg_Source(),
					cart.getBook().getName(), cart.getBook().getPrice(), cart.getQuantity(), cart.getTotle_price());
			orderDetailsList.add(orderDetails);
		}

		return orderDetailsList;
//		return this.orderDetailsRepo.saveAll(orderDetailsList);
	}
	
	public List<OrderDetails> findOrderDetailsByOrder(Order order){
		
		return this.orderDetailsRepo.findByOrder(order);
					
	}	
}
