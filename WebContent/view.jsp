<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="com.hefshine.leaves.beans.Leaves"%>
	<%@ page import="com.hefshine.leaves.beans.User"%>
	<%@ page import="com.hefsine.SessionFilter.SessionFilter"%>
	<%@ page import="com.hefshine.leaves.dao.Leavesdao"%>
	<%@ page import="java.util.ArrayList"%>

	<form action="StatusLeaveController" method="post">

	<%
	PrintWriter writer=response.getWriter();
	response.setContentType("text/html");
		HttpSession s=request.getSession(); User user=(User)s.getAttribute("user");

		Leavesdao leavesdao=new Leavesdao();
		
		ArrayList<Leaves> leaves=leavesdao.leavestatus(user.getId());
		
		for( Leaves leave:leaves )
		{
        writer.print("<table border='1' width='100%'");
        writer.print("<tr><th>leaves type</th>"
		+"<th>Applied date</th>"
		+"<th>from date</th>"
		+"<th>to date</th>"
		+"<th>Leave Status</th>"
		+"<th>discription</th>"
		+"<th>reason</th>"+"<tr>"
		+"<td>"+leave.getLtype()+"</td>"+
		"<td>"+leave.getApplied_date()+"</td>"+
		"<td>"+leave.getFormdate()+"</td>"+
		"<td>"+leave.getTodate()+"</td>"+
 		"<td>"+leave.getStatus()+"</td>"+
 		"<td>"+leave.getDiscriptions()+"</td>"+
		"<td>"+leave.getReason()+"</td>");
		writer.print("</table>");
		}
%>
	</form>
</body>
</html>