package com.soda.servlet.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.Role;
import com.soda.entity.Student;
import com.soda.entity.User;
import com.soda.service.RoleService;
import com.soda.service.StudentService;
import com.soda.service.UserService;
import com.soda.service.impl.RoleServiceImpl;
import com.soda.service.impl.StudentServiceImpl;
import com.soda.service.impl.UserServiceImpl;

public class LoginControl {
	private RoleService rs=new RoleServiceImpl();
	private UserService us=new UserServiceImpl();
	private StudentService ss=new StudentServiceImpl();
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String ur_loginName=request.getParameter("ur_loginName");
		String ur_password=request.getParameter("ur_password");
		System.out.println(ur_loginName+"  "+ur_password);
	//	User user=null;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(ur_loginName!=null&&ur_loginName.length()>0){
			User user=us.selectUserByName(ur_loginName);
			if(user!=null&&user.getUr_password().equals(ur_password)){
				Role role=rs.selectRoleById(user.getRole().getRe_id());
				user.setRole(role);
				request.getSession().setAttribute("user", user);
					//request.getRequestDispatcher("houtai/main.jsp").forward(request, response);
				if(user.getUr_state()==0){
					out.print("改账号已被禁用");
					out.close();
					return;
				}
				
				if(user.getUr_status()==0){
					out.print("改账号已被删除");
					out.close();
					return;
				}
				out.print("true");
				out.close();
				
				
			}else{
				out.print("账号密码错误");
				out.close();
			}
		}
	}
	public void frontLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String ur_loginName=request.getParameter("st_loginName");
		String ur_password=request.getParameter("st_password");
		if(ur_loginName!=null&&ur_loginName.length()>0){
			Student stu=ss.selectStudentByName(ur_loginName);
			//System.out.println(stu.getSt_loginName());
			
			if(stu!=null&&stu.getSt_password().equals(ur_password)){
				request.getSession().setAttribute("student", stu);	
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				if(stu.getSt_status()==0){
					
					out.print("<script>");
					out.print("alert('改账号已被禁用');");
					out.print("location.href='qiantai/login.jsp';");
					out.print("</script>");
					out.close();
					return;
				}
				response.sendRedirect("IndexServlet");
			}else{
				request.getRequestDispatcher("qiantai/login.jsp").forward(request, response);
			}
		}
	}

}
