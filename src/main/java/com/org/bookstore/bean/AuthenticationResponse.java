package com.org.bookstore.bean;

public class AuthenticationResponse {
 private String message;

	public AuthenticationResponse(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "AuthenticationResponse [message=" + message + "]";
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
 
 
}
