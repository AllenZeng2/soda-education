package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.service.NewsService;
import com.soda.service.impl.NewsServiceImpl;

public class UpdateStatusByIdServlet extends HttpServlet {

	private NewsService ds = new NewsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
	
	String id=request.getParameter("id");
	 String list[]=id.split(",");
	
	 for (String al : list) {
		int num	= ds.updateStatusById(Integer.parseInt(al));
	 }
	
	request.getRequestDispatcher("SelectNewsServlet").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
