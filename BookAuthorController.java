package com.cg.bim.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.bim.entity.Author;
import com.cg.bim.entity.Book;


import com.cg.bim.entity.BookAuthor;


import com.cg.bim.repository.BookAuthorRepository;


import com.cg.bim.service.BookAuthorService;

@RestController
@RequestMapping("/api")
public class BookAuthorController {
    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    private BookAuthorService b;
    
    @GetMapping("author/books/{authorId}")
    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable("authorId") Integer authorId){
    	return b.getBooksByAuthorId(authorId);
       }
    @GetMapping("book/authors/{isbn}")
    public ResponseEntity<List<Author>> getAuthorssByISBNId(@PathVariable("isbn") String isbn){
    	return b.getAuthorsByISBNId(isbn);
       }
//    @GetMapping("authors/{isbn}")
//    public ResponseEntity<List<Author>> getAuthorsByISBNId(@PathVariable("isbn") String isbn){
//    	return b.getAuthorsByISBNId(isbn);
//       }
//    @GetMapping("/authors/book/{isbn}")
//    public ResponseEntity<List<Author>> createBookAuthor(@PathVariable("isbn") String isbn){
//    	List<Author> authors=bookAuthorRepository.findAuthorsByIsbn(isbn);
//        if(authors==null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }else {
//            bookAuthorRepository.save(bookAuthor);
//            return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
//        }
//    }
//}

    @PostMapping("/bookAuthors")
    public ResponseEntity<BookAuthor> createBookAuthor(@RequestBody BookAuthor bookAuthor) throws Exception{
        if(bookAuthor==null) {
            throw new Exception("Idiot!!! Body Not Found");
        }else {
            bookAuthorRepository.save(bookAuthor);
            return new ResponseEntity<BookAuthor>(bookAuthor, HttpStatus.OK);
        }
    }
    @GetMapping("/bookAuthors")
    public ResponseEntity<List<BookAuthor>> getBookAuthors() throws Exception{
        List<BookAuthor> bookAuthors= bookAuthorRepository.findAll();
        if(bookAuthors==null) {
            throw new Exception("No data in BookAuthors Table");
        }
        return new ResponseEntity<List<BookAuthor>>(bookAuthors,HttpStatus.OK);
    }
}

