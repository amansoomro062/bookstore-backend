package com.org.bookstore.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.bookstore.bean.ActualUser;
import com.org.bookstore.security.UserPrincipal;

@CrossOrigin(origins = 
{"http://localhost:4200","https://xenodochial-sinoussi-0faef4.netlify.com"})
@RestController
public class BasicAuthenticationController {
	

	@RequestMapping("/basicauth")
	public ActualUser BasicAuthLogin() {
		UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			ActualUser actualUser=user.getActualUser();
			
		return actualUser;
		
	}
}
