package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.Course;
import com.soda.entity.PageInfo;
import com.soda.entity.Shopcar;
import com.soda.entity.Student;
import com.soda.service.CourseService;
import com.soda.service.ShopcarService;
import com.soda.service.impl.CourseServiceImpl;
import com.soda.service.impl.ShopcarServiceImpl;

public class NoSettlementServlet extends HttpServlet {

	private CourseService cs = new CourseServiceImpl();
	private ShopcarService ss = new ShopcarServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		int param = 1;
		if (request.getParameter("param") != null
				&& request.getParameter("param").length() > 0) {
			param = Integer.parseInt(request.getParameter("param"));
		}
		Student stu = (Student) request.getSession().getAttribute("student");
		if (param == 1) {
			if (stu != null) {
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

				List<Shopcar> list = ss.selectNoSettlement(pi);
				request.setAttribute("pi", pi);
				request.setAttribute("shopcar", list);

				request.getRequestDispatcher("qiantai/pay.jsp").forward(
						request, response);
			} else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('您还未登录，请先登录');location.href='qiantai/login.jsp';</script>");
				out.close();
			}

		}

		if (param == 2) {
			if (stu != null) {
				String sr_coursename = request.getParameter("sr_coursename");
				Shopcar shopcar = new Shopcar();
				shopcar.setSr_coursename(sr_coursename);

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
				
				List<Shopcar> list1 = ss.selectMohuNoSettlementCourse(shopcar,
						pi);

				request.setAttribute("pi", pi);
				request.setAttribute("shopcar", list1);

				request.getRequestDispatcher("qiantai/pay.jsp").forward(
						request, response);
			} else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('您还未登录，请先登录');location.href='qiantai/login.jsp';</script>");
				out.close();
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
