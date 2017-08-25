package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.News;
import com.soda.service.NewsService;
import com.soda.service.impl.NewsServiceImpl;

public class SelectNewsByidServlet extends HttpServlet {

	private NewsService ds=new NewsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id=1;
		System.out.println(Integer.parseInt(request.getParameter("param")));
		if(request.getParameter("ns_id")!=null)
		id=Integer.parseInt(request.getParameter("ns_id"));	
		
		News news=ds.SelectNewsByid(id);
		request.setAttribute("news", news);
		
		if(Integer.parseInt(request.getParameter("param"))==1)
		request.getRequestDispatcher("houtai/pages/newconter/info.jsp").forward(request, response);
		if(Integer.parseInt(request.getParameter("param"))==2)
		request.getRequestDispatcher("houtai/pages/newconter/edit.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doGet(request, response);
	}
}
