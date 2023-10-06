package com.cg.bim.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bim.entity.BookReview;
import com.cg.bim.exception.BookReviewNotFoundException;
import com.cg.bim.repository.BookReviewRepository;
import com.cg.bim.service.BookReviewService;



@Service
public class BookReviewServiceImpl implements BookReviewService {
    private final BookReviewRepository bookReviewRepository;

    @Autowired
    public BookReviewServiceImpl(BookReviewRepository bookReviewRepository) {
        this.bookReviewRepository = bookReviewRepository;
    }

    @Override
    public void addBookReview(BookReview bookReview) {
        bookReviewRepository.save(bookReview);
    }


	@Override
	public BookReview getBookReviewByIsbn(String isbn) {
		BookReview bookReview = bookReviewRepository.findByIsbn(isbn);
        if (bookReview == null) {
            throw new BookReviewNotFoundException("Book review not found with ISBN: " + isbn);
        }
        return bookReview;
	}

	@Override
    public BookReview updateRatingByIsbn(String isbn, Integer rating) {
        BookReview bookReview = bookReviewRepository.findByIsbn(isbn);
        if (bookReview == null) {
        	throw new BookReviewNotFoundException("Book review not found for ISBN: " + isbn);
            
        } else {
        	bookReview.setRating(rating);
            return bookReviewRepository.save(bookReview);
        }
	}
        @Override
        public BookReview updateCommentsByIsbn(String isbn, String comments) {
            BookReview bookReview = bookReviewRepository.findByIsbn(isbn);
            if (bookReview != null) {
                bookReview.setComments(comments);
                return bookReviewRepository.save(bookReview);
            } else {
                throw new BookReviewNotFoundException("Book review not found for ISBN: " + isbn);
            }
    }
}

