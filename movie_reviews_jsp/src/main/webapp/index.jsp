<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Movie Reviews</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
crossorigin="anonymous">

</head>
<body>
	<div class="container" align="center" class="mt+12">
	<form method="post" action = "ctl?page=auth">
	<table>
	<tbody>
		<tr>
			<td>Email :</td>
			<td><input type ="text" name = "email" /></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><input type ="password" name = "password" /></td>
		</tr>
		<tr>
			<td><a href="ctl?page=register">Sign Up</a></td>
			<td><input type = "submit" value="Sign In" /></td>
		</tr>
	</tbody>
	</table>
	</form>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>