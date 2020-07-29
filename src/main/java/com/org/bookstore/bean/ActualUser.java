package com.org.bookstore.bean;

import java.util.ArrayList;

public class ActualUser {
	
	private String username;
	private boolean active;
	private String roles="";
	private ArrayList<String> permissions = new ArrayList<>();
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public ArrayList<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(ArrayList<String> permissions) {
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "ActualUser [username=" + username + ", active=" + active + ", roles=" + roles + ", permissions="
				+ permissions + "]";
	}



	

}
