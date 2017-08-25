package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginOutServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String param=request.getParameter("param");
			request.getSession().invalidate();
			if("houtai".equals(param))
				response.sendRedirect(request.getContextPath()+"/houtai/login.jsp");
			else{
				response.sendRedirect(request.getContextPath()+"/qiantai/login.jsp");	
			}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);

	}

}
