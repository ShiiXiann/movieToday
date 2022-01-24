<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/5.10.2/css/font-awesome.min.css">

<meta charset="ISO-8859-1">
</head>
<body>
	<!-- Nav Bar -->
	<nav class="navbar sticky-top navbar-expand-md navbar-light bg-light">
		<ul class="navbar-nav mx-auto">

			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/movie.jsp">Home</a></li>
			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/createmovie.jsp"> Add Movies</a></li>
			<li class="nav-item text-center"><a class="nav-link" href="/profile.jsp">Profile</a>
			</li>

			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/favourite.jsp">Favourite</a></li>
			<li class="nav-item text-center"><a class="nav-link" href="#">Log
					out</a></li>

		</ul>
	</nav>
	<!--  Favourites page   -->

	<div class="col text-center">

	<div class="container-fluid p-5 my-3 bg-dark text-white">
		<div>
			<h3>Favourites</h3>
			<!-- <c:forEach var="movie" items="${listMovies}"> -->
			<div class="card" style="width: 18rem;">
				<div class="card-body">
					<img class="card-img-top" src="..." alt="Card image cap">
					<h5 class="card-title text-dark">Movie Name</h5>
					<img src="https://img.icons8.com/fluency-systems-regular/25/000000/star--v1.png"/>
				</div>
			</div>
		</div>
</body>
</html>