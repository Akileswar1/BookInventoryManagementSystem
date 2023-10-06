package com.cg.bim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bim.entity.BookCondition;

@Repository
public interface BookConditionRepository extends JpaRepository<BookCondition, String> {
	List<BookCondition> findBookConditionsByRanks(Integer ranks);
	 List<BookCondition> findByRanks(Integer ranks);
}