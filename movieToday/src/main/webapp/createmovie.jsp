<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar sticky-top navbar-expand-md navbar-light bg-light">
		<ul class="navbar-nav mx-auto">

			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/movie.jsp">Home</a></li>
			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/createmovie"> Add Movies</a></li>
			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/register.jsp">Register</a></li>
			<li class="nav-item text-center"><a class="nav-link" href="#">Profile</a>
			</li>

			<li class="nav-item text-center"><a class="nav-link" href="#">Favourite</a>
			</li>
			<li class="nav-item text-center"><a class="nav-link" href="#">Log
					out</a></li>

		</ul>
	</nav>
	<div class="bg-dark text-white">
		<form action="CMovieServlet" method="post">
			Enter movie name: <input type="text" name="movieName" size="20"><br>
			Enter movie genre: <input type="text" name="movieGenre" size="20"><br>
			Enter your description: <input type="text" name="movieDescription"
				size="20"><br>
			Enter movie casts: <input type="text"
				name="movieCasts" size="20"><br>
			Enter movie duration: <input
				type="text" name="movieDuration" size="20"><br> 
			Enter movie date release: <input type="text" name="movieDateRelease"
				size="20"><br>
			<!-- Implement submit button with type = submit to perform the request when clicked -->
			<div class="text-center">
			<input type="submit" value="Add movie" class="bg-primary text-white"/>
			</div>
		</form>
	</div>

</body>
</html>