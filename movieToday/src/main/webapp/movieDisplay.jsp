<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>MovieToday</title>
</head>
<body>
<jsp:include page="navbar.jsp" />
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Movies</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/createmovie.jsp"
					class="btn btnsuccess">Add New Movies</a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Movie Name</th>
						<th>Genre</th>
						<th>Description</th>
						<th>Casts</th>
						<th>Duration</th>
						<th>Date release</th>
						<th>Image</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="movie" items="${listMovies}">
<!-- For each user in the database, display their information accordingly -->

						<tr>
							<td><c:out value="${movie.movieName}" /></td>
							<td><c:out value="${movie.movieGenre}" /></td>
							<td><c:out value="${movie.movieDescription}" /></td>
							<td><c:out value="${movie.movieCasts}" /></td>
							<td><c:out value="${movie.movieDuration}" /></td>
							<td><c:out value="${movie.movieDateRelease}" /></td>
							<td><c:out value="${movie.movieImage}" /></td>
<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->

							<td><a href="edit?name=<c:out value='${movie.movieName}'/>">Edit</a>

								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?name=<c:out value='${movie.movieName}' />">Delete</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>