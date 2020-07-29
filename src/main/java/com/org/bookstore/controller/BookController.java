package com.org.bookstore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.bookstore.bean.Book;
import com.org.bookstore.service.BookService;
import com.org.bookstore.service.CartService;

@CrossOrigin(origins = 
{"http://localhost:4200","https://xenodochial-sinoussi-0faef4.netlify.com"})

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private CartService cartService;

//	public open api

	@RequestMapping("/getbooks")
	public List<Book> getBooks() {
		return bookService.findAllBooks();
	}

//public open api
	@RequestMapping("/getbooks/categories")

	public List<String> getBooksCategories() {
		return bookService.findBooksCategories();
	}

//public open api

	@RequestMapping(value = { "/getbooks/category/{category}" })
	public HashMap<Long, Book> getBookByCategory(@PathVariable String category) {
		return bookService.findBooksByCategory(category);
	}

	// get book by id sepecific to user
	@RequestMapping(value = { "/getbooks/id/{id}" })
	public Optional<Book> getBookById(@PathVariable Long id) {
		return bookService.findBooksById(id);
	}

	// admin can add books here
	@PostMapping(value = "/addbook", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		System.out.println("lets save jt");
		Book savedBook = this.bookService.addBook(book);

		if (savedBook != null) {
			return new ResponseEntity<Book>(savedBook, HttpStatus.OK);
		}

		return new ResponseEntity<Book>(book, HttpStatus.FORBIDDEN);
	}

	@PutMapping(value = "/updatebook", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {

		Book savedBook = this.bookService.updateBook(book);

		// now for all cart with id updatedBook.id update the price;
		cartService.updateCartForBookChanges(savedBook);

		if (savedBook != null) {
			return new ResponseEntity<Book>(savedBook, HttpStatus.OK);
		}

		return new ResponseEntity<Book>(book, HttpStatus.FORBIDDEN);
	}

	@DeleteMapping(value = "/deletebook/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		this.bookService.deleteBook(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// get next available book id
	@RequestMapping(value = { "/getbooks/maxid" })
	public long getBookMaxId() {
		return bookService.findMaxBookid();
	}

}
