package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.service.NewsService;
import com.soda.service.impl.NewsServiceImpl;

public class UpdateStateByIdServlet extends HttpServlet {
	
	private NewsService ds = new NewsServiceImpl();
		
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int id=Integer.parseInt(request.getParameter("id"));
	
		int state=Integer.parseInt(request.getParameter("state"));
		
		
		int num=ds.updateNewsById(id,state);
		
		response.sendRedirect("SelectNewsServlet");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      doGet(request, response);
		
	}

}
