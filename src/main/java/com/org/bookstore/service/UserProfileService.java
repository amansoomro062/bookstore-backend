package com.org.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.bookstore.bean.UserProfile;
import com.org.bookstore.dao.UserProfileRepo;

@Component
public class UserProfileService {
	
	@Autowired
	private UserProfileRepo userProfileRepo;
	
	
	public Optional<UserProfile> findUserProfileByUsername(String username) {	
		return this.userProfileRepo.findById(username);
	}
	
	
	public UserProfile updateUserProfile(UserProfile userProfile) {
		
		String username=userProfile.getUsername();
		
		Optional<UserProfile>  user=userProfileRepo.findById(username);
		if(user.isPresent()) {
			return this.userProfileRepo.save(userProfile);	
		}
	return null;		
	}
	
	
	public boolean doesUserExists(String username) {
		
		Optional<UserProfile>  user=userProfileRepo.findById(username);		
	
		System.out.println("username is ");
		if(user.isPresent()) {
			return true;
		}
		return false;	
	}
	
	
}
