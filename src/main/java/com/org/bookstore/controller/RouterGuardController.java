package com.org.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.bookstore.service.ApplicationService;

@CrossOrigin(origins = 
{"http://localhost:4200","https://xenodochial-sinoussi-0faef4.netlify.com"})
@RestController
public class RouterGuardController {

	@Autowired
	private ApplicationService appService;
	
	//returns true if currently logged in user is admin
	@RequestMapping("/userrole")
	public boolean isAdmin() {
		
		String roles = this.appService.getCurrentlyLoggedInUser().getRoles();
		
		System.out.println("role "+roles);

		
		if(roles.equals("Admin")) {

			return true;
		}
		return false;
	}
}
