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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "publisher")
@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = "books")
public class Publisher {
	@Id
	@Column(name = "publisherid")
	Integer publisherID;
	@Column(name = "name",length = 50)
	String name;
	@Column(name = "city",length = 30)
	String city;
	@Column(name = "statecode",length = 2,columnDefinition = "char(2)")
	String stateCode;
	@OneToOne(cascade = CascadeType.ALL)
	@Transient
	List<Book> books;
	public Integer getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(Integer publisherID) {
		this.publisherID = publisherID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

}