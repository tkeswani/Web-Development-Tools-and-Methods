package com.shuttle.myapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuttle.dao.BookingDAO;
import com.shuttle.dao.PersonDAO;
import com.shuttle.pojo.Booking;
import com.shuttle.pojo.Student;

@Controller
@RequestMapping("/")
public class RegisterController {

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/mainpage.htm", method = RequestMethod.POST)
    public String home(@ModelAttribute("student") Student student, BindingResult result) {
        System.out.println("login page");
        //return "securityLogin";
               return "home";
    }
	
	
	
	@RequestMapping(value="/registration.htm", method=RequestMethod.POST)
	public String doSignUpAction(@ModelAttribute("student") Student student, BindingResult result) {
		
		return "registration";
	}
	
	@RequestMapping(value= "/register.htm", method = RequestMethod.POST)
	public String doSubmitAction(@ModelAttribute("student") Student student, BindingResult result, HttpSession session,HttpServletRequest request) throws Exception {
		System.out.println("IN DO SUBMIT");
		validator.validate(student, result);
		if (result.hasErrors()) {
			return "registration";
		}

		try {
			System.out.print("test");
			PersonDAO personDao = new PersonDAO();
			System.out.print(student.getNuid());
			System.out.print(student.getEmail().getEmailId());
		
			String username = student.getEmail().getEmailId().split("[@]")[0];
			student.setUsername(username);
			
			
			
			
			if(personDao.checkNuid(student.getNuid()))
			{
			
			if(student.getcPassword().equals(student.getPassword())) {
				Student std = personDao.create(student.getName(), student.getNuid(), student.getPassword(), "Student", student.getUsername(), student.getPhoneNum(), student.getEmail().getEmailId());	
				
			}
			
			}
			else {
				validator.nuidExists(student, result);
				if (result.hasErrors()) {
					System.out.println("NUID EXISTS");
					return "registration";
				}
			}
			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "home";
	}
	
	@RequestMapping(value= "/login.htm", method = RequestMethod.POST)
	public String doLoginAction(HttpServletRequest request, @ModelAttribute("student") Student student, BindingResult result, HttpSession session) throws Exception {
		System.out.println("IN DO SUBMIT");
		validator.validateLogin(student, result);
		if (result.hasErrors()) {
			return "home";
		}

		try {
			System.out.println("trying to login");
			PersonDAO personDao = new PersonDAO();
		
			System.out.println("USERNAME" + student.getUsername());
			System.out.println("PASSWORD" + student.getPassword());
			
			Student stu = personDao.get(student.getUsername(), student.getPassword());
			
			if(stu == null) {
				System.out.println("NULL");
				validator.errorLogin(stu, result);
				if(result.hasErrors()) {
					return "home";
				}
			}
			
			System.out.println("NAME" + stu.getUsername());
			
			
			
			if(stu.getRole().equalsIgnoreCase("admin")) {
				return "adminmenu";
			}
			
			else {
			session = request.getSession(false);
			
			// Checking for already registered shuttle
			BookingDAO bookShuttle = new BookingDAO();
			
			List<Booking> checkBooking;
			checkBooking = bookShuttle.checkBooking(stu.getNuid());
			
			for(Booking b : checkBooking) {
				System.out.println("CHECKING THE LIST");
				Date dNow = new Date( );
				SimpleDateFormat ft1 = new SimpleDateFormat ("MM/dd/yyyy");
				String date = ft1.format(dNow);
				
				SimpleDateFormat ft = new SimpleDateFormat ("HH:mm");
				Calendar cal = Calendar.getInstance();
				String time = ft.format(cal.getTime());
//				Date time = ft.parse(ft.format(cal.getTime()));
				System.out.println("TIIIIMMMMHHH " + time);
				System.out.println("BOOKING DATE & TIME " + b.getDate() + b.getTime());

				System.out.println("DIFFERENCE " + b.getTime().compareTo(time));
				if(b.getDate().equals(date) && (b.getTime().compareTo(time))>0) {
					
					session.setAttribute("bookedTime", b.getTime());
					System.out.println("CANNOT MAKE BOOKING");
					return "alreadyBooked";
				}
			}
			
			session.setAttribute("stu", stu);
			session.setAttribute("username", stu.getUsername());
			session.setAttribute("nuid", stu.getNuid());
			System.out.println("NUID" + session.getAttribute("nuid"));
			System.out.println("OBJECT NUID" + stu.getNuid());	
			
			}
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		return "schedule";
	}
	
	@RequestMapping(value="/admin/login.htm", method=RequestMethod.GET)
	public String doAdminAction() {
		
		return "adminmenu";
	}
	
	
	@RequestMapping(value="/logout.htm", method=RequestMethod.POST)
	public String doLogoutAction(HttpSession session,@ModelAttribute("student") Student student, BindingResult result) {
		
		session.invalidate();
		
		return "home";
	}
}
