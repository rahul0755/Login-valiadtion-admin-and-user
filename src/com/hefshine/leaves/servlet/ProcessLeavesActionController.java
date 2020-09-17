package com.hefshine.leaves.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefshine.leaves.dao.Leavesdao;


public class ProcessLeavesActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer=response.getWriter();
		
		Enumeration<String> enumt=request.getParameterNames();
		
		Leavesdao leavesdao=new Leavesdao();
		
		HashMap<String, String> actionmap=new HashMap<String,String>();
		
		while(enumt.hasMoreElements())
		{
			String temp=enumt.nextElement();
			String  value=request.getParameter(temp);
			
			writer.write(temp+" "+value+ "\n");
			actionmap.put(temp, value);
			
			try {
				leavesdao.updateAll(actionmap);
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
		
	
	}


	

}
