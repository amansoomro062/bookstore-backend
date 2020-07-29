package com.org.bookstore.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.bookstore.bean.Order;
import com.org.bookstore.bean.OrderDetails;
import com.org.bookstore.bean.User;
import com.org.bookstore.dao.OrderRepo;
import com.org.bookstore.pojo.OrderOrderDetails;

@Component
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private ApplicationService appService;
	
	
	private  List<OrderDetails> addOrderDetails(Order order) {
		return this.orderDetailsService.addOrderDetails(order);
	}

	public Order confirmOrder(Order order) {
		order.setStatus("ordered");
		order.setOrderDate(new Date());
		order.setRecieveDate(null);

		//add the incoming order to the user
		this.addOrderToTheUser(order);
		
		// add details corresponding to the order and return orderdetailslist and add orderDetailList to the order
			List<OrderDetails>	orderDetailsList = this.addOrderDetails(order);
			order.setOrderDetails(orderDetailsList);

		this.calculateTotleOrderPrice(order);
//		List<Cart> itemsInCart = cartService.getCart();
//		order.setItems(itemsInCart);

//		makes item available in the cart to not available by setting in_flag to false
		cartService.setConfirmCartItems();

		Order savedOrder = this.orderRepo.save(order);
		return savedOrder;
	}

	private void addOrderToTheUser(Order order) {
		this.userService.addOrderToTheUser(order);
	}

	public Order cancelOrder(Order order) {
		//make sure order status is ordered before cancling
		if(order.getStatus().equals("ordered")) {
			order.setStatus("cancel");
			return this.orderRepo.save(order);
		}
		return null;
		
	}
	
	private void calculateTotleOrderPrice(Order order) {
		double totle_cart_price = this.cartService.calculateUsersTotle();
		order.setTotlePrice(totle_cart_price);
	}

	public List<OrderOrderDetails> getOrders() {

		//first find order by user
		//then find orderdetails by order
		//then create list of orderorderdetails and return
		
		List<Order> orders = this.findOrdersByUser();
		
		List<OrderOrderDetails> orderOrderDetailsList = new ArrayList<>();
		
		for(Order order: orders) {
		List<OrderDetails> orderDetailsList= this.orderDetailsService.findOrderDetailsByOrder(order);
		OrderOrderDetails orderOrderDetails = new OrderOrderDetails(order, orderDetailsList);
		orderOrderDetailsList.add(orderOrderDetails);
		}

		return  orderOrderDetailsList;
	}
	
	public List<Order> findOrdersByUser() {
		
		User user = this.appService.getCurrentlyLoggedInUser();
		return this.orderRepo.findByUser(user);

	}

	public List<OrderOrderDetails> getAllOrders() {
		        //first find all orders by all users 
				//then find orderdetails by order
				//then create list of orderorderdetails and return
				
				//findAllOrders
				List<Order> orders = this.findAllOrders();
				
				List<OrderOrderDetails> orderOrderDetailsList = new ArrayList<>();
				
				for(Order order: orders) {
				List<OrderDetails> orderDetailsList= this.orderDetailsService.findOrderDetailsByOrder(order);
				OrderOrderDetails orderOrderDetails = new OrderOrderDetails(order, orderDetailsList);
				orderOrderDetailsList.add(orderOrderDetails);
				}

				return  orderOrderDetailsList;			
	}
	
	private List<Order> findAllOrders(){
		return this.orderRepo.findAll();
	}

	
	public Order updateOrder(Order order) {
		if(order.getStatus().equals("delivered")) {
			order.setRecieveDate(new Date());
		}
		else {
			order.setRecieveDate(null);
		}		
		return this.orderRepo.save(order);
	}
	
	
//	private List<OrderCartDetails> getOrderCartDetails(List<CartOrder> orderCartsList){
//		
//		List<OrderCartDetails> orderCartDetailsList  = new ArrayList<>();
//		
//		
//		for (CartOrder orderCarts : orderCartsList) {
//
//			List<Cart> carts = orderCarts.getCarts();
//			List<CartDetails> cartDetailsList = new ArrayList<>();
//
//			for (Cart cart : carts) {
//				CartDetails cartDetails = new CartDetails(cart.getBook().getId(), cart.getBook().getImg_Source(),
//						cart.getBook().getName(), cart.getBook().getPrice(), cart.getQuantity(), cart.getTotle_price());
//				cartDetailsList.add(cartDetails);
//			}
//
//			OrderCartDetails orderCartDetails = new OrderCartDetails(orderCarts.getOrder(), cartDetailsList);
//
//			orderCartDetailsList.add(orderCartDetails);
//
//			carts.clear();
//		}
//		return orderCartDetailsList;
//		
//	}
	
//	public List<OrderCartDetails> getOrders() {
//
//	List<Long> usersOrders = this.cartService.getUniqueOrders();
//	List<Order> orders = new ArrayList<>();	
//	
//	List<CartOrder> orderCartsList = new ArrayList<>();
//	
//		for(Long orderId: usersOrders) {
//			Order order=this.orderRepo.findById(orderId).get();
//			orders.add(order);
//		}
//		
//		for(Order order: orders) {
//			List<Cart> cartItemsForOrder = cartService.getCartsByOrder(order);			
//			CartOrder cartsOrder = new CartOrder(order,cartItemsForOrder);
//			orderCartsList.add(cartsOrder);
//		}
//		
//		 List<OrderCartDetails>  orderCartDetailsList = this.getOrderCartDetails(orderCartsList);
//		
//		return orderCartDetailsList;
//	}
//	
//	private List<OrderCartDetails> getOrderCartDetails(List<CartOrder> orderCartsList){
//		
//		List<OrderCartDetails> orderCartDetailsList  = new ArrayList<>();
//		
//		
//		for (CartOrder orderCarts : orderCartsList) {
//
//			List<Cart> carts = orderCarts.getCarts();
//			List<CartDetails> cartDetailsList = new ArrayList<>();
//
//			for (Cart cart : carts) {
//				CartDetails cartDetails = new CartDetails(cart.getBook().getId(), cart.getBook().getImg_Source(),
//						cart.getBook().getName(), cart.getBook().getPrice(), cart.getQuantity(), cart.getTotle_price());
//				cartDetailsList.add(cartDetails);
//			}
//
//			OrderCartDetails orderCartDetails = new OrderCartDetails(orderCarts.getOrder(), cartDetailsList);
//
//			orderCartDetailsList.add(orderCartDetails);
//
//			carts.clear();
//		}
//		return orderCartDetailsList;
//		
//	}
}
