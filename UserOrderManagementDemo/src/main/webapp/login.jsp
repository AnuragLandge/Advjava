<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="loginservlet" method="post">
	UserName: <input type="text" name="uname" id="unm" placeholder="Enter UserName">
	Password: <input type="password" name="pass" id="pwd" placeholder="Enter Password">
	<button type="submit" name="btn" id="btn">Login</button>
	</form>
</body>
</html>