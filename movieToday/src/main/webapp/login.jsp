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

			<li class="nav-item text-center"><a class="nav-link" href="#">Home</a></li>
			<li class="nav-item text-center"><a class="nav-link" href="#">
					Add Movies</a></li>
			<li class="nav-item text-center"><a class="nav-link" href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
			<li class="nav-item text-center"><a class="nav-link" href="<%=request.getContextPath()%>/register.jsp">Register</a></li>
			<li class="nav-item text-center"><a class="nav-link" href="#">Profile</a>
			</li>

			<li class="nav-item text-center"><a class="nav-link" href="#">Favourite</a>
			</li>
			<li class="nav-item text-center"><a class="nav-link" href="#">Log
					out</a></li>

		</ul>
	</nav>
	<!-- Start of Login Form  -->
	<div class="container h-100">
		<div class="row h-100 justify-content-center align-items-center">
			<div class="col-10 col-md-8 col-lg-6">

				<h4 style="text-align: center; margin-top: 10px;">Login to your
					account</h4>

				<form action="LoginServlet" method="post">

					<!--  Username -->
					<div class="row h-100 justify-content-center align-items-center">
						<div class="col-10 col-md-8 col-lg-6">
							Username: <input type="text" name="username">

						</div>
					</div>
					<br>

					<!-- Password -->
					<div class="row h-100 justify-content-center align-items-center">
						<div class="col-10 col-md-8 col-lg-6">
							Password: <input type="password" name="password">
						</div>
					</div>
					<br>

					<div class="row h-100 justify-content-center align-items-center">
						<div class="col-10 col-md-8 col-lg-6">
							<!--To disable the register button depending on the agreed Boolean
  value -->
							<button class="btn btn-success" type="submit" value="Login"
								style="text-align: center;">Login</button>
						</div>
					</div>
					<br>
					<div class="row h-100 justify-content-center align-items-center">
						<div class="col-10 col-md-8 col-lg-6">
							<p>
								<a href="<%=request.getContextPath()%>/register.jsp"> Don't
									have an account? Register here!</a>
							</p>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>