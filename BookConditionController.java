package com.cg.bim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bim.entity.BookCondition;
import com.cg.bim.exception.RequestIdNotFound;
import com.cg.bim.repository.BookConditionRepository;

@RestController
@RequestMapping("/api")
public class BookConditionController {
    @Autowired
    private BookConditionRepository bookConditionRepository;
    @PostMapping("/bookConditions")
    public ResponseEntity<BookCondition> createBookCondition(@RequestBody BookCondition bookCondition){
        if(bookCondition==null) {
            return new ResponseEntity<BookCondition>(HttpStatus.NO_CONTENT);
        }else {
            bookConditionRepository.save(bookCondition);
            return new ResponseEntity<BookCondition>(bookCondition, HttpStatus.OK);
        }
    }   
    
    @GetMapping("/bookCondition/{ranks}")
    public ResponseEntity<List<BookCondition>> getBookConditionsByRanks(@PathVariable("ranks") Integer ranks){
        List<BookCondition> bookConditions= bookConditionRepository.findByRanks(ranks);
        if(bookConditions==null) {
            return new ResponseEntity<List<BookCondition>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<BookCondition>>(bookConditions,HttpStatus.OK);
    }
    

    @PutMapping("bookCondition/update/description/{ranks}")
    public ResponseEntity<BookCondition> modifyByDescription(@PathVariable("ranks") Integer ranks, @RequestBody String bookCondition) throws Exception{
        List<BookCondition> bookCondition1=bookConditionRepository.findBookConditionsByRanks(ranks);
        if(bookCondition1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else if(bookCondition==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            bookCondition1.get(0).setDescription(bookCondition); 
            bookConditionRepository.save(bookCondition1.get(0));
            return new ResponseEntity<BookCondition>(bookCondition1.get(0), HttpStatus.OK);
         }
   }
    @PutMapping("bookCondition/update/fullDescription/{ranks}")
    public ResponseEntity<BookCondition> modifyByFullDescription(@PathVariable("ranks") Integer ranks, @RequestBody String bookCondition) throws Exception{
        List<BookCondition> bookCondition1=bookConditionRepository.findBookConditionsByRanks(ranks);
        if(bookCondition1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else if(bookCondition==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            bookCondition1.get(0).setFullDescription(bookCondition); 
            bookConditionRepository.save(bookCondition1.get(0));
            return new ResponseEntity<BookCondition>(bookCondition1.get(0), HttpStatus.OK);
         }
   }
    @PutMapping("bookCondition/update/price/{ranks}")
    public ResponseEntity<BookCondition> modifyByPrice(@PathVariable("ranks") Integer ranks, @RequestBody long bookCondition) throws Exception{
        List<BookCondition> bookCondition1=bookConditionRepository.findBookConditionsByRanks(ranks);
        if(bookCondition1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else if(bookCondition==0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            bookCondition1.get(0).setPrice(bookCondition);
            bookConditionRepository.save(bookCondition1.get(0));
            return new ResponseEntity<BookCondition>(bookCondition1.get(0), HttpStatus.OK);
         }
   }
    
   }
