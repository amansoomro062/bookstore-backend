package com.org.bookstore.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.org.bookstore.bean.ActualUser;
import com.org.bookstore.bean.User;

public class UserPrincipal implements UserDetails {
	
	//we use decorator pattern to connect UserPrincipal
	//with User class
	private User user;
	
	
	public UserPrincipal(){
	}
	
	public void setUser(User user) {
		this.user = user; 
	}
	
	
	public UserPrincipal(Optional<User> user2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities=new ArrayList<>();
		
		this.user.getPermissionsList().forEach(p ->{
			GrantedAuthority authority = new SimpleGrantedAuthority(p);
			authorities.add(authority);
		});
		
		this.user.getRolesList().forEach(r ->{
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+r);
			authorities.add(authority);
		});
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
	
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
	//return this.user.getActive()==1;
	return true;
	}

	
	public ActualUser getActualUser() {
		
		ActualUser actualUser= new ActualUser();
		
		
		actualUser.setActive( this.isEnabled() );
		actualUser.setUsername( this.getUsername() );
		actualUser.setRoles( this.user.getRoles() );
		
		ArrayList <String> permissions = new ArrayList<>();
		
		this.user.getPermissionsList()
		.forEach(p ->{
			permissions.add(p);
		});
		actualUser.setPermissions( permissions );
		return actualUser;
		
	}
	
	
	@Override
	public String toString() {
		return "UserPrincipal [user=" + user + "]";
	}
	
	

}
