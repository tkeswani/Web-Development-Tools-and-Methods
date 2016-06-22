package com.shuttle.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Admin")
@PrimaryKeyJoinColumn(name="Nuid")
public class Admin extends Person{

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Transient
	private String cPassword;

//	@OneToOne(fetch=FetchType.EAGER, mappedBy="admin", cascade=CascadeType.ALL)
 //   private Email email;
	
	public Admin() {
		
	}
	
	public Admin(String username, String password) {
		this.username  = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

//	public Email getEmail() {
//		return email;
//	}
//
//	public void setEmail(Email email) {
//		this.email = email;
//	}
//	
//	
}
