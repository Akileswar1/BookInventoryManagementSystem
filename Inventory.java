package com.cg.bim.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inventory")
@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
	@Id
	@Column(name = "inventoryid")
	Integer inventoryID;
	@Column(name = "isbn",length = 13,columnDefinition = "char(13)")
	String isbn;
	@Column(name = "ranks")
	Integer ranks;
	@Column(name = "purchased", length = 1,columnDefinition = "tinyint(1) DEFAULT 0")
	byte purchased;
	public Integer getInventoryID() {
		return inventoryID;
	}
	public void setInventoryID(Integer inventoryID) {
		this.inventoryID = inventoryID;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getRanks() {
		return ranks;
	}
	public void setRanks(Integer ranks) {
		this.ranks = ranks;
	}
	public byte getPurchased() {
		return purchased;
	}
	public void setPurchased(byte purchased) {
		this.purchased = purchased;
	}
	
}
