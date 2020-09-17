package com.hefshine.leaves.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefshine.leaves.beans.Leaves;
import com.hefshine.leaves.dao.Leavesdao;


public class ProcessLeavesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Leavesdao leavesdao=new Leavesdao();
		
		try {
			
			ArrayList< Leaves> leaves=leavesdao.selectAll();
			
			
			PrintWriter writer=response.getWriter();
			
			response.setContentType("text/html");
			
			writer.write("<form action=\"ProcessLeavesActionController\">");
			writer.write("<table name=\"list\" border=\"1\" align=\"centre\">");
			writer.write("<tr>");
			writer.write("<td align=\"centre\">Leave type</td>");
			writer.write("<td align=\"centre\">Applied date</td>");
			writer.write("<td align=\"centre\">From date</td>");
			writer.write("<td align=\"centre\">To date</td>");
			writer.write("<td align=\"centre\">Leave Status</td>");
			writer.write("<td align=\"centre\">Reason</td>");
			writer.write("<td align=\"centre\">Action</td>");
			writer.write("</tr>");
			
			for( Leaves leave:leaves )
			{
				
				writer.write("<tr>");
				writer.write("<td align=\"left\">"+leave.getLtype()+"</td>");
				writer.write("<td align=\"left\">"+leave.getApplied_date()+"</td>");
				writer.write("<td align=\"left\">"+leave.getFormdate()+"</td>");
				writer.write("<td align=\"left\">"+leave.getTodate()+"</td>");
				writer.write("<td align=\"left\">"+leave.getStatus()+"</td>");
				writer.write("<td align=\"left\">"+leave.getReason()+"</td>");				
				
				
				writer.write("<td align=\"left\">");
				int leaveid=leave.getLid();
				writer.print("<select name=\"");
				writer.print(leaveid);
				writer.print("\">");
				writer.print("<option value=\"approved\">approve</option>");	
				writer.print("<option value=\"rejected\">reject</option>");
				writer.print("</select>");
				writer.write("</td>");
				
			
				writer.write("<br>");
				
			}
			writer.write("</table>"+"<br><br>");
			writer.write("<input type=\"submit\">");
			writer.write("<form>");
			
		}catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}