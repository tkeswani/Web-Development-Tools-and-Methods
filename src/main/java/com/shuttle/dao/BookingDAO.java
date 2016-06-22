package com.shuttle.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;

import com.shuttle.exception.ADException;
import com.shuttle.pojo.Booking;
import com.shuttle.pojo.Student;


public class BookingDAO extends DAO{

	public BookingDAO() {
	}
	
	public void create(String aptNo, String street, String city, String state, String zipCode, String date, String time, Student s) throws ADException {
		
		begin();
		System.out.println("APT NO is " + aptNo);
		System.out.println("Zip Code is  " + zipCode);
		Booking booking = new Booking();
		booking.setAptNo(aptNo);
		booking.setStreet(street);
		booking.setCity(city);
		booking.setState(state);
		booking.setZipCode(zipCode);
		System.out.println("BOOKIINGDAO" + zipCode);
		booking.setStudent(s);
		booking.setDate(date);
		booking.setTime(time);
		//booking.setNuid(nuid);
		
		Query q = getSession().createQuery("from Booking where date=:date and time=:time");
		q.setString("date", date);
		q.setString("time", time);
		
		//Booking bd = (BookingDetails) q.uniqueResult();
		
		List<Booking> reserve = q.list();
		
		if(reserve.size() == 0) {
			getSession().save(booking);
			commit();
		}
		else {
			Query qr = getSession().createQuery("select count(*) from Booking where date=:date and time=:time");
			qr.setString("date", date);
			qr.setString("time", time);
			
			long avail = (Long) qr.uniqueResult();
			System.out.println("AVAILABILITY = " + avail);
			
			if(avail < 2) {
				getSession().save(booking);
				commit();
			}
		}
		
	}
	
	public long displayAvailability(String date, String time) {
		begin();
		Query q = getSession().createQuery("select count(*) from Booking where date=:date and time=:time");
		q.setString("date", date);
		q.setString("time", time);
		
		long avail = (Long)q.uniqueResult();
		
		return avail;
		
	}
	
	public List<Booking> checkBooking(int nuid) {
		begin();
		Query q = getSession().createQuery(" from Booking where student_Nuid=:studentId");
		q.setInteger("studentId", nuid);
				
		List<Booking> check = q.list();
		
		return check;
		
	}
}
