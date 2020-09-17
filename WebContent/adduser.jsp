<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body bgcolor="gold">
<marquee><h1>Add User</h1></marquee>
<form action="AddUserController" >
User name:<input type="text" placeholder="Enter Username" name="username" required><br><br>
Password :<input type="password" placeholder="Enter Password" name="password" required><br><br>
Role:<input type="radio"  name="role"  value="Employee">
		<label for="Employee">Employee</label><br>
		<input type="radio"  name="role"  value="manager">
		<label for="Manager">Manager</label><br><br>
Status:<input type="radio"  name="status"  value="enable">
		<label for="Enable">Enable</label><br>
		<input type="radio"  name="status"  value="unable">
		<label for="Unable">Unable</label><br><br>
 <button type="submit">Login</button>&nbsp;&nbsp; <button type="submit">Cancel</button><br><br>
 <h2><a href="Login.jsp">LOG OUT</a></h2>
</form>
</body>
</html>