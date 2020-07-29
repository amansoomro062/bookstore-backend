package com.org.bookstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.bookstore.bean.Book;
import com.org.bookstore.dao.BookRepo;

@Component
public class BookService {

	@Autowired
	private BookRepo repo;
	@Autowired
	private CartService cartService;
	
	
	

	// get all books
	public List<Book> findAllBooks() {
		return repo.findAll();
		// return this.getBookMap( repo.findAll() );
	}

	// get all unique categories of books
	public List<String> findBooksCategories() {
		return repo.findDistinctBookCategories();
	}

	public HashMap<Long, Book> findBooksByCategory(String category) {
		return this.getBookMap(repo.findByCategory(category));
	}

	public Optional<Book> findBooksById(Long id) {
		return repo.findById(id);
	}

	public long findMaxBookid() {
		return repo.findAvailableBookId();
	}

	private HashMap<Long, Book> getBookMap(List<Book> books) {
		HashMap<Long, Book> booksMap = new HashMap<>();

		for (Book i : books) {
			booksMap.put(i.getId(), i);
		}

		return booksMap;
	}

	// save books
	public Book addBook(Book book) {
		return this.repo.save(book);
	}

	// update books
		public Book updateBook(Book book) {
			Book updatedBook = this.repo.save(book);
			return updatedBook;
		}
		
		
	// delete book by id
	public void deleteBook(long bookid) {
		this.repo.deleteById(bookid);

	}

}
