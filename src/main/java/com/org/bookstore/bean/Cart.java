package com.org.bookstore.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
public class Cart implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private User user;

	@ManyToOne
	private Book book;

	private double price;

	private int quantity;

	private double totle_price;
	
	@Column(columnDefinition="boolean default true")
	private boolean in_cart;

	public Cart() {
		super();
	}

	public Cart(User user, Book book, double price, int quantity, double totle_price) {
		super();
		this.user = user;
		this.book = book;
		this.price = price;
		this.quantity = quantity;
		this.totle_price = totle_price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public double getPrice() {
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

	public double getTotle_price() {
		return totle_price;
	}

	public void setTotle_price(double totle_price) {
		this.totle_price = totle_price;
	}

	public boolean isIn_cart() {
		return in_cart;
	}

	public void setIn_cart(boolean in_cart) {
		this.in_cart = in_cart;
	}

	public Long getId() {
		return id;
	}


	

}

//@Entity
//@IdClass(UserBookId.class)
//public class Cart implements Serializable {
//
//	@Id
//	@ManyToOne
//	private User user;
//
//	@Id
//	@ManyToOne
//	private Book book;
//
//	private double price;
//
//	private int quantity;
//
//	private double totle_price;
//	
//	@Column(columnDefinition="boolean default true")
//	private boolean in_cart;
//
//	public Cart() {
//		super();
//	}
//
//	public Cart(User user, Book book, double price, int quantity, double totle_price) {
//		super();
//		this.user = user;
//		this.book = book;
//		this.price = price;
//		this.quantity = quantity;
//		this.totle_price = totle_price;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Book getBook() {
//		return book;
//	}
//
//	public void setBook(Book book) {
//		this.book = book;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public double getTotle_price() {
//		return totle_price;
//	}
//
//	public void setTotle_price(double totle_price) {
//		this.totle_price = totle_price;
//	}
//
//	public boolean isIn_cart() {
//		return in_cart;
//	}
//
//	public void setIn_cart(boolean in_cart) {
//		this.in_cart = in_cart;
//	}
//	
//
//}