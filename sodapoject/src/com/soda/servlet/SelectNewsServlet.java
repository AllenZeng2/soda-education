package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.ConditionNews;
import com.soda.entity.News;
import com.soda.entity.Page;
import com.soda.service.NewsService;
import com.soda.service.impl.NewsServiceImpl;

public class SelectNewsServlet extends HttpServlet {

	private NewsService ds = new NewsServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Page p=new Page(5,1,0,0);
		
		
		if(request.getParameter("page")!=null&&request.getParameter("page").length()>0){
			p.setPageNum(Integer.parseInt(request.getParameter("page")));
		}
		
	
		String title=null;
		if(request.getParameter("ns_title")!=null&&request.getParameter("ns_title").length()>=0){
			 title=request.getParameter("ns_title");
		}
		
		String date =null;
		if(request.getParameter("ns_showtime")!=null&&request.getParameter("ns_title").length()>=0){
		 date=request.getParameter("ns_showtime");
		}
		int state=2;
		if(request.getParameter("ns_state")!=null){
			state=Integer.parseInt(request.getParameter("ns_state"));
			
		}
		ConditionNews  ct=new ConditionNews(title, date, state);
		
		int num=ds.SelectCountNews(ct);
		
		p.setTotalSize(num);
		p.setTotalNum((p.getTotalSize()+p.getPageSize()-1)/p.getPageSize());
		if(p.getPageNum()<1)
			p.setPageNum(1);
		
		if(p.getPageNum()>p.getTotalNum())
			p.setPageNum(p.getTotalNum());
		List<News> news = ds.SelectNews(ct,p);
		request.setAttribute("p",p);
		request.setAttribute("news", news);
	
		request.getRequestDispatcher("houtai/pages/newconter/index.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
