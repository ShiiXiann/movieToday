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
<title>Insert title here</title>
</head>
<body>

<jsp:include page="navbar.jsp" />
	<div class="row">
		<div class="container">
			<h3 class="text-center">Favourites List</h3>
			
			<!-- Create a table to list out all current favourite information -->
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
				
				<c:forEach var="join" items="${joinTable}">
<!-- For each user in the database, display their information accordingly -->

						<tr>
							<td><c:out value="${join.movieName}" /></td>
							<td><c:out value="${join.movieGenre}" /></td>
							<td><c:out value="${join.movieDescription}" /></td>
							<td><c:out value="${join.movieCasts}" /></td>
							<td><c:out value="${join.movieDuration}" /></td>
							<td><c:out value="${join.movieDateRelease}" /></td>
							<td><c:out value="${join.movieImage}" /></td>
<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->

<td><a
								href="http://localhost:8080/movieToday/FavouriteServlet/deleteFavourites?id=<c:out value='${join.id}' />">Delete</a></td>

						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>

</body>
</html>