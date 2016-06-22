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
  
  function checkValidDate() {
	  var date = document.getElementById("datepicker").value;
	  var todayDate = document.getElementById("todayDate").value;
			
	  if(!date) {
		  alert("Please Select A Date!!!");
	  }
		
	  else if(date > todayDate) {
		  alert ("Enter A Valid Date");
	  }
	  else {
		  document.getElementById("date").submit();
	  }
  }
 
  </script>
</head>
<body>
	 <% 		Date dNow = new Date( );
		SimpleDateFormat ft1 = new SimpleDateFormat ("MM/dd/yyyy");
		
		String todayDate = ft1.format(dNow); %>
		<input type="hidden" id="todayDate" value= <%=todayDate %> >
	<form method="post" action="extractstudent.htm" id="date">
		<p>Date: <input type="text" id="datepicker" name="date"><button type="button" class="btn btn-primary" onclick="checkValidDate()">SUBMIT</button></p> 
		
	</form>
</body>
</html>