package com.org.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.org.bookstore.bean.Order;
import com.org.bookstore.bean.User;
import com.org.bookstore.dao.UserRepository;

@Component
public class UserService { 
	
	@Autowired
	private UserRepository repo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ApplicationService appService;
	
	//for testing purpose only
	 public  void createNewAdmin(User user) {
		 String password= user.getPassword();
		 String encodedPassword=this.passwordEncoder.encode(password);	
		 user.setPassword(encodedPassword);	
			user.setRoles("Admin");
			user.setActive(1);	
			this.repo.save(user);
	 }
	 
	 public  void createNewUser(User user) {
		 String password= user.getPassword();
		 String encodedPassword=this.passwordEncoder.encode(password);	
		 user.setPassword(encodedPassword);	
			user.setRoles("User");
			user.setActive(1);	
			this.repo.save(user);
	 }
	 
	 public User findByUsername(String username) {
		 return this.repo.findByUsername(username);
	 }

	 
	 public List<User> getAllUsers() {
			 
		 List<User> users= this.repo.findAll();
		 
		 for(User user:users) {
			 	user.setPassword("");
			 	user.setPermissions("");

		 }
		 return users;
	 }
	 
	 
	public User findUserProfileByUsername(String username) {

		User user = this.findByUsername(username);

		System.out.println("return me "+user);
//		user.setPassword("");
//		user.setRoles("");
//		user.setPermissions("");
//		user.setActive(-1);

		return user;
	}
	
	
public User updateUserProfile(User userProfile) {
		
		String username=userProfile.getUsername();
		
		Optional<User>  user=repo.findById(username);
		
		if(user.isPresent()) {
			return this.repo.save(userProfile);	
		}
	return null;		
	}
	 


public User[] updateUsers(User[] users) {
	
	
	List<User> u= this.repo.findAll();
	
	User[] existingUsers = new User[u.size()];
	
		
			existingUsers= u.toArray(existingUsers);
			
			
			
//	User[] existingUsers= (User[]) this.repo.findAll().toArray();
	
	List<User> updatedUsers = new ArrayList<User>();
	
	
	for(int i=0;i<existingUsers.length;i++) {
		existingUsers[i].setRoles( users[i].getRoles() );
		existingUsers[i].setActive(  users[i].getActive() );
		
	updatedUsers.add(existingUsers[i]);
	
	}
	System.out.println(updatedUsers);
	
	
	 this.repo.saveAll(updatedUsers);

	return existingUsers;	
}


public void addOrderToTheUser(Order order) {
	User user = this.appService.getCurrentlyLoggedInUser();

	List<Order> userOrder = user.getUserOrders();
	userOrder.add(order);
	user.setUserOrders(userOrder);
	
//	user.getUserOrders().add(order);
	
	
//	this.repo.save(user);
}
 

	 
	
}
