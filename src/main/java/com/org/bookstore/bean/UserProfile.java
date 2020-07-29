package com.org.bookstore.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "userprofile", schema = "book")

@Table(name = "userprofile")
public class UserProfile {
	
	@Id
	private String username;
	
	private String firstname;
	
	private String lastname;
	
	
	private String gender;
	
	private String address;
	
	
	
	public UserProfile() {
		
		// TODO Auto-generated constructor stub
	}


	public UserProfile(String username, String firstname, String lastname, String gender, String address) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserProfile [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", gender="
				+ gender + ", address=" + address + "]";
	}

	
	
	
}
