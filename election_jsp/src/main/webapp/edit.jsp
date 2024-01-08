<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edition</title>
</head>
<body>
	<h2>Hello ${lb.user.firstName} ${lb.user.lastName}</h2>
	<h3>Edit Candidate</h3>
	<jsp:useBean id="eb" class="com.sunbeam.beans.FindCandidateBean"/>
	<jsp:setProperty property="candId" name="eb" param="id"/>
	${eb.fetchCandidate()}
	
	<form method="post" action="update.jsp">
		<input type="hidden" name="id" value="${eb.candidate.id}"/><br/><br/>
		Name : <input type ="text" name="name" value="${eb.candidate.name}"/><br/><br/>
		Party : <input type="text" name="party" value="${eb.candidate.party}"/><br/><br/>
		Votes : <input type="text" name="votes" value="${eb.candidate.votes}" readonly/><br/><br/>
		<input type="submit" value="Update Candidate"/>
	</form>
</body>
</html>