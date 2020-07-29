package com.org.bookstore.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Book {
	@Id
	private Long id;
	
	private String name;
	private String author_Name;
	private double price;
	private String category;
	
	private String img_Source;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "book",cascade=CascadeType.REMOVE)
	private List<Cart> bookCart;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor_Name() {
		return author_Name;
	}
	public void setAuthor_Name(String author_Name) {
		this.author_Name = author_Name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImg_Source() {
		return img_Source;
	}
	public void setImg_Source(String img_Source) {
		this.img_Source = img_Source;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public List<Cart> getBookCart() {
		return bookCart;
	}
	public void setBookCart(List<Cart> bookCart) {
		this.bookCart = bookCart;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author_Name=" + author_Name + ", price=" + price + ", category="
				+ category + ", img_Source=" + img_Source + ", description=" + description + "]";
	}
	
	
	

}
