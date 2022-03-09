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
		<h2>Add Movie</h2>

		<form action = "addMovie" method = "post">

			<div>
				<label>Name of Movie</label> <input type="text" class="form-control"
					name="name">
			</div>

			<div>
				<label>Year</label> <input type="text" class="form-control"
					name="year">
			</div>

			<div>
				<label>Director</label> <input type="text" class="form-control"
					name="director">
			</div>

			<div>
				<label>Poster</label> <input type="text" class="form-control"
					name="poster">
			</div>

			<div>
				<label>Story</label>
				<textarea type="text" class="form-control" name="story"></textarea>
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