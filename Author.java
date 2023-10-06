package com.cg.bim.entity;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import lombok.Setter;

@Entity
@Table(name = "author")
@Getter
@Setter
@Data
@Builder
public class Author {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "authorid",columnDefinition = "int")
    Integer authorID;
    @Column(name = "lastname",length = 50,nullable = false)
    String lastName;
    @Column(name = "firstname",length = 50,nullable = false)
    String firstName;
    @Column(name = "photo",length = 1)
    String photo;

//    @OneToOne
//    @Transient
//    BookAuthor bookAuthor;
	public Integer getAuthorID() {
		return authorID;
	}
	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Author(Integer authorID, String lastName, String firstName, String photo) {
		super();
		this.authorID = authorID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.photo = photo;
	}
	public Author() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(authorID, firstName, lastName, photo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(authorID, other.authorID) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(photo, other.photo);
	}
	@Override
	public String toString() {
		return "Author [authorID=" + authorID + ", lastName=" + lastName + ", firstName=" + firstName + ", photo="
				+ photo + "]";
	}


    

}