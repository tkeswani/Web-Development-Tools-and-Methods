package com.shuttle.myapp;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuttle.pojo.Student;

public class UserValidator implements Validator{

	public boolean supports(Class aClass)
    {
        return aClass.equals(Student.class);
    }

	
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Student student = (Student) obj;	
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.user", "Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nuid", "nuid.incorrect", "NUID Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailId", "error.invalid.email.emailId", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cPassword", "error.invalid.cPassword", "Confirm Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNum", "phoneNum.incorrect", "Phone Number Required");
        
	}
	
	public void validateLogin(Object obj, Errors errors) {
		
		Student student = (Student) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.username", "Username Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		
	}
	
	public void errorLogin(Object obj, Errors errors) {
		Student student = (Student) obj;
		if(student == null) {
			errors.rejectValue("username", "error.invalid.username","Invalid Username");
			errors.rejectValue("password", "error.invalid.password","Invalid Password");
			
		}
	}
	
	public void nuidExists(Object obj, Errors errors) {
		Student student = (Student) obj;
		
		errors.rejectValue("name", "error.invalid.name", "NUID already in database");
	}
}
