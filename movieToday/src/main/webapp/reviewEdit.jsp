<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${review != null}">
					<form action="updatesreviews" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${review != null}"> Edit Review </c:if>
					</h2>
				</caption>

				<c:if test="${review != null}">
					<input type="hidden" name=id value="${review.id}" />
				</c:if>
				<fieldset class="form-group">
				<label>Movie Id</label> <input type="text" value="${review.movie_id}"
	            class="form-control" name="movie_id" required="required">
				</fieldset>
				<fieldset class="form-group">
					<!-- made changes here -->
					<label>User Id</label> <input type="text"
						value="${review.user_id}" class="form-control" name="user_id">
				</fieldset>
				<fieldset class="form-group">
					<label>Review</label> <input type="text" value="${review.review}"
						class="form-control" name="review">
				</fieldset>


				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>