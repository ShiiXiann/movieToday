<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Manage movies</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Manage Movies </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/MovieServlet/display"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${movie != null}">
					<form action="updateMovie" method="post">
				</c:if>
				<c:if test="${movie == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${movie != null}">Edit Movie</c:if>


						<c:if test="${movie == null}">Add New Movie</c:if>


					</h2>
				</caption>
				<c:if test="${movie != null}">
					<input type="hidden" name="id"
						value="<c:out
value='${movie.id}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Movie Name</label> <input type="text"
						value="<c:out
value='${movie.movieName}' />" class="form-control"
						name="movieName" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Genre</label> <input type="text"
						value="<c:out
value='${movie.movieGenre}' />" class="form-control"
						name="movieGenre">
				</fieldset>
				<fieldset class="form-group">
					<label>Description</label> <input type="text"
						value="<c:out
value='${movie.movieDescription}' />" class="form-control"
						name="movieDescription">
				</fieldset>
				<fieldset class="form-group">
					<label>Cast</label> <input type="text"
						value="<c:out
value='${movie.movieCasts}' />" class="form-control"
						name="movieCasts">
				</fieldset>
				<fieldset class="form-group">
					<label>Duration</label> <input type="text"
						value="<c:out
value='${movie.movieDuration}' />" class="form-control"
						name="movieDuration">
				</fieldset>
				<fieldset class="form-group">
					<label>Date Release</label> <input type="text"
						value="<c:out
value='${movie.movieDateRelease}' />" class="form-control"
						name="movieDateRelease">
				</fieldset>
				<fieldset class="form-group">
					<label>Image</label> <input type="text"
						value="<c:out
value='${movie.movieImage}' />" class="form-control"
						name="movieImage">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>