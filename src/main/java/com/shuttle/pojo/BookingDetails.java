//package com.shuttle.pojo;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.PrimaryKeyJoinColumns;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//@Entity
//@Table(name="BookingDetails")
//@PrimaryKeyJoinColumns({
//    @PrimaryKeyJoinColumn(name="date"),
//        @PrimaryKeyJoinColumn(name="time"),
//        @PrimaryKeyJoinColumn(name="nuid")
//})
//public class BookingDetails extends Booking{
//
//	@Transient
//	private String nuid;
//	
//	@Column(name="availability", columnDefinition="int default 0")
//	private int availability;
//
//	@Column(name="date")
//	private String date;
//	
//	@Column(name="time")
//	private String time;
//	
//	public int getAvailability() {
//		return availability;
//	}
//
//	public void setAvailability(int availability) {
//		this.availability = availability;
//	}
//
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		System.out.println("IN POJO " + date);
//		this.date = date;
//	}
//
//	public String getTime() {
//		return time;
//	}
//
//	public void setTime(String time) {
//		this.time = time;
//	}
//	
//	
//	
//}
