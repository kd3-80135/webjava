<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="movies" uri="/WEB-INF/movie.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review List</title>
</head>
<body>
	<jsp:useBean id="rvb" class="com.sunbeam.beans.ReviewBean"></jsp:useBean>
	<br><br>
	<h3>Hello, ${lb.user.firstName} ${lb.user.lastName} </h3>
	<br><br><br>
		<table border="1">
			<thead>
				<tr>
					<th>Review-Id</th>
					<th>Movie</th>
					<th>Rating</th>
					<th>Review</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				${rvb.getReviews()}
				<c:forEach var="r" items="${rvb.list}">
					<tr>
						<td>${r.id}</td>
						<td><movies:movie_title movieId="${r.movieId}"/></td>
						<td>${r.rating}</td>
						<td>${r.review}</td>
						<td>
							<a href="ctl?page=editreview"><img alt="Edit" src="edit.png" height="20px" width="20px"/></a>
							<a href="ctl?page=deletereview"><img alt="Edit" src="delete.png" height="20px" width="20px"/></a>
							<a href="ctl?page=sharereview"><img alt="Share" src="share.png" height="20px" width="20px"/></a>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
		
		
</body>
</html>