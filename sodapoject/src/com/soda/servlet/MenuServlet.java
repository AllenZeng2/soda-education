package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.servlet.control.MenuControl;
import com.soda.servlet.control.RoleControl;

public class MenuServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String param=request.getParameter("param");

		MenuControl mc=new MenuControl();
		//查询
		if("select".equals(param)){
			mc.selectMenus(request, response);
				
		}
		
		//禁用
		if("updateState".equals(param)){
			mc.updateMenu(request, response);	
		}
		//详情
		if("single".equals(param)){
		
			mc.detailOfMenu(request, response);
			
		}
		//编辑
		if("edit".equals(param)){
			mc.editMenu(request, response);
		}
		
		//判断重名
		if("same".equals(param)){
			mc.checkNameOfMenu(request, response);
		}
		//添加菜单
		if("add".equals(param)){
			mc.addMenu(request, response);
		}
		//多项删除
		if("mutipleDel".equals(param)){
			mc.mutipleDelMenu(request, response);
		}
		if("selectRoles".equals(param)){
			mc.selectAllRoles(request, response);
		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
