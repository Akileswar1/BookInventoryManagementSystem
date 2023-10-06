package com.cg.bim.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "bookcondition")
public class BookCondition {
    @Id  
    @Column(name = "ranks")
    private Integer ranks;
    @Column(name = "description")
    private String description;
    @Column(name = "fulldescription")
    private String fullDescription;
    @Column(name = "price")
    private long price;
    
    @OneToOne(cascade = CascadeType.ALL)
	@Transient
	List<Inventory> inventories;
    
    public BookCondition() {
		// TODO Auto-generated constructor stub
	}

	public BookCondition(Integer ranks, String description, String fullDescription, long price) {
		super();
		this.ranks = ranks;
		this.description = description;
		this.fullDescription = fullDescription;
		this.price = price;
	}

	public Integer getRank() {
		return ranks;
	}

	public void setRank(Integer ranks) {
		this.ranks = ranks;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}

	
	
	