package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery (name = "Users.findAll", query = "SELECT u FROM  Users u ORDER BY u.fullName "),
	@NamedQuery(name = "Users.countAll", query = "Select Count(*) From Users u")
})
public class Users {
	private Integer userID;
	private String email;
	private String fullName;
	private String password;
	
	@Column(name="user_id")
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUserID() {
		return userID;
	}
 
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="full_name")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
