<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% session.invalidate(); %>
	<h1>Thank You For Voting.</h1>
	<a href="index.jsp">Login Again</a>
</body>
</html>