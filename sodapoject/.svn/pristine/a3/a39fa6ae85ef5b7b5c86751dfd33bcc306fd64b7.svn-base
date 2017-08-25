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
import com.soda.entity.PageInfo;
import com.soda.service.InformationService;
import com.soda.service.NewsService;
import com.soda.service.impl.InformationServiceImpl;
import com.soda.service.impl.NewsServiceImpl;

public class InformationServlet extends HttpServlet {

	private InformationService is = new InformationServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		if (request.getParameter("in_id") != null
				&& request.getParameter("in_id").length() > 0) {
			int a = Integer.parseInt(request.getParameter("in_id"));
		}
		int param = 1;

		if (request.getParameter("param") != null
				&& request.getParameter("param").length() > 0)
			param = Integer.parseInt(request.getParameter("param"));
		// 全查
		if (param == 1) {

			String in_title = request.getParameter("in_title");

			String in_updatetime = request.getParameter("in_updatetime");

			int in_state;
			if (request.getParameter("in_state") == null)
				in_state = 2;
			else
				in_state = Integer.parseInt(request.getParameter("in_state"));

			Information information = new Information();
			information.setIn_title(in_title);
			information.setIn_updatetime(in_updatetime);
			information.setIn_state(in_state);

			PageInfo pi = new PageInfo(1, 5, 0, 0);

			if (request.getParameter("page") != null
					&& request.getParameter("page").length() > 0
					&& !"".equals(request.getParameter("page"))) {
				pi.setPageNum(Integer.parseInt(request.getParameter("page")));
			}
			pi.setTotalCount(is.conditionCount(information));

			pi.setTotalPage((pi.getTotalCount() + pi.getPageSize() - 1)
					/ pi.getPageSize());

			if (pi.getPageNum() < 1)
				pi.setPageNum(1);
			// 当一直向前时，最大就是pi.getTotalCount();
			if (pi.getPageNum() > pi.getTotalPage())
				pi.setPageNum(pi.getTotalPage());

			if (pi.getPageNum() < 1)
				pi.setPageNum(1);
			// 当一直向前时，最大就是pi.getTotalCount();
			if (pi.getPageNum() > pi.getTotalPage())
				pi.setPageNum(pi.getTotalPage());

			// List<News> news=ns.getNews1(n);

			List<Information> list = is.conditionSelect(information, pi);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);

			request.getRequestDispatcher(
					"houtai/pages/publicityManage/poineerMessage/index.jsp")
					.forward(request, response);
		}
		// 单删除
		if (param == 2) {

			int in_id = 0;
			if (request.getParameter("in_id") != null
					&& request.getParameter("in_id").length() > 0)
				in_id = Integer.parseInt(request.getParameter("in_id"));

			int num = is.deleteInformation(in_id);
			request.getRequestDispatcher("InformationServlet?param=1").forward(
					request, response);

		}
		// 输出界面复选框是否选中
		if (param == 3) {

			int in_state = Integer.parseInt(request.getParameter("in_state"));
			int in_id = Integer.parseInt(request.getParameter("in_id"));

			int num = is.updateState(in_state, in_id);

			response.sendRedirect("houtai/pages/publicityManage/poineerMessage/index.jsp");

		}
		// 查看
		if (param == 4) {

			int in_id = 0;
			if (request.getParameter("in_id") != null && request.getParameter("in_id").length() > 0)
				in_id = Integer.parseInt(request.getParameter("in_id"));

			Information information = is.getInformationWithId(in_id);

			request.setAttribute("information", information);

			request.getRequestDispatcher("houtai/pages/publicityManage/poineerMessage/lookImpl.jsp").forward(request, response);

		}
		// 编辑
		if (param == 5) {
			
			int in_id = 0;
			if (request.getParameter("in_id") != null
					&& request.getParameter("in_id").length() > 0)
			in_id = Integer.parseInt(request.getParameter("in_id"));

			Information information = is.getInformationWithId(in_id);

			request.setAttribute("information", information);

			request.getRequestDispatcher("houtai/pages/publicityManage/poineerMessage/edit.jsp").forward(request, response);

		}
		// 编辑提交
		if (param == 6) {

			int in_id = 0;
			if (request.getParameter("in_id") != null
					&& request.getParameter("in_id").length() > 0)
			in_id = Integer.parseInt(request.getParameter("in_id"));

			String in_title = request.getParameter("in_title");
			String in_other1 = request.getParameter("in_userId");

			String state = new String(request.getParameter("in_state").getBytes("ISO-8859-1"), "utf-8");

			int in_state = Integer.parseInt(state);
			String in_content = request.getParameter("in_content");

			Information information = new Information();

			information.setIn_id(in_id);
			information.setIn_title(in_title);
			information.setIn_other1(in_other1);
			information.setIn_state(in_state);
			information.setIn_content(in_content);

			int num = is.submitInformation(information);

			request.setAttribute("information", information);

			request.getRequestDispatcher("InformationServlet?param=1&in_title=").forward(request, response);

		}
		// 添加
		if (param == 7) {
			String in_title = request.getParameter("in_title");
			String in_other1 = request.getParameter("in_userId");

			int in_state = Integer.parseInt(request.getParameter("in_state"));
			in_state = 0;
			String in_content = request.getParameter("in_content");

			Information information = new Information();
			information.setIn_title(in_title);
			information.setIn_other1(in_other1);

			information.setIn_state(in_state);
			information.setIn_content(in_content);

			int num = is.addInformation(information);
			response.sendRedirect("InformationServlet");

		}
		// 批量删除
		if (param == 8) {

			String dd = request.getParameter("dd");
			String a[] = dd.split(",");
			for (int i = 0; i < a.length; i++) {

				int aa = is.deleteInformation(Integer.parseInt(a[i]));
			}
			request.getRequestDispatcher("InformationServlet?param=1").forward(
					request, response);

		}
		// 批量导出
		if (param == 9) {

			String dd = request.getParameter("dd");
			String a[] = dd.split(",");
			List<Information> list = new ArrayList<Information>();
			for (int i = 0; i < a.length; i++) {
				Information information = is.getInformationWithId(Integer
						.parseInt(a[i]));
				list.add(information);
			}
			// 声明一个Excel表格
			HSSFWorkbook wb = new HSSFWorkbook();
			// 声明Exceln表名
			HSSFSheet sheet = wb.createSheet("咨询表");
			// 然后在表明中创建第一行
			HSSFRow row = sheet.createRow(0);// 首先在创建第一行
			// 设置表单的居中格式
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 然后就是开始创建表头，还有表中的数据
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
				Information in = list.get(i);

				row.createCell(0).setCellValue(in.getIn_id());
				row.createCell(1).setCellValue(in.getIn_title());
				row.createCell(2).setCellValue(in.getIn_content());
				row.createCell(3).setCellValue(in.getIn_state());
				row.createCell(4).setCellValue(in.getIn_other1());

			}
			// 设置响应是一个可下载文件固定写法
			response.setContentType("application/x-msdownload");
			// 设置文件的下载名称
			String file = URLEncoder.encode("新闻下载.xlsx", "utf-8");
			// 设置响应文件配置
			response.addHeader("Content_Disposition", "attachment;filaname=\""
					+ file + "\"");
			// 输出流
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
