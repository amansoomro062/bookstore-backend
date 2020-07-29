package com.org.bookstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.bookstore.bean.Order;
import com.org.bookstore.bean.OrderDetails;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {
	
	@Query("from OrderDetails where orderid=?1")
	public List<OrderDetails> findByOrder(Order order);
}
