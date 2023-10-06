package com.cg.bim.entity;

import java.util.List;
import java.util.Objects;

import org.hibernate.dialect.MySQLDialect;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")



public class User {
	@Id
	@Column(name = "userid")
	Integer userID;
	@Column(name = "lastname")
	String lastName;
	@Column(name = "firstname")
	String firstName;
	@Column(name = "phonenumber")
	String phoneNumber;
	@Column(name = "username")
	String userName;
	@Column(name="rolenumber")
	Integer roleNumber;



	//		@ManyToOne
	//		@JoinColumn(name="rolenumber", nullable=false)
	//		@JsonIgnore
	//		private PermRole permRole;

	public User() {
		// TODO Auto-generated constructor stub
	}



	public User(Integer userID, String lastName, String firstName, String phoneNumber, String userName,
			Integer roleNumber) {
		super();
		this.userID = userID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.roleNumber = roleNumber;
	}



	public Integer getUserID() {
		return userID;
	}



	public void setUserID(Integer userID) {
		this.userID = userID;
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



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public Integer getRoleNumber() {
		return roleNumber;
	}



	public void setRoleNumber(Integer roleNumber) {
		this.roleNumber = roleNumber;
	}



	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, phoneNumber, roleNumber, userID, userName);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(roleNumber, other.roleNumber)
				&& Objects.equals(userID, other.userID) && Objects.equals(userName, other.userName);
	}
	
	



	
	
	
	
	










}	