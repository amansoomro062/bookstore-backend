package com.org.bookstore.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="appuser")
public class User {

	@Id
	@Column(length = 100)
	private String username;

	@Column(nullable = false)
	private String password;

	private String roles = "";

	private String permissions = "";

	private int active;

	// additional fields
	private String firstname;

	private String lastname;

	private String gender;

	private String address;
	
	private String rolesList[];
	private String permissionsList[];
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade=CascadeType.REMOVE)
	private List<Cart> userCart;

	//an order belong to a user so
	
	
//	@OneToMany(cascade= CascadeType.REMOVE)
	
	@JsonIgnore
	@OneToMany(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "userid")
	List<Order> userOrders = new ArrayList<Order>();
	
	
	
	public void setRolesList(String[] rolesList) {
		this.rolesList = rolesList;
	}

	public User(String username, String password, String roles, String permissions, int active, String firstname,
			String lastname, String gender, String address) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.permissions = permissions;
		this.active = active;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
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

	public User(String username, String password, String roles, String permissions, int active) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.permissions = permissions;
		this.active = active;
	}

	public User() {

	}

	public List<String> getRolesList() {

		if (this.roles.length() > 0) {

			return Arrays.asList(this.roles.split(","));
		} else {
			return new ArrayList<>();
		}
	}

	public List<String> getPermissionsList() {

		if (this.permissions.length() > 0) {

			return Arrays.asList(this.permissions.split(","));
		} else {
			return new ArrayList<>();
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	
	public List<Cart> getUserCart() {
		return userCart;
	}

	public void setUserCart(List<Cart> userCart) {
		this.userCart = userCart;
	}

	
	public List<Order> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(List<Order> userOrders) {
		this.userOrders = userOrders;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", roles=" + roles + ", permissions="
				+ permissions + ", active=" + active + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", gender=" + gender + ", address=" + address + "]";
	}


}

