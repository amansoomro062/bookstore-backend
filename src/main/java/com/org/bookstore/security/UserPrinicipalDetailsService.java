package com.org.bookstore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.bookstore.bean.User;
import com.org.bookstore.dao.UserRepository;

@Service
public class UserPrinicipalDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepository.findByUsername(username);
		
	//	UserPrincipal userPrincipal = new UserPrincipal(user);
		
	UserPrincipal userPrincipal = new UserPrincipal();
    userPrincipal.setUser(user);
		
		return userPrincipal;
	}
}
