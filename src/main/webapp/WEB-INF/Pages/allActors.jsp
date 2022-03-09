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

		<form action="addMovie" method="post">

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
			<a href="showAll" style="text-decoration: none">
				<button type="button" class="btn btn-secondary">Show All
					Movies</button>
			</a>
			<button type="reset" class="btn btn-danger">Clear</button>

		</form>

		<br>

		<table class="table table-striped table-hover">

			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Role</th>
					<th>Photo</th>
					<th>Created Date</th>
				</tr>
			</thead>


			<tbody>
				<!-- Using JSTL for looping through the item we got through request scope -->
				<c:forEach items="${actors}" var="actor" varStatus = "cc">
					<!-- CC used here for count -->

					<tr>
						<td>${cc.count}</td>
						<td>${actor.name}</td>
						<td>${actor.role}</td>
						<td><img src="${actor.photo}" width="150px" height="150px"></td>
						<td>${actor.createDate}</td>
						<!-- Passing id of the movie as parameter -->
					</tr>
				</c:forEach>
			</tbody>


			</div>
</body>
</html>