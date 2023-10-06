package com.cg.bim.service;

import java.util.List;

import com.cg.bim.entity.BookReview;


public interface BookReviewService {
    void addBookReview(BookReview bookReview);
    BookReview getBookReviewByIsbn(String isbn);
    BookReview updateRatingByIsbn(String isbn, Integer rating);
    BookReview updateCommentsByIsbn(String isbn, String comments);
   
}