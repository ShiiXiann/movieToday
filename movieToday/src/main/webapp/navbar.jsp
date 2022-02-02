<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>MovieToday</title>
</head>
<body>
	<!-- Navigation Bar using c:if condition -->
	<nav class="navbar sticky-top navbar-expand-md navbar-light bg-light">
		<ul class="navbar-nav mx-auto">
			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/movie.jsp">Home</a></li>
			<li class="nav-item text-center"><a class="nav-link"
				href="<%=request.getContextPath()%>/createmovie.jsp"> Add Movies</a></li>

			<!-- If userId is null, show login, register  -->
			<c:if test="${id == null}">
				<li class="nav-item text-center"><a class="nav-link"
					href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
				<li class="nav-item text-center"><a class="nav-link"
					href="<%=request.getContextPath()%>/register.jsp">Register</a></li>
			</c:if>

			<!-- if userId is not null, show profile, favourite, review, logout -->
			<c:if test="${id != null}">
				<li class="nav-item text-center"><a class="nav-link" href="<%=request.getContextPath()%>/profile?id=<c:out value='${sessionScope["id"]}'/>">Profile</a>
				</li>
				<li class="nav-item text-center"><a class="nav-link"
					href="<%=request.getContextPath()%>/favourite.jsp">Favourite</a></li>
				<li class="nav-item text-center"><a class="nav-link"
					href="<%=request.getContextPath()%>/reviews">Review</a></li>
				<li class="nav-item text-center"><a class="nav-link"
					href="UserServlet/logout">Log out</a></li>
			</c:if>
		</ul>
	</nav>
</body>
</html>