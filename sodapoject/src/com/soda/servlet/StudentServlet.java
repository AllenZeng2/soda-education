package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.service.StudentService;
import com.soda.service.impl.StudentServiceImpl;

public class StudentServlet extends HttpServlet {

	private StudentService ss=new StudentServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stid=request.getParameter("stid");
		String st_money=request.getParameter("st_money");
		System.out.println("jinalie");
		if(stid!=null&&stid.length()>0&&st_money!=null&&st_money.length()>0){
			ss.addMoney(Integer.parseInt(stid),Integer.parseInt(st_money));
			response.sendRedirect("IndexServlet");
		}

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
