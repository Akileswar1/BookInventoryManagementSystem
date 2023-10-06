package com.cg.bim.entity;

import java.util.Objects;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "bookauthor")
@IdClass(BookAuthorPrimaries.class)
public class BookAuthor {
	

    @Id
    @Column(name = "isbn",columnDefinition = "char(13)")
    private String isbn;

    @Id
    @Column(name = "authorid",columnDefinition = "int NOT NULL")
    private Integer authorID;

    @Column(name = "primaryauthor",length = 1)
    private char primaryAuthor;
    @OneToOne
    @Transient
    Book book;
    @OneToOne(cascade = CascadeType.ALL)
    @Transient
    Author author;
    // Other attributes and their respective getters/setters

    // Constructors

    public BookAuthor() {
    }

    public BookAuthor(String isbn, Integer authorId, char primaryAuthor) {
        this.isbn = isbn;
        this.authorID = authorId;
        this.primaryAuthor = primaryAuthor;
    }

    // Getters and setters

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAuthorId() {
        return authorID;
    }

    public void setAuthorId(Integer authorId) {
        this.authorID = authorId;
    }

    public char getPrimaryAuthor() {
        return primaryAuthor;
    }

    public void setPrimaryAuthor(char primaryAuthor) {
        this.primaryAuthor = primaryAuthor;
    }

	@Override
	public String toString() {
		return "BookAuthor [isbn=" + isbn + ", authorId=" + authorID + ", primaryAuthor=" + primaryAuthor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorID, isbn, primaryAuthor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookAuthor other = (BookAuthor) obj;
		return authorID == other.authorID && Objects.equals(isbn, other.isbn)
				&& Objects.equals(primaryAuthor, other.primaryAuthor);
	}

	

    // Other getters and setters for additional attributes


    

}
