<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/HostelManagement/style.css"
	type="text/css" />
<title>Welcome Admin</title>
</head>
<body>
	<%
if(request.getAttribute("adminaddingresult")!=null){%>
	<h3>Admin Registration Failed</h3>
	<%}
%>
	<form action=adminsignup method="post" style="border: 1px solid #ccc">


		<div class="container">
			<h1>Admin Sign Up</h1>
			<p>Please fill in this form to create an Admin account.</p>
			<hr>

			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="email" required> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="psw" required> <label
				for="psw-repeat"><b>Auth Token</b></label> <input type="password"
				placeholder="Admin Authorization Token" name="authtoken" required>

			<div class="clearfix">
				<button type="button" class="cancelbtn">Cancel</button>
				<button type="submit" class="signupbtn">Sign Up</button>
			</div>
		</div>
	</form>
	</form>
</body>
</html>