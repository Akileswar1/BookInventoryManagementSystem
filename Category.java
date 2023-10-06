package com.cg.bim.entity;


import java.util.List;

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
@Table(name = "category")
@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	@Id
	@Column(name = "catid")
	Integer catID;
	@Column(name = "catdescription")
	String catDescription;
	//@OneToOne(cascade = CascadeType.ALL)
	//@Transient
	//List<Book> book3;
	public Integer getCatID() {
		return catID;
	}
	public void setCatID(Integer catID) {
		this.catID = catID;
	}
	public String getCatDescription() {
		return catDescription;
	}
	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}
	
}

