<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leaves From</title>
<link rel="stylesheet" href="style.css">
</head>
<body bgcolor="gold">
<marquee><h1>Leaves From</h1></marquee>
  <form  action="LeavesController" method="post" >
Leave type:<select name="ltype" >
<option>Medical</option>
<option>Wedding</option>
<option>Accidant</option>
<option>Personal</option>
<option>Holiday</option>
<option>sick leave</option>
<option>Maternity</option>
</select><br><br>
From-date:<input type="date" name="fromdate"><br><br>
To-Date  :<input type="date" name="todate"><br><br>
Discriptions:<input type="text" name="discriptions"><br><br>
 Resion :<input type="text" name="resion"><br><br>
 <input type="submit" value="submit">
 <h2><a href="Login.jsp">LOG OUT</a></h2>
</form>
</body>
</html>