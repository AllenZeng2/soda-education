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
import com.soda.service.StudentService;
import com.soda.service.impl.CourseServiceImpl;
import com.soda.service.impl.Stu_courseServiceImpl;
import com.soda.service.impl.StudentServiceImpl;
import com.soda.servlet.control.CourseControl;

public class BaomingGoumaiServlet extends HttpServlet {

	private CourseControl cc=new CourseControl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String param = request.getParameter("param");
		// 单个购买
		if ("dangemai".equals(param)) {
			cc.buyCourse(request,response);
		}
		//多个购买
		if("duoge".equals(param)){
			cc.addCoures(request,response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
