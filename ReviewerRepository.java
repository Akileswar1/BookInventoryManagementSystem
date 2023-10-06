package com.cg.bim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.bim.entity.Reviewer;
public interface ReviewerRepository extends JpaRepository<Reviewer, Integer>{
	List<Reviewer> findReviewersByReviewerID(Integer reviewerID);
}