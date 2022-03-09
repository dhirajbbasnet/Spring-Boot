<!-- Using jstl for the loop -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.dhiraj.controller.dto.MovieDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Movie</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h2>Edit Movie</h2>

		<form action="updateMovie" method="get">

			<input type = "hidden" name = "id" value = ${movie.id}>

			<div>
				<label>Name of Movie</label> <input type="text" class="form-control"
					name="name" value = "${movie.name}">
			</div>

			<div>
				<label>Year</label> <input type="text" class="form-control"
					name="year" value = "${movie.year}" readonly="readonly">
			</div>

			<div>
				<label>Director</label> <input type="text" class="form-control"
					name="director" value = "${movie.director}">
			</div>

			<div>
				<label>Poster</label> <input type="text" class="form-control"
					name="poster" value = "${movie.poster}"><img src = "${movie.poster}" width = "50px" height = "50px">
			</div>

			<div>
				<label>Story</label>
				<textarea type="text" class="form-control" name="story" readonly="readonly">${movie.story}</textarea>
			</div>

			<br>

			<button type="submit" class="btn btn-primary">Save Changes</button>
			<a href="showAll" style="text-decoration: none">
				<button type="button" class="btn btn-secondary">Show All
					Movies</button>
			</a>
			<button type="reset" class="btn btn-danger">Clear</button>

		</form>

		<br>

		<table class="table table-striped table-hover"">

			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Year</th>
					<th>Director</th>
					<th>Poster</th>
					<th>Story</th>
					<th>Action</th>
				</tr>
			</thead>
<%-- 
The old way we used to do
			<%
			List<Movie> movies = (List<Movie>) request.getAttribute("movies");

			for (Movie movie : movies) {
			%>

			<tbody>
				<tr>
					<td><%=movie.getId()%></td>
					<td><%=movie.getName()%></td>
					<td><%=movie.getYear()%></td>
					<td><%=movie.getDirector()%></td>
					<td><img src="<%=movie.getPoster()%>" width="150px"
						height="150px"></td>
					<td><%=movie.getStory()%></td>
				</tr>


			</tbody>

			<%
			}
			%> --%>
			
			<tbody>
			<!-- Using JSTL for looping through the item we got through request scope -->
			<c:forEach items = "${movies}" var = "movie">
			
			<tr>
				<td>${movie.id}</td>
				<td>${movie.name}</td>
				<td>${movie.year}</td>
				<td>${movie.director}</td>
				<td><img src="${movie.poster}" width = "150px" height = "150px"></td>
				<td>${movie.story}</td>
				<!-- Passing id of the movie as parameter -->
				
				<td>
				<a href = "deleteMovie?id=${movie.id}"><img src="images/delete.png" width = "50px" height = "50px"></a>
				<a href = "editMovie?id=${movie.id}"><img src="images/edit.png" width = "50px" height = "50px"></a>
				</td>
				
			</tr>
			</c:forEach>
			</tbody>
			

	</div>

</body>
</html>