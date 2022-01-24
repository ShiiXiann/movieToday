<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
	fill="currentColor" class="bi bi-star" viewBox="0 0 16 16">
  <path
		d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z" />
</svg>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar sticky-top navbar-expand-md navbar-light bg-light">
		<ul class="navbar-nav mx-auto">

			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/movie.jsp">Home</a></li>
			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/createmovie.jsp"> Add Movies</a></li>
			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/register.jsp">Register</a></li>
			<li class="nav-item text-center"><a class="nav-link" href="#">Profile</a>
			</li>

			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/favourite.jsp">Favourite</a></li>
			<li class="nav-item text-center"><a class="nav-link" href="#">Log
					out</a></li>

		</ul>
	</nav>
	<!--  Home page   -->
	<div class="col text-center">
		<div type="button" class="btn col-lg-3 bg-primary text-white"
			href="<%=request.getContextPath()%>/createMovie.jsp">Add movie
			review</div>
	</div>

	<div class="container-fluid p-5 my-3 bg-dark text-white">
		<div>
			<h3>Movies</h3>
			<!-- <c:forEach var="movie" items="${listMovies}"> -->
			<div class="card" style="width: 18rem;">
				<div class="card-body">
					<img class="card-img-top" src="..." alt="Card image cap">
					<h5 class="card-title text-dark">Movie Name</h5>
					<a href="<%=request.getContextPath()%>/createmovie.jsp"
						class="card-link">Reviews</a>

				</div>
			</div>
		</div>
</body>
</html>