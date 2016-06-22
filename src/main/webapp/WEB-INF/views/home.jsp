<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>FORM</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" >

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
		 
</head>

<body >
	<div class="container">
		<div class="col-lg-3"></div>
		<div class="col-lg-6">
		<br><br><br>
			
			<form:form method="post" action="login.htm" commandName="student">
			<header><h3><b>Join Northeastern University Shuttle Today.</b></h3></header>
			<div class="form-group">
				<form:input type="text" class="form-control" name="username" placeholder="Username" path="username"></form:input><font color="red"><form:errors path="username"/></font>
			</div>
			<div class="form-group">
				<form:input type="password" class="form-control" name="password" placeholder="Password" path="password"></form:input><font color="red"><form:errors path="password"/></font>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-danger btn-block">SIGN IN</button>
			</form:form>	<br>
				<div class="form-group">
				<form action="registration.htm" method="post">
					<button type="submit" class="btn btn-danger btn-block">SIGN UP</button>
				</form>
				</div>
			</div>
			<p><b>By signing up, you agree to the Terms of Service and Privacy Policy, including Cookie Use. Others will be able to find you by email or phone number when provided.</b></p>
		
		</div>
		<div class="col-lg-3">
				
		</div>
	</div>
</body>
</html>