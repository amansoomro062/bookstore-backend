package com.org.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.bookstore.bean.Order;
import com.org.bookstore.pojo.OrderOrderDetails;
import com.org.bookstore.service.OrderService;

@CrossOrigin(origins = 
{"http://localhost:4200","https://xenodochial-sinoussi-0faef4.netlify.com"})
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	//cancel existing orderorder
		@PutMapping(value = "/cancelorder", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)

		public ResponseEntity<Order> cancelOrder(@RequestBody Order order) {
			Order updatedOrder = this.orderService.cancelOrder(order);
			
			if (updatedOrder!= null) {
				return new ResponseEntity<Order>(updatedOrder, HttpStatus.OK);
			}
			return new ResponseEntity<Order>(order, HttpStatus.FORBIDDEN);
		}
		
		
	@PostMapping(value = "/confirmorder", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> confirmOrder(@RequestBody Order order) {
		
		Order savedOrder = this.orderService.confirmOrder(order);
		if (savedOrder != null) {
			return new ResponseEntity<Order>(savedOrder, HttpStatus.OK);
		}
		return new ResponseEntity<Order>(order, HttpStatus.FORBIDDEN);
	}
	

	@RequestMapping("/getorders")
	public List<OrderOrderDetails> getUsersOrders () {
		List<OrderOrderDetails> orderOrderDetailsList = this.orderService.getOrders();
		return orderOrderDetailsList;
	}
	
	
	
	@RequestMapping("/getallorders")
	public List<OrderOrderDetails> getAllOrders () {
		List<OrderOrderDetails> orderOrderDetailsList = this.orderService.getAllOrders();
		return orderOrderDetailsList;
	}
	
	
	//update order
	@PutMapping(value = "/order", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
		Order updatedOrder = this.orderService.updateOrder(order);
		
		if (updatedOrder!= null) {
			return new ResponseEntity<Order>(updatedOrder, HttpStatus.OK);
		}
		return new ResponseEntity<Order>(order, HttpStatus.FORBIDDEN);
	}
	
	
//	@RequestMapping("/getorders")
//	public List<OrderCartDetails> getOrders () {
//		List<OrderCartDetails>  orderCartDetailsList = this.orderService.getOrders();
//	
//		return  orderCartDetailsList;
//	}
}
