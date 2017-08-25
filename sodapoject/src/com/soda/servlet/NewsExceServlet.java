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

import com.soda.entity.News;
import com.soda.service.NewsService;
import com.soda.service.impl.NewsServiceImpl;

public class NewsExceServlet extends HttpServlet {

	private NewsService ns=new NewsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String dd=request.getParameter("dd");
		String a[]=dd.split(",");
		List<News> list=new ArrayList<News>();
		for (int i = 0; i < a.length; i++) {
			News news=ns.getNewsWithUser(Integer.parseInt(a[i]));
			list.add(news);
		}
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet();
		HSSFRow row=sheet.createRow(0);
		HSSFCellStyle style=wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFCell cell=row.createCell(0);
		cell.setCellValue("编号");
		cell.setCellStyle(style);
		
		cell=row.createCell(1);
		cell.setCellValue("标题");
		cell.setCellStyle(style);
		
		cell=row.createCell(2);
		cell.setCellValue("内容");
		cell.setCellStyle(style);
		
		cell=row.createCell(3);
		cell.setCellValue("状态");
		cell.setCellStyle(style);
		
		cell=row.createCell(4);
		cell.setCellValue("作者姓名");
		cell.setCellStyle(style);
		
		for(int i=0;i<list.size();i++){
			row=sheet.createRow(i+1);
			News ns=list.get(i);
			
			row.createCell(0).setCellValue(ns.getNs_id());
			row.createCell(1).setCellValue(ns.getNs_title());
			row.createCell(2).setCellValue(ns.getNs_content());
			row.createCell(3).setCellValue(ns.getNs_state());
			row.createCell(4).setCellValue(ns.getNs_other1());
			
		}
		
		response.setContentType("application/x-msdownload");
		String file=URLEncoder.encode("新闻下载.xlsx","utf-8");
		response.addHeader("Content_Disposition","attachment;filaname=\""+file+"\"");
		ServletOutputStream out=response.getOutputStream();
		wb.write(out);
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
