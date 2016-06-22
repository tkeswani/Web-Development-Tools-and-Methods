package com.shuttle.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.shuttle.dao.DAO;
import com.shuttle.exception.ADException;
import com.shuttle.pojo.Email;
import com.shuttle.pojo.Person;
import com.shuttle.pojo.Student;

public class PersonDAO extends DAO{

	public PersonDAO() {
		
	}

    public Student get(String users, String password)
            throws ADException {	
        try {
            begin();
          System.out.println("hello");
            Query q = getSession().createQuery("from Student where username = :user and password=:password");
            q.setString("user", users);
            q.setString("password", password);
            
            System.out.println(users);
            Student std = (Student) q.uniqueResult();
            if(std == null) {
            	System.out.println("HEELLO");
            	return null;
            }
            //System.out.println(std.getUsername());
            commit();
            return std;
        } catch (HibernateException e) {
            rollback();
            e.printStackTrace();
            throw new ADException("Could not get user " + users, e);
        }
    }
	
	public Student create(String name, int nuid, String password, String role, String username, long phoneNum, String emailId)
            throws ADException {
		System.out.println("In CREATE");
        try {
            begin();
            System.out.println("inside DAO");

            Student student = new Student(username,password);
            
            Email email = new Email(emailId);
            
            student.setName(name);
            student.setEmail(email);
            student.setNuid(nuid);
            //student.setPassword(password);
            student.setPhoneNum(phoneNum);
            student.setRole(role);
            email.setStudent(student);
            getSession().save(student);
            
            commit();
            return student;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new ADException("Exception while creating user: " + e.getMessage());
        }
    }
	
	public boolean checkNuid(int nuid) {
		
		Query q = getSession().createQuery("from Person where nuid=:nuid");
		q.setInteger("nuid", nuid);
		
		Person p = (Person) q.uniqueResult();
		if(p==null) {
			return true;
		}
		else{
			return false;
		}
		
		
	}
}

