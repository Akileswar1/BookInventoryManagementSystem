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

import com.cg.bim.entity.Author;
import com.cg.bim.repository.AuthorRepository;
@RestController
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;
    @PostMapping("/author/post")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) throws Exception{
        if(author==null) {
            throw new Exception("You forgot to write Body");
        }else {
            authorRepository.save(author);
            return new ResponseEntity<Author>(author, HttpStatus.OK);
        }
    }
    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthors() throws Exception{
        List<Author> authors= authorRepository.findAll();
        if(authors==null) {
            throw new Exception("Idiot!! Author Table is empty!!!");
        }
        return new ResponseEntity<List<Author>>(authors,HttpStatus.OK);
    }
    @PutMapping("/authors/{authorid}")
    public ResponseEntity<Author> modifyByAuthorEmail(@PathVariable("authorid") Integer authorid, @RequestBody Author author) throws Exception{
        List<Author> author1=authorRepository.findAuthorByAuthorID(authorid);
        if(author1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else if(author==null) {
            throw new Exception("Idiot!! You forgot to write Body!!");
        }else{
            author1.get(0).setFirstName(author.getFirstName());
            author1.get(0).setLastName(author.getLastName());
            author1.get(0).setPhoto(author.getPhoto());
            authorRepository.save(author1.get(0));
            return new ResponseEntity<Author>(author1.get(0), HttpStatus.OK);
         }
   }
    @DeleteMapping("/author/{authorid}")
    public ResponseEntity<Author> DeleteByAuthorEmail(@PathVariable("authorid") Integer authorid) throws Exception{
        List<Author> author=authorRepository.findAuthorByAuthorID(authorid);
        if(author.get(0)==null) {
            throw new Exception("Idiot Id not Found!!!");
        }else {
            authorRepository.deleteById(authorid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/author/firstname/{firstname}")
    public ResponseEntity<List<Author>> getByAuthorFirstName(@PathVariable("firstname") String firstname) throws Exception{
        List<Author> author=authorRepository.findAuthorByFirstName(firstname);
        if(author.get(0)==null) {
            throw new Exception("Idiot Id not Found!!!");
        }else {
            //authorRepository.deleteById(authorid);
            return new ResponseEntity<List<Author>>(author,HttpStatus.OK);
        }
    }
    @GetMapping("/author/lastname/{lastname}")
    public ResponseEntity<List<Author>> getByAuthorLasttName(@PathVariable("lastname") String lastname) throws Exception{
        List<Author> author=authorRepository.findAuthorByLastName(lastname);
        if(author.get(0)==null) {
            throw new Exception("Idiot Id not Found!!!");
        }else {
            //authorRepository.deleteById(authorid);
            return new ResponseEntity<List<Author>>(author,HttpStatus.OK);
        }
    }
    @PutMapping("/author/update/firstname/{authorid}")
    public ResponseEntity<Author> modifyAuthorFirstName(@PathVariable("authorid") Integer authorid, @RequestBody String firstname) throws Exception{
    	List<Author> author1=authorRepository.findAuthorByAuthorID(authorid);
        if(author1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else if(firstname==null) {
            throw new Exception("You forgot to enter firstName in body!!");
        }else{
            author1.get(0).setFirstName(firstname);
            authorRepository.save(author1.get(0));
            return new ResponseEntity<Author>(author1.get(0), HttpStatus.OK);
         }
   }
    @PutMapping("/author/update/lastname/{authorid}")
    public ResponseEntity<Author> modifyByAuthorLastName(@PathVariable("authorid") Integer authorid, @RequestBody String lastname) throws Exception{
    	List<Author> author1=authorRepository.findAuthorByAuthorID(authorid);
        if(author1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else if(lastname==null) {
            throw new Exception("You forgot to mention lastname in body!!");
        }else{
            author1.get(0).setLastName(lastname);
            authorRepository.save(author1.get(0));
            return new ResponseEntity<Author>(author1.get(0), HttpStatus.OK);
         }
   }
    @GetMapping("/author/{authorid}")
    public ResponseEntity<List<Author>> getAllAuthorsBy(@PathVariable("authorid") Integer authorid) throws Exception{
        List<Author> author=authorRepository.findAuthorByAuthorID(authorid);
        if(author.get(0)==null) {
            throw new Exception("Idiot Id not Found!!!");
        }else {
            //authorRepository.deleteById(authorid);
            return new ResponseEntity<List<Author>>(author,HttpStatus.OK);
        }
    }
}