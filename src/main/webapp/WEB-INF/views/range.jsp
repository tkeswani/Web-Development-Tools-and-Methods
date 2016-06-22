<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
 <link rel="stylesheet" href="/resources/demos/style.css">
<script>
 $(function() {
   $( "#datepicker" ).datepicker();
 });
 $(function() {
	   $( "#datepicker1" ).datepicker();
	 });
 
 function checkValidDate() {
	  var date1 = document.getElementById("datepicker").value;
	  var date2 = document.getElementById("datepicker1").value;
	  var todayDate = document.getElementById("todayDate").value;
	  
	  if(!date1) {
		  alert("Please Select A Date!!!");
	  }
	  else if(!date2) {
		  alert("Please Select A Date!!!");
	  }		
	  else if(date1 > date2) {
		  alert ("Start Date Should Be Before End Date");
	  }
	  else if(date1 > todayDate) {
		  alert("Enter A Valid Start Date")
	  }
	  else if(date2 > todayDate) {
		  alert("Enter A Valid End Date")
	  }
	  else {
		  document.getElementById("formSubmit").submit();
	  }
 }
 
 </script>
</head>
<body>
<% 		Date dNow = new Date( );
		SimpleDateFormat ft1 = new SimpleDateFormat ("MM/dd/yyyy");
		
		String todayDate = ft1.format(dNow); %>
		<input type="hidden" id="todayDate" value= <%=todayDate %> >
	<form method="post" action="rangestudents.htm" id="formSubmit">
	<table>
	<tr>
		<td>
		<p>Start: <input type="text" id="datepicker" name="date1"></p> 
		</td>
		<td>
		<p>End: <input type="text" id="datepicker1" name="date2"></p>
		</td>
		<td>
		<button type="button" class="btn btn-primary" onclick="checkValidDate()">SUBMIT</button>
		</td>
	</tr>
	</table>
	</form>
</body>
</html>