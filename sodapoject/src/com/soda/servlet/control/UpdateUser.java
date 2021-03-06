package com.soda.servlet.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.Role;
import com.soda.entity.User;
import com.soda.service.UserService;
import com.soda.service.impl.UserServiceImpl;

public class UpdateUser {
	private UserService us=new UserServiceImpl();
	public void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("ur_password");
		String ur_name=request.getParameter("ur_name");
		String ur_idcard=request.getParameter("ur_idcard");
		String ur_phone=request.getParameter("ur_phone");
		String ur_adress=request.getParameter("ur_adress");
		String ur_email=request.getParameter("ur_email");
		String ur_roleId=request.getParameter("ur_roleId");
		String ur_state=request.getParameter("ur_state");
		
		String ss=ur_idcard.substring(16,17);
		int sex=Integer.parseInt(ss);
		
		User user=new User();
		//设置性别
		if(sex%2==1){
			user.setUr_sex(1);
		}else
			user.setUr_sex(2);
		
		Integer rid=Integer.parseInt(ur_roleId);
		Role role=new Role();
		role.setRe_id(rid);
		Integer ur_id=Integer.parseInt(id);
		Integer state=Integer.parseInt(ur_state);
		user.setUr_id(ur_id);
		user.setUr_password(pwd);
		user.setUr_name(ur_name);
		user.setUr_idcard(ur_idcard);
		user.setUr_phone(ur_phone);
		user.setUr_address(ur_adress);
		user.setUr_email(ur_email);
		user.setRole(role);
		user.setUr_state(state);
		
		us.updateUser(user);
		
		response.sendRedirect("houtai/pages/user/list.jsp");
		
		
		
	}
	public void addeUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String ur_loginName=request.getParameter("ur_loginName");
		String pwd=request.getParameter("ur_password");
		String ur_name=request.getParameter("ur_name");
		String ur_idcard=request.getParameter("textfield15");
		String ur_phone=request.getParameter("ur_phone");
		String ur_adress=request.getParameter("ur_adress");
		String ur_email=request.getParameter("ur_email");
		String ur_roleId=request.getParameter("ur_roleId");
		String ur_state=request.getParameter("ur_state");
//		String ur_sex=request.getParameter("ur_sex");
//		System.out.println(ur_sex);
		String ss=ur_idcard.substring(16,17);
		int sex=Integer.parseInt(ss);
	
		
		User user=new User();
		//设置性别
		if(sex%2==1){
			user.setUr_sex(1);
		}else
			user.setUr_sex(2);
		
		Integer rid=Integer.parseInt(ur_roleId);
		Role role=new Role();
		role.setRe_id(rid);
		
		Integer state=Integer.parseInt(ur_state);
		user.setUr_loginName(ur_loginName);
		user.setUr_password(pwd);
		user.setUr_name(ur_name);
		user.setUr_idcard(ur_idcard);
		user.setUr_phone(ur_phone);
		user.setUr_address(ur_adress);
		user.setUr_email(ur_email);
		user.setRole(role);
		user.setUr_state(state);
		user.setUr_status(1);
		us.addUser(user);
		
		response.sendRedirect("houtai/pages/user/list.jsp");
		
	}
	public void updatePwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		User user=us.selectUserById(id);
		request.getRequestDispatcher("houtai/pages/personalManager/updatePs.jsp").forward(request, response);
	}
	//性别选中
	public void checkGender(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String ic=request.getParameter("idcard");
		
		if(ic!=null&&ic.length()>0){
			String ss=ic.substring(16,17);
			int sex=Integer.parseInt(ss);
			User user=new User();
			//设置性别
			PrintWriter out=response.getWriter();
			if(sex%2==1){
				out.print("1");
				out.close();
			}else
				out.print("2");
				out.close();
		}
		
	}

}
