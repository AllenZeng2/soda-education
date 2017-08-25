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
import com.soda.entity.Stu_course;
import com.soda.entity.Student;
import com.soda.service.CourseService;
import com.soda.service.Stu_courseService;
import com.soda.service.impl.CourseServiceImpl;
import com.soda.service.impl.Stu_courseServiceImpl;

public class MyCourseServlet extends HttpServlet {

	private CourseService cs = new CourseServiceImpl();
	private Stu_courseService scs = new Stu_courseServiceImpl();

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
				List<Stu_course> mycourse = scs.selectAllMyCourse(stu,pi);
				request.setAttribute("pi", pi);
				request.setAttribute("mycourse", mycourse);
				request.getRequestDispatcher("qiantai/course.jsp").forward(
						request, response);
			} else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('您还未登录，请先登录');location.href='qiantai/login.jsp';</script>");
				out.close();
			}
		}
/*
<<<<<<< .mine
			int num = cs.selectTotalCount();
			pi.setTotalCount(num);
			pi.setTotalPage((num + pi.getPageSize() - 1) / pi.getPageSize());
			if (pi.getPageNum() < 1)
				pi.setPageNum(1);
			if (pi.getPageNum() > pi.getTotalPage())
				pi.setPageNum(pi.getTotalPage());
			
			List<Stu_course> mycourse=scs.selectAllMyCourse(pi);
			
			request.setAttribute("pi", pi);
			request.setAttribute("mycourse", mycourse);
			
			request.getRequestDispatcher("qiantai/course.jsp").forward(request, response);
		}
		if(param==2){	
			
			String ce_name=request.getParameter("ce_name");
			Course course=new Course();
			course.setCe_name(ce_name);
		    //��ҳ��ʼ
			PageInfo pi = new PageInfo(1, 10, 0, 0);
			if (request.getParameter("page") != null
					&& request.getParameter("page").length() > 0) {
				pi.setPageNum(Integer.parseInt(request.getParameter("page")));
*/
		if (param == 2) {
			if (stu != null) {
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

				List<Stu_course> mycourse1 = scs.selectMohuMycourse(course, pi);

				request.setAttribute("pi", pi);
				request.setAttribute("mycourse", mycourse1);
				request.getRequestDispatcher("qiantai/course.jsp").forward(
						request, response);
			} else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('您还未登录，请先登录');location.href='qiantai/login.jsp';</script>");
				out.close();
			}
		}
	}
			/*
<<<<<<< .mine
			int num = cs.selectTotalCount();
			pi.setTotalCount(num);
			pi.setTotalPage((num + pi.getPageSize() - 1) / pi.getPageSize());
			if (pi.getPageNum() < 1)
				pi.setPageNum(1);

			if (pi.getPageNum() > pi.getTotalPage())				
				pi.setPageNum(pi.getTotalPage());
			//	��ҳ����
			
			//ģ���ѯ�ֳ��γ�
			List<Stu_course> mycourse1=scs.selectMohuMycourse(course,pi);
			
			
			request.setAttribute("pi", pi);
			request.setAttribute("mycourse", mycourse1);
			request.getRequestDispatcher("qiantai/course.jsp").forward(request, response);
		}
	}
*/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
