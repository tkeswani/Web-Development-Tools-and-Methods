<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<title>FORM</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" >

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
	
	<script type="text/javascript">
		function checkEmpty() {
			var nuid = document.getElementById("nuid").value;
			var phoneNum = document.getElementById("phoneNum").value;
			
			var password = document.getElementById("password").value;
			var cPassword = document.getElementById("cPassword").value;
			
			if(!nuid) {
				alert("NUID Can't Be Empty");
				
			}
			else if(!phoneNum) {
				alert("Phone Number Can't Be Empty");
				
			}
			
			if(password != cPassword) {
				alert("Password Does Not Match");
			}
			else {
				document.getElementById("submitForm").submit();
			}
			
			
		}
	</script>
	
</head>
<body>
	<div class="container">
		<div class="col-lg-3"></div>
		<div class="col-lg-6">		
			<form:form action="register.htm" id="submitForm" commandName="student" method="post" >
			<h3><b>PERSONAL INFORMATION.</b></h3>
			<div class="form-group">
				<label class="sr-only" for="name">YOUR NAME</label>
    			<form:input type="text" class="form-control" name="name" placeholder="YOUR NAME" path="name"/><font color="red"><form:errors path="name"/></font>
  			</div>
  			<div class="form-group">
    			<label class="sr-only" for="nuid">NUID</label>
    			<form:input type="number" id="nuid" class="form-control" name="nuid" placeholder="NUID" path="nuid" /><font color="red"><form:errors path="nuid"/></font>
  			</div>
  			<div class="form-group">
				<label class="sr-only" for="fname">EMAIL</label>
    			<form:input type="text" class="form-control" name="email" placeholder="EMAIL" path="email.emailId"/><font color="red"><form:errors path="email.emailId"/></font>
  			</div>
  			<div class="form-group">
    			<label class="sr-only" for="lname">PASSWORD</label>
    			<form:input type="password" id="cPassword" class="form-control" name="cPassword" placeholder="PASSWORD" path="password" /><font color="red"><form:errors path="password"/></font>
  			</div>
  			<div class="form-group">
    			<label class="sr-only" for="lname">CONFIRM PASSWORD</label>
    			<form:input type="password" id="password" class="form-control" name="password" placeholder="CONFIRM PASSWORD" path="cPassword" /><font color="red"><form:errors path="cPassword"/></font>
  			</div>
  			<div class="form-group">
    			<label class="sr-only" for="lname">PHONE NUMBER</label>
    			<form:input type="number" id="phoneNum" class="form-control" name="phoneNum" placeholder="PHONE NUMBER" path="phoneNum" /><font color="red"><form:errors path="phoneNum"/></font>
  			</div>
  			<br><br>
  			<button type="button" class="btn btn-danger btn-block" onclick="checkEmpty()">REGISTER</button>
			</form:form>
			<form:form action="mainpage.htm" commandName="student" method="post">
					<button type="submit" class="btn btn-danger btn-block" >SIGN IN</button>
				</form:form>
						</div>
		<div class="col-lg-3"></div>	
		</div>
</body>
</html>