<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">

		<form action="register" method="post" id="registerForm">

			<h2>User Registration Form</h2>

			<img height=100px width=100px src="images/login.png">

			<div>
				<label>Username</label> <input type="text" class="form-control"
					name="username" required>
			</div>


			<div>
				<label>Password</label> <input type="password" class="form-control"
					name="password" required>
			</div>

			<div>
				<label>Roles</label>

				<div>
					<!-- If the checkbox is checked, the hidden input will be overridden as it has the same name -->
					<input id="hiddenAdmin" type="hidden" name="admin"
						value="dummyAdmin"> <input id="admin" type="checkbox"
						name="admin" value="Admin"> <label for="admin">Admin</label>
				</div>

				<div>
					<input id="hiddenEmployee" type="hidden" name="employee"
						value="dummyEmployee"> <input id="employee"
						type="checkbox" name="employee" value="Employee"> <label
						for="employee">Employee</label>
				</div>

				<div>
					<input id="hiddenCustomer" type="hidden" name="customer"
						value="dummyCustomer"> <input id="customer"
						type="checkbox" name="customer" value="Customer"> <label
						for="customer">Customer</label>
				</div>


<!-- Using javascript to make sure if check boxes are checked, the hidden inputs are unchecked -->

<script type="text/javascript">
	
function checkBoxFunction(){
	if(document.getElementById('admin').checked){
		document.getElementById('hiddenAdmin').disabled = true;
	}
	
	if(document.getElementById('employee').checked){
		document.getElementById('hiddenEmployee').disabled = true;
	}
	
	if(document.getElementById('customer').checked){
		document.getElementById('hiddenCustomer').disabled = true;
	}
}
	
	
	const form = document.getElementById('registerForm');
	
	form.addEventListener('submit',(event) => {
		checkBoxFunction();
	});

	
</script>


			</div>

			<br>

			<button class="btn btn-primary" type="submit">Register</button>
			<a href="/login" style="text-decoration: none">
				<button class="btn btn-danger" type="button">Back to Login</button>
			</a>

		</form>

	</div>

</body>
</html>