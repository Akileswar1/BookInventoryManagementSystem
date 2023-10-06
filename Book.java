package com.cg.bim.entity;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "book")
@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"bookAuthor","bookReview","inventorys"})
public class Book {
	@Id
	@Column(name = "isbn",columnDefinition = "char(13) NOT NULL")
	String isbn;
	@Column(name = "title",length = 70)
	String title;
	@Column(name = "description",length = 100)
	String description;
	@Column(name = "category",length = 11,columnDefinition = "int DEFAULT NULL")
	int category;
	@Column(name = "edition",length = 30,columnDefinition = "char(30)")
	String edition;
	@Column(name = "publisherid",columnDefinition = "int")
	Integer publisherId;
	@OneToOne(cascade = CascadeType.ALL)
	@Transient
	BookAuthor bookAuthor;
	@OneToOne(cascade = CascadeType.ALL)
	@Transient
	BookReview bookReview;
	@OneToOne(cascade = CascadeType.ALL)
	@Transient
	Inventory inventorys;

	//@OneToOne
	//@Transient
	//BookAuthor bookAuthor;
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", edition=" + edition + ", publisherId=" + publisherId + "]";
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Integer getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}
	public Book(String isbn, String title, String description, int category, String edition, Integer publisherId) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.category = category;
		this.edition = edition;
		this.publisherId = publisherId;
	}
}