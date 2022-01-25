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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<!-- Navigation Bar -->
<jsp:include page="navbar.jsp" />
  
	<h4 style="text-align: center;">Welcome, ${username} !</h4>
	<%
	if (session.getAttribute("id") == null)
		response.sendRedirect("http://localhost:8080/movieToday/login.jsp");
	%>

	<div class="container" style="text-align: center;">

		<c:forEach var="user" items="${ProfileDetails}">
			<!-- Displaying of profile details -->

			<%-- <c:out value="Username: ${user.username}" />
							<c:out value="Password: ${user.password}" />
							<c:out value="Email: ${user.email}" />
							<c:out value="Phone Number: ${user.phoneNumber}" /> --%>

			<div class="container mt-4 mb-4 p-3 d-flex justify-content-center">
				<div class="card p-5 shadow-sm">
					<div
						class=" image d-flex flex-column justify-content-center align-items-center">
						<img
							src="https://img.icons8.com/bubbles/50/000000/gender-neutral-user.png"
							class="img-radius" alt="User-Profile-Image"><span
							class="name mt-3">
							<c:out
								value="Username: ${user.username}" /></span> <span class="idd"><c:out
								value="Email: ${user.email}" /></span>
						<div
							class="d-flex flex-row justify-content-center align-items-center gap-2">
							<span class="idd1"><c:out
									value="Phone Number: ${user.phoneNumber}" /></span> <span><i
								class="fa fa-copy"></i></span>
						</div>
						<c:out value="id: ${user.id}" />
						<div class=" d-flex mt-2">
								<button class="btn1 btn-success"><a href="edit?id=<c:out value='${user.id}'/>" style="color:inherit">Edit Profile</a></button>
						</div>
							<div class=" d-flex mt-2">
								<button class="btn1 btn-danger"><a href="delete?id=<c:out value='${user.id}'/>" style="color:inherit">Delete Profile</a></button>
						</div>
					

					</div>
				</div>
			</div>
		</c:forEach>

	</div>



</body>
</html>