package com.cg.bim.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	ResponseEntity<ExceptionMessage> methodNotFound(HttpRequestMethodNotSupportedException e){
		ExceptionMessage message=new ExceptionMessage();
		return ResponseEntity.badRequest().body(message);
	}
	@ExceptionHandler(Exception.class)
	ResponseEntity<ExceptionMessage> exception(Exception e){
		ExceptionMessage message=new ExceptionMessage();
		return ResponseEntity.badRequest().body(message);
	}
}
