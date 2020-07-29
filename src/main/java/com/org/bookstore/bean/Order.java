package com.org.bookstore.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "`order`")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;	

	@OneToMany(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "orderid")
	List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
	
	private String email;
	private String firstName;
	private String lastName;
	private String shippingAddress;

	private Date orderDate;
	private Date recieveDate;
	private String status;
	
	private double totlePrice;
	
	
//	public List<Cart> getItems() {
//		return items;
//	}
//	public void setItems(List<Cart> items) {
//		this.items = items;
//	}
	
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getRecieveDate() {
		return recieveDate;
	}
	public void setRecieveDate(Date recieveDate) {
		this.recieveDate = recieveDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getTotlePrice() {
		return totlePrice;
	}
	public void setTotlePrice(double totlePrice) {
		this.totlePrice = totlePrice;
	}
	
	
	
	
}
