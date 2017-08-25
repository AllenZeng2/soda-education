package com.soda.servlet.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.PageInfo;
import com.soda.entity.Stu_course;
import com.soda.entity.Student;
import com.soda.service.CourseService;
import com.soda.service.Stu_courseService;
import com.soda.service.StudentService;
import com.soda.service.impl.CourseServiceImpl;
import com.soda.service.impl.Stu_courseServiceImpl;
import com.soda.service.impl.StudentServiceImpl;

public class CourseControl {
	private CourseService cs = new CourseServiceImpl();
	private StudentService stus = new StudentServiceImpl();
	private Stu_courseService scs = new Stu_courseServiceImpl();
	public void buyCourse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		String ce_id = request.getParameter("ce_id");

		Student stu = (Student) request.getSession().getAttribute("student");
		if (stu != null && ce_id != null && ce_id.length() > 0) {

			int stid = stu.getSt_id();

			// 报名或购买,添加到课程和学生关系表
			stus.addCourse(stid, Integer.parseInt(ce_id));

			PageInfo pi = new PageInfo(1, 10, 0, 0);
			if (request.getParameter("page") != null
					&& request.getParameter("page").length() > 0) {
				pi.setPageNum(Integer.parseInt(request.getParameter("page")));
			}
			Stu_course sc = new Stu_course();
			int num = cs.selectTotalCount();

			pi.setTotalCount(num);
			pi.setTotalPage((num + pi.getPageSize() - 1) / pi.getPageSize());
			if (pi.getPageNum() < 1)
				pi.setPageNum(1);

			if (pi.getPageNum() > pi.getTotalPage())
				pi.setPageNum(pi.getTotalPage());
			List<Stu_course> stCourses = scs.selectAllMyCourse(stu, pi);

			request.setAttribute("mycourse", stCourses);
			request.getRequestDispatcher("qiantai/course.jsp").forward(
					request, response);

		} else {
			System.out.println("未登录");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('您还未登录，请先登录');location.href='qiantai/login.jsp';</script>");
			out.close();
		}
		
	}
	public void addCoures(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}

}
