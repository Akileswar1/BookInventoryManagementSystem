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

import com.cg.bim.entity.Reviewer;

import com.cg.bim.entity.User;
import com.cg.bim.exception.RequestIdNotFound;
import com.cg.bim.repository.ReviewerRepository;
@RestController
@RequestMapping("/api")
public class ReviewerController {

@Autowired
private ReviewerRepository reviewerRepository;


@PostMapping("/reviewer/post")
public String createReviewer(@RequestBody Reviewer reviewer){
        if(reviewer==null) {
        return "Not added";
     }else {
       reviewerRepository.save(reviewer);
         return "reviewer added successfully";

        }
    }


    @PutMapping("/reviewer/name/{reviewerid}")
    public ResponseEntity<Reviewer> modifyFirstNameByReviewerID(@PathVariable("reviewerid") Integer reviewerid,@RequestBody String  firstName) throws Exception{
        List<Reviewer> reviewer1=reviewerRepository.findReviewersByReviewerID(reviewerid);
        if(reviewer1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else if(firstName==null) {

        	throw new Exception("you forgot to enter firstname in body");
        }

        else{
        	
            reviewer1.get(0).setName(firstName);
            reviewerRepository.save(reviewer1.get(0));
            return new ResponseEntity<Reviewer>(reviewer1.get(0), HttpStatus.OK);

        }
    }
    @PutMapping("/reviewer/employedby/{reviewerid}")
    public ResponseEntity<Reviewer> updateEmployedByByReviewerID(@PathVariable("reviewerid") Integer reviewerid,@RequestBody String  employedBy) throws Exception{
        List<Reviewer> reviewer1=reviewerRepository.findReviewersByReviewerID(reviewerid);
        if(reviewer1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else if(employedBy==null) {

        	throw new Exception("you forgot to enter body");
        }

        else{
        	
            reviewer1.get(0).setEmployedBy(employedBy);
            reviewerRepository.save(reviewer1.get(0));
            return new ResponseEntity<Reviewer>(reviewer1.get(0), HttpStatus.OK);

        }
    }
    @GetMapping("/reviewer/{reviewerid}")
    public ResponseEntity<List<Reviewer>> getByReviewerID(@PathVariable("reviewerid") Integer reviewerid) throws Exception{
        List<Reviewer> user=reviewerRepository.findReviewersByReviewerID(reviewerid);
        if(user.get(0)==null) {
            throw new Exception("Idiot Id not Found! Unable to Getting");
        }else {
            return new ResponseEntity<List<Reviewer>>(user,HttpStatus.OK);
        }
        
    }
    
}
    
