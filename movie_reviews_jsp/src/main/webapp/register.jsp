<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>
	<form method='post' action = 'ctl?page=signup'>
	<table>
	<tbody>
		<tr>
			<td>First Name :</td>
			<td><input type ="text" name = "firstName" /></td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td><input type ="text" name = "lastName" /></td>
		</tr>
		<tr>
			<td>Mobile No :</td>
			<td><input type ="text" name = "mobile" /></td>
		</tr>
		<tr>
			<td>Date Of Birth :</td>
			<td><input type ="date" name = "birth" /></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><input type ="text" name = "email" /></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><input type ="password" name = "password" /></td>
		</tr>
		<tr>
			<td><input type = "submit" value="Sign Up" /></td>
		</tr>
	</tbody>
	</table>
	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>