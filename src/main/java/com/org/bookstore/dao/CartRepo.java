package com.org.bookstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.org.bookstore.bean.Book;
import com.org.bookstore.bean.Cart;
import com.org.bookstore.bean.Order;
import com.org.bookstore.bean.User;

//public interface CartRepo extends JpaRepository<Cart, UserBookId>{

public interface CartRepo extends JpaRepository<Cart,Long>{

	@Modifying 
	@Query("delete from Cart where user_username=?1 and in_cart=true")
	public void clearCartItems(User user);
	
	
	
	@Query(" from Cart where user_username=?1 and in_cart = true")
	public List<Cart> findByUser(User user);
	
	@Query(" from Cart where user_username=?1 and in_cart = false")
	public List<Cart> findByUserNotInCartFlag(User user);
		
	@Query("from Cart where book=?1 and in_cart = true")
	public List<Cart> findByBook(Book book);

	
	@Query("from Cart where order_id=?1 and in_cart = false")
	public List<Cart> findByOrder(Order order);
	
	@Query("from Cart where user_username=?1 and book=?2 and in_cart=true")
	public Cart findItemInCart(User user,Book book);
	
	
	//returns list of unique order_id for each user from cart
	@Query(value="select distinct order_id from cart where user_username=? and in_cart=false",nativeQuery = true)
	public List<Long> findUniqueOrderId(User user);
	
	
//	@Query(" from Cart where user=?1 and in_cart = true")
//	public List<Cart> findByUserInCart(User user);
//			
}