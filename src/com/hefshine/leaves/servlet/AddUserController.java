package com.hefshine.leaves.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefshine.leaves.beans.User;
import com.hefshine.leaves.dao.Userdao;


public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");

		String uname=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		String status=request.getParameter("status");

		User user=new User();

		user.setUname(uname);
		user.setPassword(password);
		user.setRole(role);
		user.setStatus(status);

		Userdao userdao=new Userdao();

		try {

			userdao.insert(user);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}


}
