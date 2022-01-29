<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>MovieToday</title>
</head>
<body>
<jsp:include page="navbar.jsp" />
	<!--  Home page   -->
	<div class="col text-center">
		<a href="<%=request.getContextPath()%>/createmovie.jsp"
					class="btn btnsuccess">Add New Movies</a>

	</div>

	<div class="container-fluid p-5 my-3 bg-dark text-white">
		<div>
			<h3>Movies</h3>
			<div class="card" style="width: 18rem;">
				<div class="card-body">
					<img class="card-img-top" src="..." alt="Card image cap">
					<h5 class="card-title text-dark">Movie Name</h5>
					<a href="<%=request.getContextPath()%>/MovieServlet/display"
						class="card-link">Manage Movie</a>
				</div>
			</div>
		</div>
	</div>



</body>
</html>
