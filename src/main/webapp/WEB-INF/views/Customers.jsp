<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer App</title>
</head>
<body>
<h1 align="center" style="background-color: #00ff00">CUSTOMER RELATIONSHIP MANAGEMENT</h1>

	<br>
	<br>
	
	<table border="1"
		style="border: 1px solid black; border-collapse: collapse;">
		<tr>
			<td style="background-color: #D3D3D3"><a href="addOrUpdateRecord?customerId=0">Add a new Customer</a></td>
		</tr>
	</table>
	
	<br>
	<br>
	
	<table border="1"
		style="border: 1px solid black; border-collapse: collapse;">
		<thead>
			<tr style="background-color: #00ff00;">
				
				<th style="padding: 5px;">FirstName</th>
				<th style="padding: 5px;">LastName</th>
				<th style="padding: 5px;">Email</th>
				<th style="padding: 5px;">Action</th>
			</tr>
		</thead>

		<tbody>					
					<tr>
      					<td colspan="5" align="center">${error}</td>
      				 </tr>				
			
			       <c:forEach items="${customers}" var="s">
					<tr>					
					
						<td style="padding: 10px;">${s.firstName}</td>
						<td style="padding: 10px;">${s.lastName}</td>
						<td style="padding: 10px;">${s.email}</td>
						<td style="padding: 10px; text-align: center;">
							<a href="addOrUpdateRecord?customerId=${s.customerId}" style="text-decoration: none"> Update </a>
							<a onclick="return confirm('Are you sure you want to delete?');" href="deleteRecord?customerId=${s.customerId}" style="text-decoration: none">| Delete </a>
						</td>
					</tr>
					</c:forEach>	
		</tbody>
	</table>
	
</body>
</html>
