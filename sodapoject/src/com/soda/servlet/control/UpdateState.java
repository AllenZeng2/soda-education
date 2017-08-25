package com.soda.servlet.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.ConditionInfo;
import com.soda.entity.User;
import com.soda.service.UserService;
import com.soda.service.impl.UserServiceImpl;

public class UpdateState {

	private UserService us=new UserServiceImpl();

	public void updateState(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
	
		int num=Integer.parseInt(request.getParameter("num"));
		int id=Integer.parseInt(request.getParameter("uid"));
		us.updateState(id,num);
		if(num==2){
			PrintWriter out=response.getWriter();
			out.print("<script>");
			out.print("alert('删除成功')");
			out.print("</script>");
		}
		
	}
	
	//多选删除
	public void updateStates(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int num=Integer.parseInt(request.getParameter("num"));
		String[] ids=request.getParameterValues("checkbox2");
		if(ids!=null){
		for (int i = 0; i < ids.length; i++) {
			System.out.println(ids[i]);
			us.updateState(Integer.parseInt(ids[i]), num);
		}
		//response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("<script>");
		out.print("alert('删除成功')");
		out.print("</script>");
		
		
		
		String loginName=request.getParameter("ur_loginName");
		String realName=request.getParameter("ur_name");
		String state=request.getParameter("ur_state");
		String page=request.getParameter("page");
		
		System.out.println(loginName);
		//查询信息类
		ConditionInfo cf=new ConditionInfo();
		cf.setLoginName(loginName);
		cf.setRealName(realName);
		cf.setItemsEveryPage(5);
		//设置当前页为第一页
		cf.setCurrentPage(1);
		//判断page是否为空或双引号,主要是防止非链接访问
		if(page!=null&&page.length()>0){
			cf.setCurrentPage(Integer.parseInt(page));
			
		}
		//对"全部"进行处理
		if(state==null||state.length()==0){
			cf.setState(2);
		}else{
			cf.setState(Integer.parseInt(state));
		}
		//查询得到查询的count,并赋值
		cf.setTotalCount(us.getTotalPages(cf));
		//对count+9在整除,获得页数
		cf.setTotalPages((cf.getTotalCount()+4)/cf.getItemsEveryPage());
		//防止查询无结果
		if(cf.getTotalPages()<1)
			cf.setTotalPages(1);
		
		//防止首页和尾页跳出
		if(cf.getCurrentPage()<1){
			cf.setCurrentPage(1);
		}
		if(cf.getCurrentPage()>cf.getTotalPages()){
			cf.setCurrentPage(cf.getTotalPages());
		}
		//根据传入的param值相应操作
		
			List<User> users=us.selectUsers(cf);

    		request.setAttribute("info",cf);
    		
			request.setAttribute("users", users);
			
			request.getRequestDispatcher("houtai/pages/user/list.jsp").forward(request, response);	

	}
	}
	
	
	
	
}
