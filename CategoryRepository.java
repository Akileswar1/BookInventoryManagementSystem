package com.cg.bim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bim.entity.Category;



@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}