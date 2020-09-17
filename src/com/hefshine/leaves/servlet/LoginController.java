package com.hefshine.leaves.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.leaves.beans.User;
import com.hefshine.leaves.dao.Userdao;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");

		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");

		Userdao userdao=new Userdao();


		try {
			User user=userdao.check(uname, pass);

			
			if(user == null )
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
				dispatcher.include(request, response);
			}
			else
			{
				HttpSession session=request.getSession();
				session.setAttribute("user", user);
				
			if(user.getRole().equalsIgnoreCase("manager"))
			{	
				RequestDispatcher dispatcher=request.getRequestDispatcher("nava-man.jsp");
				dispatcher.forward(request, response);

			}
			if(user.getRole().equalsIgnoreCase("Employee") && user.getStatus().equalsIgnoreCase("enable"))
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("nava-emp.jsp");
				dispatcher.forward(request, response);
			}

			}
		}
		catch (ClassNotFoundException e) 
		{

			e.printStackTrace();
		}
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
	}
}
