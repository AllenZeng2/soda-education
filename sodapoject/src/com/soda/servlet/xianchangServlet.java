package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.Course;
import com.soda.entity.PageInfo;
import com.soda.service.CourseService;
import com.soda.service.impl.CourseServiceImpl;

public class xianchangServlet extends HttpServlet {

	private CourseService cs = new CourseServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		int param = 1;
		if (request.getParameter("param") != null
				&& request.getParameter("param").length() > 0) {
			param = Integer.parseInt(request.getParameter("param"));
		}
		if (param == 1) {

			PageInfo pi = new PageInfo(1, 10, 0, 0);
			if (request.getParameter("page") != null
					&& request.getParameter("page").length() > 0) {
				pi.setPageNum(Integer.parseInt(request.getParameter("page")));
			}
			int num = cs.selectTotalCount();
			pi.setTotalCount(num);
			pi.setTotalPage((num + pi.getPageSize() - 1) / pi.getPageSize());
			if (pi.getPageNum() < 1)
				pi.setPageNum(1);

			if (pi.getPageNum() > pi.getTotalPage())
				pi.setPageNum(pi.getTotalPage());

			List<Course> list = cs.selectXianchangServlet(pi);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("qiantai/xianchang.jsp").forward(
					request, response);
		}
		if (param == 2) {
			String ce_name = request.getParameter("ce_name");
			Course course = new Course();
			course.setCe_name(ce_name);

			PageInfo pi = new PageInfo(1, 10, 0, 0);
			if (request.getParameter("page") != null
					&& request.getParameter("page").length() > 0) {
				pi.setPageNum(Integer.parseInt(request.getParameter("page")));
			}
			int num = cs.selectTotalCount();
			pi.setTotalCount(num);
			pi.setTotalPage((num + pi.getPageSize() - 1) / pi.getPageSize());
			if (pi.getPageNum() < 1)
				pi.setPageNum(1);

			if (pi.getPageNum() > pi.getTotalPage())
				pi.setPageNum(pi.getTotalPage());

			List<Course> list = cs.selectMohuCourse(course, pi);

			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("qiantai/xianchang.jsp").forward(
					request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
