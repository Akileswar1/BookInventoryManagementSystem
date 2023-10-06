package com.cg.bim.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.bim.entity.Author;
import com.cg.bim.entity.Book;
import com.cg.bim.entity.BookAuthor;
import com.cg.bim.repository.AuthorRepository;
import com.cg.bim.repository.BookAuthorRepository;
import com.cg.bim.repository.BookRepository;
import com.cg.bim.service.BookAuthorService;

@Service
public class BookAuthorServiceImpl implements BookAuthorService{
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookAuthorRepository bookAuthorRepository;
	@Autowired
	AuthorRepository authorRepository;
	@Override
	public ResponseEntity<List<Book>> getBooksByAuthorId(Integer authorId){
        List<BookAuthor> bookAuthors= bookAuthorRepository.findByAuthorID(authorId);
        //List<Author> author=authorRepository.findAuthorByAuthorID(authorId);
        if(bookAuthors==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
        	List<String> isbnList = new ArrayList<>();

            for (BookAuthor bookAuthor : bookAuthors) {
                isbnList.add(bookAuthor.getIsbn());
            }
        List<Book> books=bookRepository.findAllByIsbnIn(isbnList);
       // AuthorBooks a=new AuthorBooks(authorId, author.get(0).getLastName(), author.get(0).getLastName(), author.get(0).getPhoto(), books);
        return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
    }
}
	@Override
	public ResponseEntity<List<Author>> getAuthorsByISBNId(String isbn) {
		 List<BookAuthor> bookAuthors= bookAuthorRepository.findBookAuthorByIsbn(isbn);
		 if(bookAuthors==null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }else {
	        	List<Integer> authoridlist = new ArrayList<>();

	            for (BookAuthor bookAuthor : bookAuthors) {
	                authoridlist.add(bookAuthor.getAuthorId());
	            }
	            List<Author> authors=authorRepository.findAllByAuthorIDIn(authoridlist);
	            return new ResponseEntity<List<Author>>(authors,HttpStatus.OK);
	}
	}
	
	
}
