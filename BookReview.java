package com.cg.bim.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "bookreview")
@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = "books")
public class BookReview {
@Id
@Column(name = "isbn")
String isbn;
@Column(name = "reviewerid")
Integer reviewerId;
@Column(name = "rating")
int rating;
@Column(name = "comments")
String comments;
//@ManyToOne
//Book books;
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public Integer getReviewerId() {
	return reviewerId;
}
public void setReviewerId(Integer reviewerId) {
	this.reviewerId = reviewerId;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}

}
