package com.shuttle.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.shuttle.pojo.Email;
import com.shuttle.pojo.Person;

@Entity
@Table(name="Student")
@PrimaryKeyJoinColumn(name="Nuid")
public class Student extends Person{
	
	@Transient
	private String cPassword;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="student", cascade=CascadeType.ALL)
	List<Booking> booking;
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="student", cascade=CascadeType.ALL)
    private Email email;
		
	public Student() {
		
	}
	public Student(String username, String password) {
		this.username = username;
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
	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}
	
}
