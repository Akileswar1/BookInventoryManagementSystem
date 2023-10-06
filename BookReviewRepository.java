package com.cg.bim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bim.entity.BookReview;



public interface BookReviewRepository extends JpaRepository<BookReview, String> {

	BookReview findByIsbn(String isbn);
   
}