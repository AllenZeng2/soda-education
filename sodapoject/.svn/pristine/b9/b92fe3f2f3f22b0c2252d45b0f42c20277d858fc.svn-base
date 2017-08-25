package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.entity.Contact;
import com.soda.entity.Survey;
import com.soda.service.ContactService;
import com.soda.service.impl.ContactServiceImpl;

public class ContactServlet extends HttpServlet {

	private ContactService cs = new ContactServiceImpl();

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
		String phone = request.getParameter("ct_phone");
		System.out.println(phone);
		String content = request.getParameter("ct_content");
		int num = cs.updateContent(phone,content);
		if(num>0){
			this.show(request, response);
		}
		
		
	}


	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Contact contact = cs.getContact();
		request.setAttribute("contact", contact);
		//System.out.println(contact.getCt_title());
		request.getRequestDispatcher("houtai/pages/publicityManage/onePageManage/relationUs.jsp").forward(request, response);
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}

