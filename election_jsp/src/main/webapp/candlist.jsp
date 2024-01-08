<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting</title>
</head>
<body>
	<jsp:useBean id="cdb" class="com.sunbeam.beans.CandidateListBean"/>
	<h2>Hello, ${lb.user.firstName} ${lb.user.lastName}</h2>
	${cdb.CandidateList()}	
	<form method="post" action="vote.jsp">
	<table>
		<thead>
			<tr>
				<th>Vote</th>
				<th>Candidate</th>
				<th>Party</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="li" items="${cdb.list}">
					<tr>
						<td><input type="radio" name="candidate" value="${li.id}"/></td>
						<td>${li.name}</td>
						<td>${li.party}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	<input type="submit" value="Vote"/>
	</form>
</body>
</html>