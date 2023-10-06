package com.cg.bim.entity;

import java.io.Serializable;



import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class BookAuthorPrimaries implements Serializable{
	@Column(name = "isbn",length = 13,columnDefinition = "char(13)")
   String isbn;
   @Column(name = "authorid",length = 11,columnDefinition = "int NOT NULL")
   Integer authorID;
   
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}

public Integer getAuthorID() {
	return authorID;
}
public void setAuthorID(Integer authorID) {
	this.authorID = authorID;
}
public BookAuthorPrimaries(String isbn, Integer authorID) {
	super();
	this.isbn = isbn;
	this.authorID = authorID;
}
public BookAuthorPrimaries() {
	super();
}
@Override
public String toString() {
	return "BookAuthorPrimaries [isbn=" + isbn + ", authorID=" + authorID + "]";
}


}
