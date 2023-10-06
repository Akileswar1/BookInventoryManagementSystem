package com.cg.bim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bim.entity.PermRole;


@Repository
public interface PermRoleRepository extends JpaRepository<PermRole, Integer> {
	List<PermRole> findPermRoleByRoleNumber(Integer roleNumber);
	 List<PermRole> findByRoleNumber(Integer roleNumber);
    
    
}
