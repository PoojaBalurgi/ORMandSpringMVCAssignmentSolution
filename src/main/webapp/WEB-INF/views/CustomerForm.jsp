<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
</head>
<body>


	<h1 align="center" style="background-color: #00ff00; font-weight: bold">CUSTOMER RELATIONSHIP MANAGEMENT</h1>
	
	<br>
	<br>
	
	<h3 style="font-weight:bold">Save Customer</h3>
	
	<br>
	
<form action="save" method="post">	
	<table>
	
		<tr></tr>
		
		<tr><td>First Name : </td><td><input type="text" value="${customer.firstName}" name="fName"/></td></tr> 
		<tr></tr> <tr></tr>
		<tr><td>Last Name : </td><td><input type="text" value="${customer.lastName}" name="lName"/></td></tr>
		<tr></tr> <tr></tr>
		<tr><td>Email : </td><td><input type="text" value="${customer.email}" name="email"/></td></tr>
		<tr></tr> <tr></tr>
		<tr><td colspan="2"><input type="hidden" value='${customer.customerId}' name="id"/><input type="submit" value="Save"/></td></tr>
		<tr></tr> <tr></tr>
		
	</table>
</form>

<br>
<br>

<a href="list">Back to List</a>

</body>
</html>