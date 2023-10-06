package com.cg.bim.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bim.entity.Book;
import com.cg.bim.repository.BookRepository;
@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) throws Exception{
        if(book==null) {
            throw new Exception("You forgot to enter Body!!");
        }else {
            bookRepository.save(book);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }
    }
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() throws Exception{
        List<Book> books= bookRepository.findAll();
        if(books==null) {
            throw new Exception("No data in Book Table");
        }
        return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
    }
    @PutMapping("/books/{bookid}")
    public ResponseEntity<Book> modifyByBookEmail(@PathVariable("bookid") String bookid, @RequestBody Book book) throws Exception{
        List<Book> book1=bookRepository.findBooksByIsbn(bookid);
        if(book1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else if(book==null) {
            throw new Exception("You forgot to enter Body!!");
        }else{
            book1.get(0).setDescription(book.getDescription());
            book1.get(0).setCategory(book.getCategory());
            book1.get(0).setEdition(book.getEdition());
            book1.get(0).setPublisherId(book.getPublisherId());
            book1.get(0).setTitle(book.getTitle());
            bookRepository.save(book1.get(0));
            return new ResponseEntity<Book>(book1.get(0), HttpStatus.OK);
         }
   }
    @DeleteMapping("/book/{bookid}")
    public ResponseEntity<Book> DeleteByBookEmail(@PathVariable("bookid") String bookid) throws Exception{
        List<Book> book=bookRepository.findBooksByIsbn(bookid);
        if(book.get(0)==null) {
            throw new Exception("Idiot Id not Found! Unable to Delete");
        }else {
            bookRepository.deleteById(bookid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/book/{isbn}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable("isbn") String isbn) throws Exception{
        List<Book> book=bookRepository.findBooksByIsbn(isbn);
        if(book.get(0)==null) {
            throw new Exception("Idiot!! Id not Found!");
        }else {
            
            return new ResponseEntity<Book>(book.get(0),HttpStatus.OK);
        }
    }
    @GetMapping("/book/title/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title) throws Exception{
        List<Book> book=bookRepository.findBooksByTitle(title);
        if(book.get(0)==null) {
            throw new Exception("Idiot!! Id not Found!");
        }else {
            
            return new ResponseEntity<Book>(book.get(0),HttpStatus.OK);
        }
    }
    @GetMapping("/book/category/{category}")
    public ResponseEntity<List<Book>> getBookByCategory(@PathVariable("category") int category) throws Exception{
        List<Book> book=bookRepository.findBooksByCategory(category);
        if(book.get(0)==null) {
            throw new Exception("Idiot Id not Found!");
        }else {
            
            return new ResponseEntity<List<Book>>(book,HttpStatus.OK);
        }
    }
    @GetMapping("/book/publisher/{publisherid}")
    public ResponseEntity<List<Book>> getBookByCategory(@PathVariable("publisherid") Integer publisherid) throws Exception{
        List<Book> book=bookRepository.findBooksByPublisherId(publisherid);
        if(book.get(0)==null) {
            throw new Exception("Idiot Id not Found!");
        }else {
            
            return new ResponseEntity<List<Book>>(book,HttpStatus.OK);
        }
    }
    @PutMapping("/book/update/title/{isbn}")
    public ResponseEntity<List<Book>> modifyBookTitleByIsbn(@PathVariable("isbn") String isbn,@RequestBody String title) throws Exception{
        List<Book> book=bookRepository.findBooksByIsbn(isbn);
        if(book.get(0)==null) {
            throw new Exception("Idiot Id not Found!");
        }else {
            book.get(0).setTitle(title);
            bookRepository.save(book.get(0));
            return new ResponseEntity<List<Book>>(book,HttpStatus.OK);
        }
    }
    @PutMapping("/book/update/description/{isbn}")
    public ResponseEntity<List<Book>> modifyBookDescriptionByIsbn(@PathVariable("isbn") String isbn,@RequestBody String description) throws Exception{
        List<Book> book=bookRepository.findBooksByIsbn(isbn);
        if(book.get(0)==null) {
            throw new Exception("Idiot Id not Found!");
        }else {
            book.get(0).setDescription(description);
            bookRepository.save(book.get(0));
            return new ResponseEntity<List<Book>>(book,HttpStatus.OK);
        }
    }
    @PutMapping("/book/update/edition/{isbn}")
    public ResponseEntity<List<Book>> modifyBookEditionByIsbn(@PathVariable("isbn") String isbn,@RequestBody String edition) throws Exception{
        List<Book> book=bookRepository.findBooksByIsbn(isbn);
        if(book.get(0)==null) {
            throw new Exception("Idiot Id not Found!");
        }else {
            book.get(0).setEdition(edition);
            bookRepository.save(book.get(0));
            return new ResponseEntity<List<Book>>(book,HttpStatus.OK);
        }
    }
    @PutMapping("/book/update/category/{isbn}")
    public ResponseEntity<Book> modifyBookCategoryIsbn(@PathVariable("isbn") String isbn,@RequestBody int category) throws Exception{
        List<Book> book=bookRepository.findBooksByIsbn(isbn);
        if(book.get(0)==null) {
            throw new Exception("Idiot Id not Found!");
        }else {
            book.get(0).setCategory(category);
            bookRepository.save(book.get(0));
            return new ResponseEntity<Book>(book.get(0),HttpStatus.OK);
        }
    }
    @PutMapping("/book/update/publisher/{isbn}")
    public ResponseEntity<Book> modifyBookPublisherIdIsbn(@PathVariable("isbn") String isbn,@RequestBody Integer publisherid) throws Exception{
        List<Book> book=bookRepository.findBooksByIsbn(isbn);
        if(book.get(0)==null) {
            throw new Exception("Idiot Id not Found!");
        }else {
            book.get(0).setPublisherId(publisherid);
            bookRepository.save(book.get(0));
            return new ResponseEntity<Book>(book.get(0),HttpStatus.OK);
        }
    }
}