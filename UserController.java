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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bim.entity.State;
import com.cg.bim.entity.User;
import com.cg.bim.exception.RequestIdNotFound;
import com.cg.bim.repository.UserRepository;
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        if(user==null) {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }else {
            userRepository.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }
    @GetMapping("user/{userid}")
    public ResponseEntity<List<User>> getByUserID(@PathVariable("userid") Integer userid) throws Exception{
        List<User> user=userRepository.findUsersByUserID(userid);
        if(user.get(0)==null) {
            throw new Exception("Idiot Id not Found! Unable to Getting");
        }else {
            return new ResponseEntity<List<User>>(user,HttpStatus.OK);
        }
        
    }
   
    @PutMapping("user/update/firstname/{userid}")
    public ResponseEntity<User> modifyByUserEmail(@PathVariable("userid") Integer userid, @RequestBody String user) throws Exception{
        List<User> user1=userRepository.findUsersByUserID(userid);
        if(user1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else if(user==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            user1.get(0).setFirstName(user);
            
            userRepository.save(user1.get(0));
            return new ResponseEntity<User>(user1.get(0), HttpStatus.OK);
         }
   }
    @PutMapping("user/update/lastname/{userid}")
    public ResponseEntity<User> modifyUserLastName(@PathVariable("userid") Integer userid, @RequestBody String user) throws Exception{
        List<User> user1=userRepository.findUsersByUserID(userid);
        if(user1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else if(user==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            user1.get(0).setLastName(user);
            
            userRepository.save(user1.get(0));
            return new ResponseEntity<User>(user1.get(0), HttpStatus.OK);
         }
   }
    @PutMapping("user/update/phonenumber/{userid}")
    public ResponseEntity<User> modifyUserPhoneNumber(@PathVariable("userid") Integer userid, @RequestBody String user) throws Exception{
        List<User> user1=userRepository.findUsersByUserID(userid);
        if(user1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else if(user==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            user1.get(0).setPhoneNumber(user);
            
            userRepository.save(user1.get(0));
            return new ResponseEntity<User>(user1.get(0), HttpStatus.OK);
         }
   }

}