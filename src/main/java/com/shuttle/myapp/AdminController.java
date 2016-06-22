package com.shuttle.myapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shuttle.dao.AdminDAO;
import com.shuttle.dao.PersonDAO;
import com.shuttle.pojo.Admin;
import com.shuttle.pojo.Booking;
import com.shuttle.pojo.Student;

@Controller
@RequestMapping("/")
public class AdminController {

	@RequestMapping(value="/admin/toplocation.htm")
	public String getTopLocation(HttpSession session) {
		
		AdminDAO admindao = new AdminDAO();
		
		int o = admindao.getLocation();
		
		session.setAttribute("topLocation", o);
		return "toplocation";
		
	}
	
	@RequestMapping(value="/admin/viewstudents.htm")
	public String getStudents(HttpSession session, HttpServletRequest request) {
		

//		
//		AdminDAO admindao = new AdminDAO();
//		
//		int o = admindao.getLocation();
//		
//		session.setAttribute("topLocation", o);
		return "viewstudents";
		
	}
	
	@RequestMapping(value="/admin/extractstudent.htm")
	public String extractStudents(HttpServletRequest request, HttpSession session) {
		String date = request.getParameter("date");
		
		System.out.println("IN EXTRACT " + date);
		AdminDAO admindao = new AdminDAO();
		List<Booking> dates = admindao.getStudents(date);
		for (Booking b:dates) {
			System.out.println("BOOKING IN ADMIN " + b.getAptNo());
		}
		session.setAttribute("date", dates);
		
		return "extractstudent";
	}
	
	@RequestMapping(value="/admin/range.htm")
	public String getRangeStudent() {
		return "range";
	}
	
	@RequestMapping(value="/admin/rangestudents.htm")
	public String getRangeOfStudent(HttpServletRequest request, HttpSession session) {
		
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		AdminDAO admindao = new AdminDAO();
		List<Booking> entries = admindao.getStudentWithinRange(date1, date2);
		session.setAttribute("entries", entries);
		
		return "rangestudents";
		
	}
	
	@RequestMapping(value="/admin/zipcodespread.htm")
	public String getRangeOfStudent(HttpSession session) {
		
		
		AdminDAO admindao = new AdminDAO();
		List<Booking> results = admindao.getZipcodeSpread();
		session.setAttribute("zipcode", results);
		
		return "zipcodespread";
		
	}
	
//	@RequestMapping(value="/admin/adminlogout.htm" ,method = RequestMethod.POST)
//	public String adminLogout(@ModelAttribute("student") Student student, BindingResult result) {
//		return "home";
//	}
	
	@RequestMapping(value = "/admin/adminlogout.htm")
    public ModelAndView adminLogout(HttpServletRequest req)    {
        return new ModelAndView("redirect:/");
    }
}
