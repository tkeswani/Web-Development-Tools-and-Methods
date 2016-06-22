package com.shuttle.myapp;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shuttle.pojo.Booking;

public class AddressValidator implements Validator{

	
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(Booking.class);
	}

	
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		
		Booking booking = (Booking) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aptNo", "error.invalid.aptNo", "Apartment Number Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "error.invalid.street", "Street Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.city", "City Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "error.invalid.state", "State Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "error.invalid.zipCode", "Zipcode Required");
        
	}

	
}
