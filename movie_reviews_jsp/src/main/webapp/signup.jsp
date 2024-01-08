<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<jsp:useBean id ="rb" class="com.sunbeam.beans.RegisterationBean" />
	<jsp:setProperty name ="rb" property = "*"/>
	
	${rb.addUser()}
	<c:choose>
		<c:when test="${rb.status == true}">
		<h2>SignUp Successful. Please Login Again.</h2>
		<a href="ctl?page=index"> Login</a>
		</c:when>
		
		<c:when test="${rb.status == false}">
		<h2>SignUp Failed. Please try Again.</h2>
		<a href="ctl?page=index"> Login</a>
		</c:when>
	</c:choose>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>