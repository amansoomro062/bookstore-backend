package com.org.bookstore.bean;

import java.io.Serializable;

public class UserBookId implements Serializable{

	private Long book;
	private String user;
	
	
	public UserBookId() {
		
	}
	
	public UserBookId(Long book, String user) {
		super();
		this.book = book;
		this.user = user;
	}
	public Long getBook() {
		return book;
	}
	public void setBook(Long book) {
		this.book = book;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
}
