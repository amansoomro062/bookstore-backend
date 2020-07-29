package com.org.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UserProfileController {

	@Autowired
	private UserService userService;

	 @GetMapping("/userprofile")
	 public ResponseEntity<User> getUserProfile() {
		
	UserPrincipal loggedInUser = (UserPrincipal) SecurityContextHolder.getContext().
			getAuthentication().getPrincipal();

	ActualUser actualUser=loggedInUser.getActualUser();
	String username=actualUser.getUsername();
		 
		 User user=this.userService.findUserProfileByUsername(username);
		
	 System.out.println("actual user is "+user);
		 ResponseEntity<User> userProfile= 
			 new ResponseEntity<User>(user,HttpStatus.OK);
		 return userProfile;	

	 }
	 
	//update profile
		
	 @PutMapping(value="/userprofile",
			 produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } 
			 //consumes =  MediaType.APPLICATION_JSON_VALUE
			 )
	 
	 public ResponseEntity<User> updateUserProfile(@RequestBody User userProfile) {
		 
		 
		 
		 System.out.println("stop here plzzzzzz "+userProfile);
		 
		 User user=this.userService.updateUserProfile(userProfile); 
	    
		 if(user!=null) {
			 return new ResponseEntity<User> (user,HttpStatus.OK);			
		 	}
		 
		 return new ResponseEntity<User> (user,HttpStatus.FORBIDDEN);
		}
	 
	
	
//	 @GetMapping("/userprofile")
//	 public ResponseEntity<Optional<UserProfile>> getUserProfile() {
//		
//	UserPrincipal loggedInUser = (UserPrincipal) SecurityContextHolder.getContext().
//			getAuthentication().getPrincipal();
//
//	ActualUser actualUser=loggedInUser.getActualUser();
//	String username=actualUser.getUsername();
//		 
//		 Optional<UserProfile> user=this.userProfileService.findUserProfileByUsername(username);
//		 ResponseEntity<Optional<UserProfile>> userProfile= 
//			 new ResponseEntity<Optional<UserProfile>>(user,HttpStatus.OK);
//		 return userProfile;	
//		}
	 

//	 @GetMapping("/userprofile/{username}")
//	 public ResponseEntity<Optional<UserProfile>> getUserProfile(@PathVariable String username) {
//		
//		 Optional<UserProfile> user=this.userProfileService.findUserProfileByUsername(username);
//		 ResponseEntity<Optional<UserProfile>> userProfile= 
//			 new ResponseEntity<Optional<UserProfile>>(user,HttpStatus.OK);
//		 return userProfile;	
//		}
	 
	
//	 @PutMapping(value="/userprofile",
//			 produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } 
//			 //consumes =  MediaType.APPLICATION_JSON_VALUE
//			 
//			 )
//	 public ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile userProfile) {
//		 UserProfile user=this.userProfileService.updateUserProfile(userProfile); 
//	    if(user!=null) {
//			 return new ResponseEntity<UserProfile> (user,HttpStatus.OK);			
//		 	}
//		 
//		 return new ResponseEntity<UserProfile> (userProfile,HttpStatus.FORBIDDEN);
//		}
//
//	 @GetMapping("/userprofile/exists/{username}")
//	 public boolean doesUserExists(@PathVariable String username) {
//		 
//		 //RETURN FALSE IF LOGIN AND username are same
//		 
//		 UserPrincipal loggedInUser = (UserPrincipal) SecurityContextHolder.getContext().
//		getAuthentication().getPrincipal();
//
//			ActualUser actualUser=loggedInUser.getActualUser();
//			String uname=actualUser.getUsername();
//			
//			if(uname.equals(username))
//				return false; 
//			
//		 System.out.print("we have user "+username);
//		boolean x= this.userProfileService.doesUserExists(username);
//		return x;
//			}
//	 
	

	 
}
