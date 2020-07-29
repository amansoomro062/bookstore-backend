package com.org.bookstore.pojo;

public class CartPojo {

    private String username;
    
    private long id;
    
    private double price;
    
    private  int quantity;
    
    private double totle_price;
    
    
    
   
	public CartPojo(String username, long id, double price, int quantity, double totle_price) {
		super();
		this.username = username;
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.totle_price = totle_price;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CartPojo [username=" + username + ", id=" + id + ", price=" + price + ", quantity=" + quantity
				+ ", totle_price=" + totle_price + "]";
	}
        
      

}


