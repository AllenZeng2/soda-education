package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.Contact;
import com.soda.entity.Course;
import com.soda.entity.Industry;
import com.soda.entity.Information;
import com.soda.entity.News;
import com.soda.entity.Notice;
import com.soda.entity.Survey;
import com.soda.service.CourseService;
import com.soda.service.SurveyService;
import com.soda.service.impl.CourseServiceImpl;
import com.soda.service.impl.SurveyServiceImpl;

public class IndexServlet extends HttpServlet {

	private SurveyService ss = new SurveyServiceImpl();
	private CourseService cs = new CourseServiceImpl();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		//右三块展示
		List<Survey> survey = ss.selectSurvey();
		//现场展示
		List<Course>  course1=cs.selectXianCourse();
		//在线展示
		List<Course>  course2=cs.selectZaiCourse();
		//咨询展示
		List<Information> information=cs.selectInformation();
		//公告展示
		List<Notice> notice=cs.selectNotice();
		//新闻展示
		List<News> news=cs.selectNews();
		//行业展示
		List<Industry> industry=cs.selectIndustry();
		//联系我们展示
		Contact contact=cs.SelectContact();
		
		request.setAttribute("survey", survey);
		request.setAttribute("course1", course1);
		request.setAttribute("course2", course2);
		request.setAttribute("information", information);
		request.setAttribute("notice", notice);
		request.setAttribute("news", news);
		request.setAttribute("industry", industry);
		request.setAttribute("contact", contact);	
		request.getSession().setAttribute("contact", contact);
		
		request.getRequestDispatcher("qiantai/index.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
