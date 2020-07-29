package com.org.bookstore.pojo;
public class CartDetails {
	
	private long bookid;
	private String img_src;
	private String item;
	private double cost;
	private int quantity;
	private double totle_cost;
	
	public CartDetails() {
		
	}
	public CartDetails(long bookid, String img_src, String item, double cost, int quantity, double totle_cost) {
		super();
		this.bookid = bookid;
		this.img_src = img_src;
		this.item = item;
		this.cost = cost;
		this.quantity = quantity;
		this.totle_cost = totle_cost;
	}
	public long getBookid() {
		return bookid;
	}
	public void setBookid(long bookid) {
		this.bookid = bookid;
	}
	public String getImg_src() {
		return img_src;
	}
	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotle_cost() {
		return totle_cost;
	}
	public void setTotle_cost(double totle_cost) {
		this.totle_cost = totle_cost;
	}
	
	
}
