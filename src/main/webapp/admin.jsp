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
		<div class="col-lg-7">		
			<form:form action="adminregister.htm" method="post" commandName="admin" >
			<header><h3><b>PERSONAL INFORMATION.</b></h3></header>
			<div class="form-group">
				<label class="sr-only" for="name">YOUR NAME</label>
    			<input type="text" class="form-control" name="name" placeholder="YOUR NAME" path="name"/>
  			</div>
  			<div class="form-group">
    			<label class="sr-only" for="nuid">NUID</label>
    			<input type="number" class="form-control" name="nuid" placeholder="NUID" path="nuid" />
  			</div>
  			<div class="form-group">
				<label class="sr-only" for="fname">EMAIL</label>
    			<input type="text" class="form-control" name="email" placeholder="EMAIL" />
  			</div>
  			<div class="form-group">
    			<label class="sr-only" for="lname">PASSWORD</label>
    			<input type="password" class="form-control" name="Password" placeholder="PASSWORD" path="cPassword" />
  			</div>
  			<div class="form-group">
    			<label class="sr-only" for="lname">CONFIRM PASSWORD</label>
    			<input type="password" class="form-control" name="cPassword" placeholder="CONFIRM PASSWORD" path="password" />
  			</div>
  			<div class="form-group">
    			<label class="sr-only" for="lname">PHONE NUMBER</label>
    			<input type="number" class="form-control" name="phoneNum" placeholder="PHONE NUMBER" path="phoneNum" />
  			</div>
  			<br><br>
  			<button type="submit" class="btn btn-danger btn-block">REGISTER</button>
			</form:form>
			
		</div>
		<div class="col-lg-5">
			<form:form method="post" action="adminlogin.htm" commandName="admin">
			<header><h3><b>Join Northeastern University Shuttle Today.</b></h3></header>
			<div class="form-group">
				<input type="text" class="form-control" name="username" placeholder="Username"></input>
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="password" placeholder="Password"></input>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">SIGN IN</button>
				
			</div>
			<p><b>By signing up, you agree to the Terms of Service and Privacy Policy, including Cookie Use. Others will be able to find you by email or phone number when provided.</b></p>
		</form:form>
		</div>
	</div>
</body>
</html>