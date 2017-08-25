package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.Survey;
import com.soda.service.SurveyService;
import com.soda.service.impl.SurveyServiceImpl;

public class CopyrightStateServlet extends HttpServlet {

	 private SurveyService ss = new SurveyServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gansha = request.getParameter("gansha");
		System.out.println(gansha);

		if("show".equals(gansha)){
			this.show(request,response);
		}else if("update".equals(gansha)){
			this.update(request,response);
		}else{
			System.out.println("ÓÐ´íÎó");
		}

	
	}

	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String content = request.getParameter("sy_content");
		int num = ss.updateContent(content,1);
		if(num>0){
			this.show(request, response);
		}
		
	}


	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Survey copyrightState = ss.getSurveyWithUser(1);
		request.setAttribute("copyrightState", copyrightState);
		//System.out.println(copyrightState.getSy_title());
		request.getRequestDispatcher("houtai/pages/publicityManage/onePageManage/copyrightState.jsp").forward(request, response);
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		
	}

}
