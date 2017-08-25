package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.service.NewsService;
import com.soda.service.impl.NewsServiceImpl;

public class AddNewsServlet extends HttpServlet {

	private NewsService ns = new NewsServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("ns_title");
		String userId = request.getParameter("ns_userId");
		String content = request.getParameter("ns_content");
		int state = 0;
		if (request.getParameter("ns_state") != null&&request.getParameter("ns_state").length()>0)
			state = Integer.parseInt(request.getParameter("ns_state"));
		int num = 0;
		if (request.getParameter("ns_number") != null&&request.getParameter("ns_number").length()>0)
			num = Integer.parseInt(request.getParameter("ns_number"));

		int number = ns.AddNews(title, userId, num, state, content);
	
		response.sendRedirect("SelectNewsServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
