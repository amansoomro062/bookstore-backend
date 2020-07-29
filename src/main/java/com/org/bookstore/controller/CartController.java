package com.org.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.bookstore.bean.Cart;
import com.org.bookstore.bean.User;
import com.org.bookstore.service.ApplicationService;
import com.org.bookstore.service.CartService;

@CrossOrigin(origins = 
{"http://localhost:4200","https://xenodochial-sinoussi-0faef4.netlify.com"})
@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private ApplicationService applicationService;

	@PostMapping(value = "/addcart", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {

		User user = this.applicationService.getCurrentlyLoggedInUser();
		cart.setUser(user);

		Cart savedCart = this.cartService.addCart(cart);

		if (savedCart != null) {
			return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);
		}

		return new ResponseEntity<Cart>(cart, HttpStatus.FORBIDDEN);
	}
	
	@DeleteMapping(value = "/clearcart")
	public ResponseEntity<Void> clearCart() {
			this.cartService.clearCart();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletecart/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {

		this.cartService.deleteBook(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

//	@GetMapping("/getcart")
//	public List<Cart> getItemsInCart() {
//		String username = this.applicationService.getCurrentlyLoggedInUsername();
//		return this.cartService.getCart(username);
//	}
	
	//returns item in the cart for the user
	@GetMapping("/getcart")
	public List<Cart> getItemsInCart() {
		return this.cartService.getCart();
	}

	@GetMapping("/usercarttotleprice")
	public double getTottleCartPriceForUser() {
		double users_totle = this.cartService.calculateUsersTotle();
		return users_totle;
	}

	@PutMapping(value = "/updatecart", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Cart> updateCartItem(@RequestBody Cart cartItem) {

		System.out.println("lets update");

		Cart updatedItem = this.cartService.updateCart(cartItem);

		System.out.println("updated item " + updatedItem.getQuantity());

		if (updatedItem != null) {
			return new ResponseEntity<Cart>(updatedItem, HttpStatus.OK);
		}

		return new ResponseEntity<Cart>(cartItem, HttpStatus.FORBIDDEN);
	}
}
