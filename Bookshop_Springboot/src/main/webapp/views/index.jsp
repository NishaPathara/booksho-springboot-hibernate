<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<div
		style='position: absolute; zindex: 0; left: 0; top: 0; width: 100%; height: 40%'>
		<img src='images/image.jpg' style='width: 100%; height: 40%' alt='[]' />
		<br> <br>

		<H1 style="margin-left: 450px; color: Red">Welcome to BookShop
			Application</H1>
	</div>
	<h6 style="margin-left: 500px; margin-top: 250px; color: blue;">Provide
		your Credentials for Login</h6>


	<form action="login" method="post">
		<div style="margin-left: 500px; margin-right: 500px; margin-top: 50px">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Username</label>
				<input type="text" class="form-control"
					id="exampleFormControlInput1" placeholder="Enter your Username"
					name="uname">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Password</label>
				<input type="password" class="form-control"
					id="exampleFormControlInput1" placeholder="Enter your Password"
					name="pwd">
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="usertype"
					id="flexRadioDefault1"> <label class="form-check-label"
					for="flexRadioDefault1"> Admin </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="usertype"
					id="flexRadioDefault2" checked> <label
					class="form-check-label" for="flexRadioDefault2"> User </label>
				
			</div>
			<input style="margin-left: 190px" type="submit"
				class="btn btn-primary"><br>
	</form>
	<br>
	<a style="margin-left: 150px" href="registrationPage">New User,
		Register here!!</a>

	</div>
</body>
</html>