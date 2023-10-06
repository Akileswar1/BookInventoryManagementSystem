package com.cg.bim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bim.entity.Book;

public interface BookRepository extends JpaRepository<Book, String>{
	List<Book> findBooksByIsbn(String isbn);

	List<Book> findBooksByTitle(String title);
	List<Book> findBooksByCategory(int category);
	List<Book> findAllByIsbnIn(List<String> isbnList);
	List<Book> findBooksByPublisherId(Integer publisherId);
}
