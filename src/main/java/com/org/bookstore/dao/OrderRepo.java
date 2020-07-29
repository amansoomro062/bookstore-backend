package com.org.bookstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.org.bookstore.bean.Order;
import com.org.bookstore.bean.User;

public interface OrderRepo extends JpaRepository<Order, Long> {

//	@Query("from Order where user=?1")
	@Query("from Order where userid=?1")
	public List<Order> findByUser(User user);
		
}
