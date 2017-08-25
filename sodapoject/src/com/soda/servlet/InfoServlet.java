package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.Industry;
import com.soda.entity.Information;
import com.soda.entity.News;
import com.soda.entity.Notice;
import com.soda.service.IndustryService;
import com.soda.service.InformationService;
import com.soda.service.NewsService;
import com.soda.service.NoticeService;
import com.soda.service.impl.IndustryServiceImpl;
import com.soda.service.impl.InformationServiceImpl;
import com.soda.service.impl.NewsServiceImpl;
import com.soda.service.impl.NoticeServiceImpl;

public class InfoServlet extends HttpServlet {

	private NewsService ns = new NewsServiceImpl();
	private InformationService is = new InformationServiceImpl();
	private NoticeService nos = new NoticeServiceImpl();
	private IndustryService ind=new IndustryServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String param = request.getParameter("param");

		switch (Integer.parseInt(request.getParameter("param"))) {
		case 1:
			int ns_id = 0;
			if (request.getParameter("ns_id") != null
					&& request.getParameter("ns_id").length() > 0) {
				ns_id = Integer.parseInt(request.getParameter("ns_id"));
			}
			String aa = "动态新闻";

			request.setAttribute("aa", aa);
			News news = ns.selectNewsById(ns_id);
			request.setAttribute("title", news.getNs_title());
			request.setAttribute("author", news.getUser().getUr_name());
			request.setAttribute("content", news.getNs_content());
			request.getRequestDispatcher("qiantai/info.jsp").forward(request,
					response);
			break;
		case 2:
			int in_id = 0;
			if (request.getParameter("in_id") != null
					&& request.getParameter("in_id").length() > 0) {
				in_id = Integer.parseInt(request.getParameter("in_id"));
			}
			String bb = "创业资讯";
			request.setAttribute("aa", bb);
			Information information = is.selectInformationById(in_id);
			request.setAttribute("title", information.getIn_title());
			request.setAttribute("author", information.getUser().getUr_name());
			request.setAttribute("content", information.getIn_content());
			request.getRequestDispatcher("qiantai/info.jsp").forward(request,
					response);
			break;
		case 3:
			int ne_id = 0;
			if (request.getParameter("ne_id") != null
					&& request.getParameter("ne_id").length() > 0) {
				ne_id = Integer.parseInt(request.getParameter("ne_id"));
			}
			String cc = "公告信息";
			request.setAttribute("aa", cc);
			Notice notice = nos.selectNoticeById(ne_id);		    
			request.setAttribute("title", notice.getNe_title());
			request.setAttribute("author", notice.getUser().getUr_name());
			request.setAttribute("content", notice.getNe_content());
			request.getRequestDispatcher("qiantai/info.jsp").forward(request,
					response);
			break;
		case 4:
			int iy_id = 0;
			if (request.getParameter("iy_id") != null
					&& request.getParameter("iy_id").length() > 0) {
				iy_id = Integer.parseInt(request.getParameter("iy_id"));
			}
			String dd = "行业信息";
			request.setAttribute("aa", dd);			
			Industry industry=ind.selectIndustryById(iy_id);			
			request.setAttribute("title", industry.getIy_title());
			request.setAttribute("author", industry.getIy_other1());
			request.setAttribute("content", industry.getIy_content());
			request.getRequestDispatcher("qiantai/info.jsp").forward(request,
					response);
			break;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
