<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h2>Add Actor</h2>

		<form action = "addActor" method = "post">
		<!-- Reading from the query parameter instead of passing 
		through request scope
		 -->
			<input type = "hidden", value = "${param.id}" name = "mid">

			<div>
				<label>Name of Actor</label> <input type="text" class="form-control"
					name="name">
			</div>

			<div>
				<label>Photo</label> <input type="text" class="form-control"
					name="photo">
			</div>

			<div>
				<label>Role</label> <input type="text" class="form-control"
					name="role">
			</div>


			<br>

			<button type="submit" class="btn btn-primary">Upload</button>
			<a href = "showAll" style = "text-decoration:none">
			<button type = "button" class = "btn btn-secondary">Show All Movies</button>
			</a>
			<button type="reset" class="btn btn-danger">Clear</button>

		</form>
	</div>




</body>
</html>