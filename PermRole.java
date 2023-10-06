package com.cg.bim.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "permrole")
//@JsonIgnoreProperties(value = "users")
public class PermRole {
	@Id
	@Column(name = "rolenumber",unique = true)
    private int roleNumber;
	@Column(name = "permrole")
    private String permRole;
	
	 @OneToOne(cascade = CascadeType.ALL)
	    private User  users;
	
	 
	 public PermRole() {
		// TODO Auto-generated constructor stub
	}
	public PermRole(int roleNumber, String permRole) {
		super();
		this.roleNumber = roleNumber;
		this.permRole = permRole;
	}
	public int getRoleNumber() {
		return roleNumber;
	}
	public void setRoleNumber(int roleNumber) {
		this.roleNumber = roleNumber;
	}
	public String getPermRole() {
		return permRole;
	}
	public void setPermRole(String permRole) {
		this.permRole = permRole;
	}
	

}
