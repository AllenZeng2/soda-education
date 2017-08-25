package com.soda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.soda.entity.Information;
import com.soda.entity.News;
import com.soda.entity.Notice;
import com.soda.entity.Page;
import com.soda.entity.PageInfo;
import com.soda.service.NoticeService;
import com.soda.service.impl.NoticeServiceImpl;

public class NoticeServlet extends HttpServlet {

	private NoticeService ns = new NoticeServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		if (request.getParameter("ne_id") != null
				&& request.getParameter("ne_id").length() > 0) {
			int a = Integer.parseInt(request.getParameter("ne_id"));
		
		}
		int param = 1;

		if (request.getParameter("param") != null
				&& request.getParameter("param").length() > 0)
			param = Integer.parseInt(request.getParameter("param"));
		if (param == 1 ) {

			String ne_title = request.getParameter("ne_title");

			String ne_updatetime = request.getParameter("ne_updatetime");

			int ne_states = 0;
			if (request.getParameter("ne_states") == null)
				ne_states = 4;
			else if (request.getParameter("ne_states").equals("3"))
				ne_states = Integer.parseInt(request.getParameter("ne_states"));
			else if (request.getParameter("ne_states").equals("2"))
				ne_states = Integer.parseInt(request.getParameter("ne_states"));
			else if (request.getParameter("ne_states").equals("1"))
				ne_states = Integer.parseInt(request.getParameter("ne_states"));

			Notice notice = new Notice();

			notice.setNe_title(ne_title);
			notice.setNe_updatetime(ne_updatetime);
			notice.setNe_level(ne_states);

			PageInfo pi = new PageInfo(1, 5, 0, 0);

			if (request.getParameter("page") != null
					&& request.getParameter("page").length() > 0
					&& !"".equals(request.getParameter("page"))) {
				pi.setPageNum(Integer.parseInt(request.getParameter("page")));
			}
			pi.setTotalCount(ns.conditionCount(notice));

			pi.setTotalPage((pi.getTotalCount() + pi.getPageSize() - 1)
					/ pi.getPageSize());

			if (pi.getPageNum() < 1)
				pi.setPageNum(1);
		
			if (pi.getPageNum() > pi.getTotalPage())
				pi.setPageNum(pi.getTotalPage());

			if (pi.getPageNum() < 1)
				pi.setPageNum(1);
		
			if (pi.getPageNum() > pi.getTotalPage())
				pi.setPageNum(pi.getTotalPage());

		

			List<Notice> list = ns.conditionSelect(notice, pi);
			
			
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);

			request.getRequestDispatcher("houtai/pages/afficheManage/index.jsp")
					.forward(request, response);
		}
	
		if (param == 2) {

			int ne_id = 0;
			if (request.getParameter("ne_id") != null
					&& request.getParameter("ne_id").length() > 0)
				ne_id = Integer.parseInt(request.getParameter("ne_id"));

			int num = ns.deleteNotice(ne_id);
			request.getRequestDispatcher("NoticeServlet?param=1").forward(
					request, response);

		}
		if (param == 4) {

			int ne_id = 0;
			if (request.getParameter("ne_id") != null
					&& request.getParameter("ne_id").length() > 0)
				ne_id = Integer.parseInt(request.getParameter("ne_id"));

			Notice notice = ns.getNoticeWithId(ne_id);

			request.setAttribute("notice", notice);

			request.getRequestDispatcher(
					"houtai/pages/afficheManage/lookImpl.jsp").forward(request,
					response);

		}
		if (param == 5) {

			int ne_id = 0;
			if (request.getParameter("ne_id") != null
					&& request.getParameter("ne_id").length() > 0)
				ne_id = Integer.parseInt(request.getParameter("ne_id"));

			Notice notice = ns.getNoticeWithId(ne_id);

			request.setAttribute("notice", notice);

			request.getRequestDispatcher("houtai/pages/afficheManage/edit.jsp")
					.forward(request, response);

		}
		if (param == 6) {

			int ne_id = 0;
			if (request.getParameter("ne_id") != null
					&& request.getParameter("ne_id").length() > 0)
				ne_id = Integer.parseInt(request.getParameter("ne_id"));

			String ne_title = request.getParameter("ne_title");
			String ne_other1 = request.getParameter("ne_userId");

			String state = new String(request.getParameter("ne_level").getBytes("ISO-8859-1"), "utf-8");

			int ne_level = Integer.parseInt(state);
			
			String ne_content = request.getParameter("ne_content");

			Notice notice = new Notice();

			notice.setNe_id(ne_id);
			notice.setNe_title(ne_title);
			notice.setNe_other1(ne_other1);
			notice.setNe_level(ne_level);
			notice.setNe_content(ne_content);

			int num = ns.submitNotice(notice);

			request.setAttribute("notice", notice);

			request.getRequestDispatcher("NoticeServlet?param=1&ne_title=")
					.forward(request, response);

		}
		if (param == 7) {

			String ne_title = request.getParameter("ne_title");
			String ne_other1 = request.getParameter("ne_userId");

			int ne_level = Integer.parseInt(request.getParameter("ne_level"));
			String ne_content = request.getParameter("ne_content");

			Notice notice = new Notice();

			notice.setNe_title(ne_title);
			notice.setNe_other1(ne_other1);

			notice.setNe_level(ne_level);
			notice.setNe_content(ne_content);

			int num = ns.addNotice(notice);
			response.sendRedirect("NoticeServlet");
		}
		if (param == 8) {

			String dd = request.getParameter("dd");
			String a[] = dd.split(",");
			for (int i = 0; i < a.length; i++) {

				int aa = ns.deleteNotice(Integer.parseInt(a[i]));
			}
			request.getRequestDispatcher("NoticeServlet?param=1").forward(
					request, response);

		}
		if (param == 9) {

			String dd = request.getParameter("dd");
			String a[] = dd.split(",");
			List<Notice> list = new ArrayList<Notice>();
			for (int i = 0; i < a.length; i++) {
				Notice notice = ns.getNoticeWithId(Integer.parseInt(a[i]));
				list.add(notice);
			}
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("咨询表");
			HSSFRow row = sheet.createRow(0);// 首先在创建第一行
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("编号");
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue("标题");
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue("内容");
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue("状态");
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue("作者姓名");
			cell.setCellStyle(style);

			for (int i = 0; i < list.size(); i++) {
				row = sheet.createRow(i + 1);
				Notice ne = list.get(i);

				row.createCell(0).setCellValue(ne.getNe_id());
				row.createCell(1).setCellValue(ne.getNe_title());
				row.createCell(2).setCellValue(ne.getNe_content());
				row.createCell(3).setCellValue(ne.getNe_level());
				row.createCell(4).setCellValue(ne.getNe_other1());

			}
			response.setContentType("application/x-msdownload");
			String file = URLEncoder.encode("公告下载.xlsx", "utf-8");
			response.addHeader("Content_Disposition", "attachment;filaname=\""
					+ file + "\"");
			ServletOutputStream out = response.getOutputStream();
			wb.write(out);
			out.close();

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
