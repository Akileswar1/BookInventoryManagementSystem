package com.cg.bim.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reviewer")
@Builder
@Data

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = "bookReviews")
public class Reviewer {
@Id
@Column(name = "reviewerid")
Integer reviewerID;
@Column(name = "name")
String name;
@Column(name = "employedby")
String employedBy; ///!!!! it should have only characters
@OneToOne(cascade = CascadeType.ALL)
@Transient
BookReview bookReviews;
public Integer getReviewerID() {
	return reviewerID;
}
public void setReviewerID(Integer reviewerID) {
	this.reviewerID = reviewerID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmployedBy() {
	return employedBy;
}
public void setEmployedBy(String employedBy) {
	this.employedBy = employedBy;
} 

}
