package com.shuttle.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.shuttle.exception.ADException;
import com.shuttle.pojo.Admin;
import com.shuttle.pojo.Booking;
import com.shuttle.pojo.Email;
import com.shuttle.pojo.Student;

public class AdminDAO extends DAO{

	public AdminDAO() {
		
	}
	
	public int getLocation() {
		Criteria c = getSession().createCriteria(Booking.class);
		ProjectionList projectList = Projections.projectionList();
		projectList.add(Projections.groupProperty("zipCode"));
		c.setProjection(projectList);
		c.addOrder(Order.desc("zipCode"));
		c.setMaxResults(1);
		int obj = (Integer) c.uniqueResult();
		//List<Object[]> results = c.list();
		
		return obj;
				
	}
	
	public List<Booking> getStudents(String date) {
		
		Query q = getSession().createQuery("from Booking where date=:date");
		q.setString("date", date);
		List<Booking> dates = q.list();
		System.out.println("NUMBER OF DATES " + dates.size());
		return dates;
	}
	
	public List<Booking> getStudentWithinRange(String date1, String date2) {
		
		Criteria c = getSession().createCriteria(Booking.class).add(Restrictions.between("date", date1, date2));
		
		List<Booking> results = c.list();
		
		return results;
		
	}
	
	public List<Booking> getZipcodeSpread() {
		Query q = getSession().createQuery("from Booking");
				
		List<Booking> results = q.list();
		
		return results;
	}
}
