package com.cg.bim.service;



import java.util.List;

import org.springframework.http.ResponseEntity;


import com.cg.bim.entity.Author;
import com.cg.bim.entity.Book;



public interface BookAuthorService {
	public ResponseEntity<List<Book>> getBooksByAuthorId(Integer authorId);
	public ResponseEntity<List<Author>> getAuthorsByISBNId(String isbn);
	
}
