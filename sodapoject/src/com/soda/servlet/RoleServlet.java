package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.ConditionInfo;
import com.soda.entity.Role;
import com.soda.entity.User;
import com.soda.service.RoleService;
import com.soda.service.impl.RoleServiceImpl;
import com.soda.servlet.control.RoleControl;

public class RoleServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String param=request.getParameter("param");
		
		
		RoleControl rc=new RoleControl();
		//查询
		if("select".equals(param)){
			
			rc.selectRoles(request, response);
				
		}
		//详情
		if("single".equals(param)){
		
			rc.detailOfRole(request, response);
			
		}
		//禁用
		if("updateState".equals(param)){
			rc.updateRole(request, response);	
		}
		
		//添加用户
		if("add".equals(param)){
			
			rc.addRole(request, response);	
		}
		
		//判断重名
		if("same".equals(param)){
			rc.checkName(request, response);
		}
		if("editSame".equals(param)){
			rc.checkEditName(request, response);
		}
		//编辑
		if("edit".equals(param)){
			rc.editRole(request, response);
		}
		//多项删除
		if("mutipleDel".equals(param)){
			rc.mutipleDelRole(request, response);
		}
		//查询角色
		if("selectRole".equals(param)){
			rc.selectRoleForAdd(request, response);
		}
		//查询菜单
		if("selectMneu".equals(param)){
			rc.selectMenuForAdd(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	
	
	
	
	
	
	
	
	

}
