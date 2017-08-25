package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.service.NewsService;
import com.soda.service.impl.NewsServiceImpl;

public class UpdateNewsByIdServlet extends HttpServlet {

	private NewsService ds=new NewsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("ns_id"));
		String content=request.getParameter("ns_content");
		int state=1;
		if(request.getParameter("ns_state")!=null)
		state =Integer.parseInt(request.getParameter("ns_state"));
		int num=ds.UpdateNewsById(id,content, state);
		request.getRequestDispatcher("SelectNewsServlet").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
