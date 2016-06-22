<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FORM</title>
	<!-- Latest compiled and minified CSS -->
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" >

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
	
</head>
<body>

	<div class="container">
	<form action="logout.htm" method="post">
	<table class="table">
		<tr>
			<td>
				<b>LOGGED IN : ${username} </b>
			</td>
			<td>
				<b>STUDENT ID : ${nuid} </b>
			</td>
			<td>
				<button class="btn btn-danger btn-block">LOGOUT</button>
			</td>
		</tr>
	</table>
	</form>
	<form method="post" action="success.htm" commandName="entry">
	<input type="hidden" name="date" value=<%= session.getAttribute("date") %> />
	<input type="hidden" name="time" value=<%= session.getAttribute("time") %> />
	<input type="hidden" name="aptNo" value=<%= session.getAttribute("aptNo") %> />
	<input type="hidden" name="street" value=<%= session.getAttribute("street") %> />
	<input type="hidden" name="city" value=<%= session.getAttribute("city") %> />
	<input type="hidden" name="state" value=<%= session.getAttribute("state") %> />
	<input type="hidden" name="zipCode" value=<%= session.getAttribute("zipcode") %> />
   <table border="1" cellpadding="5" cellspacing="5" class="table">
	<tr bgcolor="#2196F3 ">
   <td><b>NUID</b></td>
   <td><b>DATE</b></td>
   <td><b>Title</b></td>
   
   </tr>
   <tr>
   <td><%= session.getAttribute("nuid") %></td>
   <td><%= session.getAttribute("date") %></td>
   <td><%= session.getAttribute("time") %></td>
   
   </tr>
   </table>
   
   <table border="1" cellpadding="5" cellspacing="5" class="table">
	<tr bgcolor="#2196F3 ">
   <td><b>APARTMENT NO</b></td>
   <td><b>STREET</b></td>
   <td><b>CITY</b></td>
   <td><b>STATE</b></td>
   <td><b>ZIP CODE</b></td>
   </tr>
   <tr>
   <td><%= session.getAttribute("aptNo") %></td>
   <td><%= session.getAttribute("street") %></td>
   <td><%= session.getAttribute("city") %></td>
   <td><%= session.getAttribute("state") %></td>
   <td><%= session.getAttribute("zipcode") %></td>
   </tr>
   </table>
   <div align="right">
   <button class="btn btn-danger btn-block">CONFIRM</button>
   </div>
   </form>
   
   <div>
   	<br>
  		<iframe src="https://www.google.com/maps/embed/v1/place?key=AIzaSyC1BM9XgNpu9mJtf12HozsksTB54-nooYE&q=Northeastern+University" width="1000" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
   </div>
   <!--  <div id="collapseBoston" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingBoston">
     <div class="panel-body">
       <div class="googlemap">
<iframe src="http://maps.google.com/maps?saddr=\"Northeastern University\"&daddr=\"40 Parker Hill Avenue\" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
       </div>
     </div>
   </div> 
	</div> -->
   </div>
</body>
</html>