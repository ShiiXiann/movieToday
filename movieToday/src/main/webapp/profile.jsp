<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>MovieToday</title>
</head>
<body>
	<!-- Navigation Bar -->
	<nav class="navbar sticky-top navbar-expand-md navbar-light bg-light">
		<ul class="navbar-nav mx-auto">

			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/movie.jsp">Home</a></li>
			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/createmovie.jsp"> Add Movies</a></li>
			<%-- <li class="nav-item text-center"><a class="nav-link" href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
			<li class="nav-item text-center"><a class="nav-link" href="<%=request.getContextPath()%>/register.jsp">Register</a></li>
			<li class="nav-item text-center"><a class="nav-link" href="#">Profile</a>
			</li>

			<li class="nav-item text-center"><a class="nav-link" href="#">Favourite</a>
			</li>
			<li class="nav-item text-center"><a class="nav-link" href="UserServlet/logout">Log
					out</a></li> --%>
			<%
			String username = (String) session.getAttribute("user");
			if (username != null) {
			%>
			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/register.jsp">Register</a></li>


			<%
			} else {
			%>
			<li class="nav-item text-center"><a class="nav-link" href="#">Profile</a>
			</li>

			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/favourite.jsp">Favourite</a></li>
			<li class="nav-item text-center"><a class="nav-link"
				href="UserServlet/logout">Log out</a></li>
			<%
			}
			%>

		</ul>
	</nav>
	<h4 style="text-align: center;">Welcome to your profile page!
		${username}</h4>
	<%
	if (session.getAttribute("username") == null)
		response.sendRedirect("http://localhost:8080/movieToday/login.jsp");
	%>


				


</body>
</html>