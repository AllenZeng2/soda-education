package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.soda.entity.ConditionInfo;
import com.soda.entity.User;
import com.soda.service.UserService;
import com.soda.service.impl.UserServiceImpl;
import com.soda.servlet.control.Select;
import com.soda.servlet.control.SelectById;
import com.soda.servlet.control.UpdateState;
import com.soda.servlet.control.UpdateUser;

public class UserServlet extends HttpServlet {

	public void doGet(Servlet ss, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("param");
		
		System.out.println("输出servletConfig"+ss.getServletConfig());
		// 鍏ㄦ煡/妯＄硦鏌ヨ
		if (param != null && "select".equals(param)) {
			Select s = new Select();
			s.selectUsers(request, response);

		}
		// 鍗曟煡
		if (param != null && "single".equals(param)) {

			SelectById sbi = new SelectById();
			sbi.selectUserById(request, response);

		}
		// 缂栬緫
		if (param != null && "edit".equals(param)) {

			UpdateUser uu = new UpdateUser();
			uu.updateUser(request, response);

		}
		// 绂佺敤鍜屽垹闄�
		if (param != null && "updateState".equals(param)) {

			UpdateState us = new UpdateState();
			//
			us.updateState(request, response);

		}

		// 娣诲姞
		if (param != null && "add".equals(param)) {

			UpdateUser uu = new UpdateUser();
			uu.addeUser(request, response);
		}
		//缇ゅ垹
		if (param != null && "updateStates".equals(param)) {

			UpdateState us = new UpdateState();
			//
			us.updateStates(request, response);

		}
		//名字查询
		if (param != null && "sameName".equals(param)) {
			Select s = new Select();
			s.selectUserByName(request, response);	
		}
		// 改密码
		if (param != null && "pwd".equals(param)) {

			UpdateUser uu = new UpdateUser();
			uu.updatePwd(request, response);

		}	
		// 身份证选性别
		if (param != null && "gender".equals(param)) {

			UpdateUser uu = new UpdateUser();
			uu.checkGender(request, response);

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
