package com.cg.bim.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@Table(name = "purchaselog")
@IdClass(PurchaseLogPrimaries.class)
@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = "inventory")
public class PurchaseLog {
	@Id
	@Column(name = "userid")
	Integer userID;
	@Id
	@Column(name = "inventoryid")
	Integer inventoryID;
	
@OneToOne
@Transient
Inventory inventory;
//public Integer getInventoryID() {
//	return inventory.getInventoryID();
//}
//public void setInventoryID(Integer inventoryID) {
//	inventory.setInventoryID(inventoryID);
//}

public Integer getUserID() {
	return userID;
}

public void setUserID(Integer userID) {
	this.userID = userID;
}

public Integer getInventoryID() {
	return inventoryID;
}

public void setInventoryID(Integer inventoryID) {
	this.inventoryID = inventoryID;
}

public Inventory getInventory() {
	return inventory;
}

public void setInventory(Inventory inventory) {
	this.inventory = inventory;
}


}