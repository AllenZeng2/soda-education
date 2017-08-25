package com.soda.servlet.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.User;
import com.soda.service.UserService;
import com.soda.service.impl.UserServiceImpl;

public class SelectById {
	private UserService us = new UserServiceImpl();

	public void selectUserById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String way=request.getParameter("way");
		User user=us.selectUserById(id);
		request.setAttribute("user", user);
		if("s".equals(way))
		request.getRequestDispatcher("houtai/pages/user/detail.jsp").forward(request, response);
		else if("e".equals(way)){
			request.getRequestDispatcher("houtai/pages/user/edit.jsp").forward(request, response);
		}
	}

}
