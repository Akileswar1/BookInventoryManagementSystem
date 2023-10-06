package com.cg.bim.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookReviewNotFoundException extends RuntimeException {
    public BookReviewNotFoundException(String message) {
        super(message);
    }
}
