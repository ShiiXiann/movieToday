<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="navbar.jsp" />


	<div class="row">
		<div class="container">
			<h3 class="text-center">List of review</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the review.jsp page -->
				<a href="<%=request.getContextPath()%>/review.jsp"
					class="btn btnsuccess">Add New Review</a>
			</div>
			<br>

			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>movie_id</th>
						<th>user_id</th>
						<th>review</th>

					</tr>
				</thead>


				<tbody>
					<c:forEach var="review" items="${listReview}">
						<!-- For each user in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${review.id}" /></td>
							<td><c:out value="${review.movie_id}" /></td>
							<td><c:out value="${review.user_id}" /></td>
							<td><c:out value="${review.review}" /></td>
							<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a href="edits?id=<c:out value='${review.id}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deletesreviews?id=<c:out
value='${review.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!-- review form -->
	<div class="container h-100">
		<div class="row h-100 justify-content-center align-items-center">
			<div class="col-10 col-md-8 col-lg-6">
				<h4 style="text-align: center; margin-top: 10px; margin-left: 40px">Review</h4>




				<!-- Buttons -->


				<form action="postReview" method="post">

					<div class="row h-10 justify-content-center align-items-center">
						<div class="col-10 col-md-8 col-lg-6">
							<input name="movie_id"margin-right:20px"></input>

						</div>
					</div>
					<br>

					<div class="row h-10 justify-content-center align-items-center">
						<div class="col-10 col-md-8 col-lg-6">
							<textarea name="review"
								style="height: 300px; width: 300px; margin-right: 20px"> </textarea>

						</div>
					</div>
					<br>

					<button class="btn btn-success" type="submit" value="submit"
						style="margin-left: 180px;">Submit</button>


					<button class="btn btn-success" type="submit">Update</button>


					<button class="btn btn-success" type="submit">Delete</button>
				</form>
</body>
</html>