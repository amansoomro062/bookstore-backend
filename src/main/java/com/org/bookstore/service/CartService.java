package com.org.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.bookstore.bean.Book;
import com.org.bookstore.bean.Cart;
import com.org.bookstore.bean.Order;
import com.org.bookstore.bean.User;
import com.org.bookstore.dao.BookRepo;
import com.org.bookstore.dao.CartRepo;
import com.org.bookstore.dao.UserRepository;

@Component
public class CartService {

	@Autowired
	private CartRepo cartRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private ApplicationService appService;

	public Cart addCart(Cart item) {
		
		//check if the item already exists in the cart if so delete it. insert it the item
		User user = item.getUser();
		Book book = item.getBook();
		
	Cart cartIem= cartRepo.findItemInCart(user, book);
	
			if(cartIem !=null) {
				cartRepo.delete(cartIem);
			}			
		return cartRepo.save(item);
	}
	
	//delete all items from cart
	 @Transactional
	public void clearCart() {
		User user = appService.getCurrentlyLoggedInUser();
		cartRepo.clearCartItems(user);
	}
	 
	 
	// it sets in_cart flag to false 
	 public void setConfirmCartItems() {
			User user = appService.getCurrentlyLoggedInUser();
			List<Cart> cartItems= cartRepo.findByUser(user);
		
		//forEach item in cart make it not in cart
		cartItems.forEach((Cart cart) -> {
				cart.setIn_cart(false);
		});
		
		cartRepo.saveAll(cartItems);
		
	 }
	 
	 //returns list of cart items which have been confirmed
	List<Cart> getConfirmedCartItem(){
			User user = appService.getCurrentlyLoggedInUser();
		 	return this.cartRepo.findByUserNotInCartFlag(user);
	 }
	
	public void deleteBook(Long cartid) {
		cartRepo.deleteById(cartid);
	}
	
	
//	public List<Cart> getCart(String username) {
//		User user = userRepo.findById(username).get();
//		List<Cart> itemsInCart = this.cartRepo.findByUser(user);		
//		return itemsInCart;
//	}

	public List<Cart> getCart() {
		User user = this.appService.getCurrentlyLoggedInUser();
		List<Cart> itemsInCart = this.cartRepo.findByUser(user);		
		return itemsInCart;
	}
	
	public Cart updateCart(Cart cartItem) {

//		String user = cartItem.getUser().getUsername();
//		long book = cartItem.getBook().getId();
//		UserBookId id = new UserBookId(book, user);

		Cart originalItem = cartRepo.findById(cartItem.getId()).get();

		if (cartItem.getQuantity() < 1) {
			return originalItem;
		}

		if (cartItem.getQuantity() > 10) {
			originalItem.setQuantity(10);
			originalItem.setTotle_price(cartItem.getPrice() * 10);
			return originalItem;
		}

		cartItem.setPrice(originalItem.getPrice());

		cartItem.setTotle_price(cartItem.getPrice() * cartItem.getQuantity());

		return cartRepo.save(cartItem);
	}

	public void updateCartForBookChanges(Book updatedBook) {

		List<Cart> items = cartRepo.findByBook(updatedBook);
		

		items.forEach((Cart item) -> {
			item.setPrice(updatedBook.getPrice());
			item.setTotle_price(updatedBook.getPrice() * item.getQuantity());
		});

		cartRepo.saveAll(items);

	}

	//calculates totle for all items in cart
	public double calculateUsersTotle() {
		double totle_users_price = 0;

		User user = this.appService.getCurrentlyLoggedInUser();
		List<Cart> cartItems = cartRepo.findByUser(user);

		for (Cart item : cartItems) {
			totle_users_price += item.getTotle_price();
		}

		return totle_users_price;
	}

	//returns list for unique order ids for the user
	public List<Long> getUniqueOrders() {
		User user = this.appService.getCurrentlyLoggedInUser();
		List<Long>	uniqueOrders = this.cartRepo.findUniqueOrderId(user);
		return uniqueOrders;
	}

	//returns list<cart> based on the order id 
	
	public List<Cart> getCartsByOrder(Order order){
		List<Cart> cartItemsByOrder = this.cartRepo.findByOrder(order);
		return cartItemsByOrder;
		}
			
}
