package com.org.bookstore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.bookstore.bean.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

	public List<Book> findByCategory(String cateogry);
	public Optional<Book> findById(Long id);
	
	@Query("SELECT DISTINCT category FROM Book order by category asc")
	  List<String> findDistinctBookCategories();

	@Query("SELECT max(id)+1 from Book ")
	  long findAvailableBookId();
}
