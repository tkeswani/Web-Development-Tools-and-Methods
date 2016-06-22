package com.shuttle.myapp;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuttle.dao.BookingDAO;
import com.shuttle.message.Email;
import com.shuttle.message.Message;
import com.shuttle.pojo.Booking;
import com.shuttle.pojo.Student;

@Controller
@RequestMapping("/")
public class BookingController {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("emailConfig.xml");
	Email e=(Email)context.getBean("emailBean");
	
	@Autowired
	@Qualifier("addressValidator")
	AddressValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value= "/destination.htm", method = RequestMethod.POST)
	public String doSubmitAction(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("booking") Booking booking, BindingResult result, HttpSession session) throws Exception {
		System.out.println("DATE IN Destination func " + booking.getDate());
		System.out.println("DATETETETE " + booking.getTime());
		
		session = request.getSession(false);
		BookingDAO schedule = new BookingDAO();
		
		String date = request.getParameter("date");
		System.out.println("date by request" + date);
		String time = request.getParameter("time");
		System.out.println("time by request " + time);
		long avail = schedule.displayAvailability(date, time);
		session.setAttribute("avail", avail);
	
		
		if(avail < 2) {
			System.out.println("LETS AVAIL" + avail);
			
			PrintWriter out1 = response.getWriter();
			JSONObject json1 = new JSONObject();
			json1.put("avail", avail);
			out1.println(json1);
			
			session.setAttribute("date", booking.getDate());
			session.setAttribute("time", booking.getTime());
			
			return null;
//			response.setContentType("application/json");
//			response.getWriter().write(json.toString());
			//return "avail";
		}
		else {
			PrintWriter out1 = response.getWriter();
			JSONObject json1 = new JSONObject();
			json1.put("avail", "9");
			out1.println(json1);
			return null;
		}
		
		//System.out.println(session.getAttribute("username"));
		
		
		
		//return null;
	}
	
	@RequestMapping(value= "/confirm.htm", method = RequestMethod.POST)
	public String doDestinationAction(@ModelAttribute("booking") Booking booking, BindingResult result, HttpServletRequest request, HttpSession session) throws Exception {
		
		validator.validate(booking, result);
		if (result.hasErrors()) {
			return "destination";
		}
		
		session = request.getSession(false);
		System.out.println(session.getAttribute("username"));
		System.out.println("APT NO" + booking.getAptNo());
		
		session.setAttribute("aptNo", booking.getAptNo());
		session.setAttribute("street", booking.getStreet());
		session.setAttribute("city", booking.getCity());
		session.setAttribute("state", booking.getState());
		session.setAttribute("zipcode", booking.getZipCode());
		System.out.println("ZIPPPIE CODE " + booking.getZipCode());
		
		return "confirmation";
	}
	
	@RequestMapping(value= "/success.htm", method = RequestMethod.POST)
	public String doSuccessAction(HttpServletRequest request, @ModelAttribute("entry") Booking booking, BindingResult result, HttpSession session) throws Exception {
		System.out.println("DATETETETE " + booking.getDate());
		System.out.println("DATETETETE " + booking.getTime());
		
		BookingDAO bookingDAO = new BookingDAO();
		Student s = (Student) session.getAttribute("stu");
		int nuid = (Integer) session.getAttribute("nuid");
		System.out.println("NUID INSIDE SUCCESS IS " + nuid);
		bookingDAO.create(booking.getAptNo(),booking.getStreet(),booking.getCity(),booking.getState(),booking.getZipCode(), booking.getDate(), booking.getTime(),s);
		
		Message email = new Message();
		
		email.setReceiverEmailAddress("keswani.tarun@gmail.com");
		email.setMessageBody("Your Shuttle has been booked for " + booking.getTime());
		email.setSubject("Shuttle Booked Notification");
		
		e.sendEmail(email);
		session.invalidate();
		
		return "success";
	}
	
	@RequestMapping(value= "/check.htm", method = RequestMethod.POST)
	public String doCheckAction(HttpServletRequest request, @ModelAttribute("schedule") Booking booking, BindingResult result, HttpSession session) throws Exception {
		
		System.out.println("Through AJAX");
		System.out.println("DATE IN AJAX" + booking.getDate());
		System.out.println("TIME IN AJAX" + booking.getTime());
		BookingDAO bookingDAO = new BookingDAO();
		String date = booking.getDate();
		String time = booking.getTime();
		long avail = bookingDAO.displayAvailability(date, time);
		
		System.out.println("AVAILALE SEATS" + avail);
		
		return "avail";
	}
	
	@RequestMapping(value= "/next.htm", method = RequestMethod.POST)
	public String doNext(@ModelAttribute("booking") Booking booking) {
		return "destination";
	}
}
