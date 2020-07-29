package com.org.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.bookstore.bean.ActualUser;
import com.org.bookstore.bean.User;
import com.org.bookstore.security.UserPrincipal;
import com.org.bookstore.service.UserService;

@CrossOrigin(origins = 
{"http://localhost:4200","https://xenodochial-sinoussi-0faef4.netlify.com"})
@RestController

public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/CreateUser")
	public void CreateUser(@RequestBody User newuser) {
		System.out.println(newuser);
		this.userService.createNewUser(newuser);
	}

	@GetMapping("/profile")
	public ActualUser showProfile() {
		UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ActualUser actualUser = user.getActualUser();
		return actualUser;
	}

	@GetMapping("/applicationusers")
	public List<User> applicationUsers() {
		return this.userService.getAllUsers();
	}
	
	
	@GetMapping("/getusers")
	public List<User> getUsers() {
		return this.userService.getAllUsers();
	}

	// update users

	@PutMapping(value = "/updateusers", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<User[]> updateUsers(@RequestBody User[] users) {

		User[] user = this.userService.updateUsers(users);

		if (user != null) {
			return new ResponseEntity<User[]>(user, HttpStatus.OK);

		}

		return new ResponseEntity<User[]>(users, HttpStatus.FORBIDDEN);
	}

}
