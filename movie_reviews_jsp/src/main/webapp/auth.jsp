<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentication</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

	<jsp:useBean id ="lb" class ="com.sunbeam.beans.LoginBean" scope = "session"/>
	<jsp:setProperty name ="lb" property="email" param="email"/>
	<jsp:setProperty name = "lb" property="password" param="password"/>
	
	${lb.authenticate()}
	<div class="container" align="center">
	<c:choose>
		<c:when test="${empty lb.user}">
			Invalid user or Password. <br><br>
			<a href="ctl?page=index">Login Again</a>
		</c:when>
	</c:choose>
	
	<c:choose>
			<c:when test="${not empty lb.user}"><br><br>
			<c:redirect url="ctl?page=reviews"/>
		</c:when>
	</c:choose>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>