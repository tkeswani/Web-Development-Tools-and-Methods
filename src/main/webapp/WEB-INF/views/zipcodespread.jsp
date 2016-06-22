<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<div class="container">
	<table>
		<tr>
			<th>NUID</th>
			<th>NAME</th>
			<th>DATE</th>
			<th>TIME</th>
			<th>APARTMENT NUMBER</th>
			<th>STREET</th>
			<th>CITY</th>
			<th>STATE</th>
			<th>ZIPCODE</th>
		</tr>
		<c:forEach var="s" items="${sessionScope.zipcode}">
			<tr>
				<td>
					<input type="text" value="${s.student.nuid}" readonly>
				</td>
				<td>
					<input type="text" value="${s.student.name}" readonly>
				</td>
				<td>
					<input type="text" value="${s.date}" readonly>
				</td>
				<td>
					<input type="text" value="${s.time}" readonly>
				</td>
				<td>
					<input type="text" value="${s.aptNo}" readonly>
				</td>
				<td>
					<input type="text" value="${s.street}" readonly>
				</td>
				<td>
					<input type="text" value="${s.city}" readonly>
				</td>
				<td>
					<input type="text" value="${s.state}" readonly>
				</td>
				<td>
					<input type="text" value="${s.zipCode}" readonly>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>