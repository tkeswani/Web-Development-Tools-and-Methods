<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
		<form:form  action="confirm.htm" commandName="booking" method="post">
			<h3><b>LOCATION INFORMATION.</b></h3>
  			<div class="form-group">
				<label class="sr-only" for="apartmentNo">Apartment Number</label>
    			<form:input type="number" class="form-control" name="aptNo" placeholder="Apartment Number" path="aptNo"></form:input><font color="red"><form:errors path="aptNo"/></font>
  			</div>
  			<div class="form-group">
    			<label class="sr-only" for="street">Street</label>
    			<form:input type="text" class="form-control" name="street" placeholder="Street" path="street"></form:input><font color="red"><form:errors path="street"/></font>
  			</div>
  			
  			<div class="form-group">
				<label class="sr-only" for="city">City</label>
    			<form:input type="text" class="form-control" name="city" placeholder="City" path="city"></form:input><font color="red"><form:errors path="city"/></font>
  			</div>
  			<div class="form-group">
    			<label class="sr-only" for="state">State</label>
    			<form:input type="text" class="form-control" name="state" placeholder="State" path="state"></form:input><font color="red"><form:errors path="state"/></font>
  			</div>
  			
  			<div class="form-group">
    			<label class="sr-only" for="zipCode">Zip Code</label>
    			<form:input type="number" class="form-control" name="zipCode" placeholder="Zip Code" path="zipCode"></form:input><font color="red"><form:errors path="zipCode"/></font>
  			</div>
  			<button type="submit" class="btn btn-lg" >SEARCH</button>
		</form:form>
		
	</div>
</body>
</html>