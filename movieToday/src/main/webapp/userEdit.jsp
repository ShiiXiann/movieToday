<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MovieToday</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<!-- Navigation Bar -->
	<jsp:include page="navbar.jsp" />
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
Edit User
</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name=id value="${user.id}" />
				</c:if>
				<fieldset class="form-group">
					<label>Username</label> <input type="text" value="${user.username}"
						class="form-control" name="username" required="required">
				</fieldset>
				<fieldset class="form-group">
					<!-- made changes here -->
					<label>Password</label> <input type="password"
						value="${user.password}" class="form-control" name="password">
				</fieldset>
				<fieldset class="form-group">
					<label>Email</label> <input type="text" value="${user.email}"
						class="form-control" name="email">
				</fieldset>
				<fieldset class="form-group">
					<label> Phone Number</label> <input type="text"
						value="${user.phoneNumber}" class="form-control"
						name="phoneNumber">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>