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

import com.cg.bim.entity.PermRole;
import com.cg.bim.exception.RequestIdNotFound;
import com.cg.bim.repository.PermRoleRepository;


@RestController
@RequestMapping("/api")
public class PermRoleController {
	 @Autowired
	    private PermRoleRepository permRoleRepository;
	 @PostMapping("/permrole/post")
	    public ResponseEntity<PermRole> createBookCondition(@RequestBody PermRole permRole){
	        if(permRole==null) {
	            return new ResponseEntity<PermRole>(HttpStatus.NO_CONTENT);
	        }else {
	        	permRoleRepository.save(permRole);
	            return new ResponseEntity<PermRole>(permRole, HttpStatus.OK);
	        }
	    }
	 @GetMapping("/permrole/{roleNumber}")
	    public ResponseEntity<List<PermRole>> getPermRoleByRoleNumber(@PathVariable("roleNumber") Integer rolenumber){
	        List<PermRole> permRoles= permRoleRepository.findByRoleNumber(rolenumber);
	        if(permRoles==null) {
	            return new ResponseEntity<List<PermRole>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<PermRole>>(permRoles,HttpStatus.OK);
	    }
	 @PutMapping("permrole/update/permeole/{roleNumber}")
	    public ResponseEntity<PermRole> modifyByDescription(@PathVariable("roleNumber") Integer rolenumber, @RequestBody String permRole) throws Exception{
	        List<PermRole> permRole1=permRoleRepository.findPermRoleByRoleNumber(rolenumber);
	        if(permRole1.get(0)==null) {
	            throw new Exception("Idiot Request Id Not Found");
	        }else if(permRole==null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }else{
	        	permRole1.get(0).setPermRole(permRole);
	            permRoleRepository.save(permRole1.get(0));
	            return new ResponseEntity<PermRole>(permRole1.get(0), HttpStatus.OK);
	         }
	   }

}