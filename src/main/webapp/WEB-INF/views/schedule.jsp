<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
	<script type="text/javascript">
	
		var xmlHttp;
		xmlHttp = GetXmlHttpObject();
		
		function selectedRow(id) {
		
			if (xmlHttp == null)
	        {
	            alert("Your browser does not support AJAX!");
	            
	        }
	    
			<% 
			SimpleDateFormat ft2 = new SimpleDateFormat ("HH:mm");
			Calendar cale = Calendar.getInstance(); 
			cale.add(Calendar.HOUR, 1);
			System.out.println("AFTER 1 Hour" + cale.getTime());
			int minutes = cale.get(Calendar.MINUTE);
			System.out.println("MINUTE" + minutes);
			if(minutes<=20) {
				minutes = (20-minutes);
			}
			else if(minutes<=40) {
				minutes = (40-minutes);
				System.out.println(minutes);
			}
			else {
				minutes = (60-minutes);
			}
			//System.out.println(minute);
			cale.add(Calendar.MINUTE, minutes);
			%>
			
			if(id === 1) {
				
				var name = document.getElementById("1");
				name.setAttribute("name","time");
				document.getElementById("1").value = <%="\"" + ft2.format(cale.getTime()) + "\";"%>
			}
			
			else if(id === 2) {
				<% cale.add(Calendar.MINUTE, 20); %>
				var name = document.getElementById("2");
				name.setAttribute("name","time");
				document.getElementById("2").value = <%="\"" + ft2.format(cale.getTime()) + "\";"%>
			}
			
			else if(id === 3) {
				<% cale.add(Calendar.MINUTE, 20); %>
				var name = document.getElementById("3");
				name.setAttribute("name","time");
				document.getElementById("3").value = <%="\"" + ft2.format(cale.getTime()) + "\";"%>
			}
		
			 var date = document.getElementById("date").value;
			  alert(date);
			  var time = document.getElementById(id).value;
			  alert(time);
			  
			  var query = "date="+date+"&time="+time;
			  xmlHttp.open("POST", "destination.htm", true);
			  xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			  xmlHttp.send(query);
			
			 xmlHttp.onreadystatechange = function stateChanged() {
				    
				 if (xmlHttp.readyState == 4) {
					 alert("In Ready State");
					 
					 //alert(xmlHttp.responseText);
					 var x = xmlHttp.responseText;
					 var j = JSON.parse(x);
					// alert(j.avail);
					 //var json = JSON.parse(xmlHttp.responseText);
	                    //document.getElementById("success").innerHTML = json.successmsg;
					 //var json = JSON.parse(xmlHttp.responseText);
					 //alert(json.avail);
				    //document.getElementById("vacant").value=j.avail;
					 alert(j.avail);
					 
					 if(j.avail == 9) {
				      alert("SEATS NOT VACANT");
				      
				 }
					 else {
						 document.getElementById("submit").disabled=false;  	
			            } 
				 }
				  };
		
		}
		
		function GetXmlHttpObject()
        {
            var xmlHttp = null;
            try
            {
                // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e)
            {
                // Internet Explorer
                try
                {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e)
                {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return xmlHttp;
        }
		
		function load()
	    {
	        document.getElementById("submit").disabled=true;
	    }
	</script>
</head>

<body onload="load()">
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
	
	<form id="showSubmit" method="post" action="next.htm" commandName="booking">
	<% 		Date dNow = new Date( );
			SimpleDateFormat ft1 = new SimpleDateFormat ("MM/dd/yyyy");
			
			String date = ft1.format(dNow);
			//out.print(date);
			SimpleDateFormat ft = new SimpleDateFormat ("HH:mm");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.HOUR, 1);
			System.out.println("AFTER 1 Hour" + cal.getTime());
			int minute = cal.get(Calendar.MINUTE);
			System.out.println("MINUTE" + minute);
			if(minute<=20) {
				minute = (20-minute);
			}
			else if(minute<=40) {
				minute = (40-minute);
				System.out.println(minute);
			}
			else {
				minute = (60-minute);
			}
			//System.out.println(minute);
			cal.add(Calendar.MINUTE, minute);
				//	out.print( "<h2 align=\"center\">" +ft.format(cal.getTime())+"</h2>");
		%> 
		<table class="table table-hover" border="1">
			<tr>
				<th>
					SNO
					<input type="hidden" id="availability" value=<%= session.getAttribute("avail") %>>
					<input type="hidden" id="date" name="date" value= <%= ft1.format(dNow) %>></input>
					<input type="hidden" id="vacant" value=""/>
				</th>
				<th>
					TIME
				</th>
				<th>
					AVAILABILITY
				</th>
			</tr>
			<tr>
				
				<td>
					1.
				</td>

				<td>
					<input type="text" id="1" name="" value= <%= ft.format(cal.getTime()) %> readonly ></input>
				</td>
				<td>
					<input type="button" onclick="selectedRow(1)" value="CHECK AVAILABILITY"/>
				</td>
			</tr>
			<tr>
				
				<td>
					2.
				</td>

				<td>
					<% cal.add(Calendar.MINUTE, 20); %>
					<input type="text" id="2" name="" value= <%= ft.format(cal.getTime()) %> readonly></input>
				</td>
				<td>
					<input type="button" onclick="selectedRow(2)" value="CHECK AVAILABILITY"/>
				</td>
			</tr>
			<tr>
				
				<td>
					3.
				</td>

				<td>
					<% cal.add(Calendar.MINUTE, 20); %>
					<input type="text" id="3" name="" value= <%= ft.format(cal.getTime()) %> readonly></input>
				</td>
				<td>
					<input type="button" onclick="selectedRow(3)" value="CHECK AVAILABILITY"/>
				</td>
			</tr>
		</table>
		<div>
			<button type="submit" id="submit" class="btn btn-primary"  >NEXT</button>
		</div>
	</form>
	
	</div>
</body>