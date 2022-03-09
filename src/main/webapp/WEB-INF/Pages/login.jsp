<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class = "container">

<form action = "login" method = "post">

<h2>Login Form</h2>

<img height =100px width = 100px   src = "images/login.png">

<div>
<label>Username</label>
<input type = "text" class = "form-control" name = "username" required>
</div>


<div>
<label>Password</label>
<input type = "password" class = "form-control" name = "password" required>
</div>

<br>

<button class = "btn btn-primary" type = "submit">Login</button>
<a href = "/register" style = "text-decoration:none">
<button class = "btn btn-danger" type = "button">Register</button>
</a>

</form>

</div>

</body>
</html>