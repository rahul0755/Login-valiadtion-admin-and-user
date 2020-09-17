package com.hefshine.leaves.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.leaves.beans.Leaves;
import com.hefshine.leaves.beans.User;
import com.hefshine.leaves.dao.Leavesdao;
import com.hefshine.leaves.dao.Userdao;


public class LeavesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();

		response.setContentType("text/html");

		String ltype=request.getParameter("ltype");
		String fromdate=request.getParameter("fromdate");
		String todate=request.getParameter("todate");
		String reasion=request.getParameter("resion");


		Leaves leaves=new Leaves();
		
		leaves.setLtype(ltype);
		leaves.setFormdate(fromdate);
		leaves.setTodate(todate);
		leaves.setReason(reasion);
		leaves.setStatus("applied");
		leaves.setDiscriptions("==============");
		Date date=new Date();
		leaves.setApplied_date(date.toString());
		

	HttpSession session=request.getSession();
	 User user=(User) session.getAttribute("user");

	 leaves.setUid(user.getId());
	 
		Leavesdao leavesdao=new Leavesdao();
		

		try {
			leavesdao.insertleaves(leaves);

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

}
