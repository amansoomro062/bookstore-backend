package com.org.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.bookstore.bean.User;


public interface UserRepository extends JpaRepository<User, String>{

	User findByUsername(String username);
	
}
