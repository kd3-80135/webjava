<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentication</title>
</head>
<body>
	
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope= "session"/>
	<jsp:setProperty name="lb" property="*"/>
	
	${lb.auth()}
	<c:choose>
		<c:when test="${empty lb.user}">
		Invalid user or password.
		<a href="index.jsp">Login Again</a>
		</c:when>
		
		<c:when test="${lb.user.role=='admin'}">
		<c:redirect url="result.jsp" />
		</c:when>
		
		<c:when test="${lb.user.role =='voter'}">
		<c:redirect url="candlist.jsp" />
		</c:when>
		<c:otherwise><h2>Some Error Occurred</h2> <c:redirect url="index.jsp"/></c:otherwise>	
	</c:choose>
</body>
</html>