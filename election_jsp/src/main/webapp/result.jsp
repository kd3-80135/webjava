<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Election Result</title>
</head>
<body>
	Hello , ${lb.user.firstName} ${lb.user.lastName}<hr>
	
	<jsp:useBean id="rb" class="com.sunbeam.beans.ResultBean"/>
	${rb.fetchResult()}
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Party</th>
				<th>Votes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="v" items="${rb.list}">
				<tr>
					<td>${v.id}</td>
					<td>${v.name}</td>
					<td>${v.party}</td>
					<td>${v.votes}</td>
					<td>
						<a href="edit.jsp?id=${v.id}">Edit</a>
						<a href="delete.jsp?id=${v.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	${cdb.message}
	${param.ubMessage}
	<br/><br/>
	<a href="logout.jsp">Sign Out</a>
</body>
</html>