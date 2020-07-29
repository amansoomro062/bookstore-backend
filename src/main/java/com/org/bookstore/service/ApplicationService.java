package com.org.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.org.bookstore.bean.ActualUser;
import com.org.bookstore.bean.User;
import com.org.bookstore.dao.UserRepository;
import com.org.bookstore.security.UserPrincipal;
@Component
public class ApplicationService {

	@Autowired
	UserRepository userRepo;

	public User getCurrentlyLoggedInUser() {
		UserPrincipal loggedInUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		ActualUser actualUser = loggedInUser.getActualUser();
		String username = actualUser.getUsername();

		User user = userRepo.findById(username).get();
		return user;
	}
	
	public String getCurrentlyLoggedInUsername() {
		UserPrincipal loggedInUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		ActualUser actualUser = loggedInUser.getActualUser();
		String username = actualUser.getUsername();

		return username;
	}
}


