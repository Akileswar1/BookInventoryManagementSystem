package com.cg.bim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bim.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findUsersByUserID(Integer userID);
	
}





