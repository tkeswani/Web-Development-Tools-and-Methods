package com.shuttle.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="Booking")
public class Booking{

	
//	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "student"))
//	@GeneratedValue(generator = "generator")
//	@Column(name = "Nuid", unique = true, nullable = false, )
//	private int nuid;
	
	@Id
	@GeneratedValue
	@Column(name="bookingID", unique=true, nullable = false)
	private int bookingID;
	
	@Column(name="Time")
	private String time;
	
	@Column(name="Date")
	private String date;
	
	@Column(name="AptNo")
	private String aptNo;
	
	@Column(name="Street")
	private String street;
	
	@Column(name="City")
	private String city;
	
	@Column(name="State")
	private String state;
	
	@Column(name="ZipCode")
	private String zipCode;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="Nuid")
	private Student student;
	
	
	public Booking() {
		super();
	}

//	public int getNuid() {
//		return nuid;
//	}
//
//
//	public void setNuid(int nuid) {
//		this.nuid = nuid;
//	}


	public Student getStudent() {
		return student;
	}


//	public int getNuid() {
//		return nuid;
//	}
//
//	public void setNuid(int nuid) {
//		this.nuid = nuid;
//	}

	public void setStudent(Student student) {
		this.student = student;
	}


	public String getAptNo() {
		return aptNo;
	}


	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}	
	
}
