package com.org.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.org.bookstore.bean.Book;
import com.org.bookstore.bean.User;
import com.org.bookstore.service.BookService;
import com.org.bookstore.service.UserService;


@SpringBootApplication
public class BookStoreApplication{
	
	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

//
//	@Override
//	public void run(String... args) throws Exception {
//
//		User user = new User();
//		User admin = new User();
//		Book book = new Book();
//
//
//		book.setId((long) 223);
//		book.setName("Subtle Art of not giving a F***");
//		book.setAuthor_Name("Mark Manson");
//		book.setPrice(500);
//		book.setCategory("Genera;");
//		book.setImg_Source("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQHv2LgBcAojD9tLZcCZwOM1TB-Pm_9B9EY2zBZE5McZOnDdnN1");
//		book.setDescription("Best book on Self Developement");
//
//
//		user.setUsername("user");
//		user.setFirstname("appuser");
//		user.setPassword("user");
//
//		admin.setUsername("admin");
//		admin.setFirstname("appadmin");
//		admin.setPassword("admin");
//
//		this.userService.createNewUser(user);
//		this.userService.createNewAdmin(admin);
//
//	this.bookService.addBook(book);
//	}
//
}
