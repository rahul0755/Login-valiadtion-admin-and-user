package com.hefsine.SessionFilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.leaves.beans.User;

public class SessionFilter implements Filter {
	public SessionFilter() {}
	public void destroy() {}


	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;
		HttpSession session=req.getSession();
		
		/*if(session == null)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(req, res);
		}
		else 
		{*/
			User user=(User) session.getAttribute("user");
			
			if( session == null && user == null)
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(req, res);
			}
			chain.doFilter(req, res);
		}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
