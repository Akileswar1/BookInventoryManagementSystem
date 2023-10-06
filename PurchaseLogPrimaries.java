package com.cg.bim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Embeddable
@Data
@Getter
@Setter
public class PurchaseLogPrimaries {
	@Column(name = "userid")
	Integer userID;
	@Column(name = "inventoryid")
	Integer inventoryID;
	
}
