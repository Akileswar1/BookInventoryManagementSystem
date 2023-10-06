package com.cg.bim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cg.bim.entity.BookReview;
import com.cg.bim.service.BookReviewService;



@RestController
@RequestMapping("/api")
public class BookReviewController {
	private final BookReviewService bookReviewService;

	@Autowired
	public BookReviewController(BookReviewService bookReviewService) {
		this.bookReviewService = bookReviewService;
	}

	@PostMapping("/bookreview/post")
	public ResponseEntity<String> addBookReview(@RequestBody BookReview bookReview) {
		bookReviewService.addBookReview(bookReview);
		return ResponseEntity.ok("Book review added successfully");
	}

	@GetMapping("/bookreview/{isbn}")
	public ResponseEntity<BookReview> getBookReview(@PathVariable String isbn) {
		BookReview bookReview = bookReviewService.getBookReviewByIsbn(isbn);
		return ResponseEntity.ok(bookReview);
	}
	@PutMapping("/bookreview/update/rating/{isbn}")
    public ResponseEntity<BookReview> updateRatingByIsbn(@PathVariable String isbn, @RequestBody Integer newRating) {
        	BookReview updatedBookReview = bookReviewService.updateRatingByIsbn(isbn, newRating);
            return ResponseEntity.ok(updatedBookReview);
         }
        
	@PutMapping("/bookreview/update/comments/{isbn}")
    public ResponseEntity<BookReview> updateCommentsByIsbn(@PathVariable String isbn,@RequestBody String newComments) {
        BookReview updatedBookReview = bookReviewService.updateCommentsByIsbn(isbn, newComments);
        return ResponseEntity.ok(updatedBookReview);
    }
}