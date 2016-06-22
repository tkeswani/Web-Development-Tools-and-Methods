package com.shuttle.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Person")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person{
	
	
	@Id
	@Column(name = "Nuid", unique=true, nullable = false)
	private int nuid;
	
	@Column(name = "Name")
	private String name;
	
	
	@Column(name = "phoneNum")
	private long phoneNum;
	
//	@OneToOne(fetch=FetchType.EAGER, mappedBy="roleType", cascade= CascadeType.ALL)
//	private Role role;

	@Column(name="role")
	private String role;

	public int getNuid() {
		return nuid;
	}

	public void setNuid(int nuid) {
		this.nuid = nuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}

