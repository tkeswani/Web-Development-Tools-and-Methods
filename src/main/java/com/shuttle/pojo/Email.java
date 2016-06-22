package com.shuttle.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.shuttle.pojo.Student;

@Entity
@Table(name="Email")
public class Email {

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "student"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Nuid", unique = true, nullable = false)
	private int nuid;

	@Column(name = "emailId")
	private String emailId;

	
	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn(name="Nuid")
	private Student student;
	
	public Email () {
		
	}
	public Email(String emailId) {
		this.emailId = emailId;
	}
	
	public int getNuid() {
		return nuid;
	}

	public void setNuid(int nuid) {
		this.nuid = nuid;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}

