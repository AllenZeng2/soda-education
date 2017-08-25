package com.soda.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
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
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

import com.soda.entity.Industry;
import com.soda.service.IndustryService;
import com.soda.service.impl.IndustryServiceImpl;
import com.soda.util.PageInfo;


public class IndustryServlet extends HttpServlet {

	IndustryService is = new IndustryServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String gansha = request.getParameter("gansha");
		System.out.println(gansha);
		
		if ("show".equals(gansha)) {
			this.show(request, response);
		}else if("mohuSearch".equals(gansha)){
			this.mohuSearch(request,response);
		}else if("look".equals(gansha)){
			this.lookIndu(request,response);
		}else if("edit".equals(gansha)){
			this.editIndu(request,response);
		}else if("updateIndu".equals(gansha)){
			this.updateIndu(request,response);
		}else if("delete".equals(gansha)){
			this.deleteIndu(request,response);
		}else if("ajaxState".equals(gansha)){
			this.ajaxState(request,response);
		}else if("add".equals(gansha)){
			this.addIndu(request,response);
		}else if("deleteAll".equals(gansha)){
			this.deleteAll(request,response);
		}else if("export".equals(gansha)){
			this.exportExcel(request,response);
		}
		
		else{
			System.out.println("有错误啊");
		}

	}

	//excel导出
	private void exportExcel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		//获取需要导出的行业ID
		String[] ids = request.getParameterValues("checkbox2");
		List<Industry> list = is.exportExcel(ids);
		
		//第一步，创建一个webbook,对应一个excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		 
		 //第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		 HSSFSheet sheet = wb.createSheet("行业表一");
	     // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		 HSSFRow row = sheet.createRow(0);
		 
        //创建一个居中的格式
		 HSSFCellStyle style = wb.createCellStyle();
		 style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		 // 第四步，创建单元格，并设值表头 设置表头居中
	     HSSFCell cell = row.createCell(0);
	     cell.setCellValue("编号");
	     cell.setCellStyle(style);
	     
	     cell = row.createCell(1);
	     cell.setCellValue("作者");
	     cell.setCellStyle(style);
	     
	     cell = row.createCell(2);
	     cell.setCellValue("标题");
	     cell.setCellStyle(style);
	     
	     cell = row.createCell(3);
	     cell.setCellValue("是否推荐");
	     cell.setCellStyle(style);
	     
	     cell = row.createCell(4);
	     cell.setCellValue("更新时间");
	     cell.setCellStyle(style);
	     
	     cell = row.createCell(5);
	     cell.setCellValue("内容");
	     cell.setCellStyle(style);
	     
	     for(int i=0; i<list.size(); i++){
	    	 
	    	 //创建行
	    	 row = sheet.createRow(i+1);
	    	 Industry indu = list.get(i);
	    	 //创建单元格并赋值
	    	 row.createCell(0).setCellValue(indu.getIy_id());
	    	 row.createCell(1).setCellValue(indu.getIy_other1());
	    	 row.createCell(2).setCellValue(indu.getIy_title());
	    	
	    	 if(indu.getIy_state()==1){
    	    	 row.createCell(3).setCellValue("是");
	    	 }else{
	    		 row.createCell(3).setCellValue("否");
	    	 }
	    
	    	 row.createCell(4).setCellValue(indu.getIy_updatetime());
	    	 row.createCell(5).setCellValue(indu.getIy_content());
	    
	    	 
	     }
	     
	     //第六步，将文件存到指定位置
//	     FileOutputStream fout = new FileOutputStream("e:/abc/stu.xls");
//	     wb.write(fout);
//	     fout.close();
	     
	     //直接下载给用户
	        
			//设置相应类型为一个可下载的文件
			response.setContentType("application/x-msdownload");
			//设置下载文件的文件名
			String file = URLEncoder.encode("行业介绍.xls","utf-8");
			//设置相应头文件配置
			response.addHeader("Content-DIsposition", "attachment; filename=\""
					+ file + "\"");
			//输出流
			ServletOutputStream out = response.getOutputStream();
	
			//把文件输出到客户端
			wb.write(out);
			
			out.close();
			
	}

	//多选删除
	private void deleteAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获得被选的行业ID,存在字符串数组中
		String[] id = request.getParameterValues("checkbox2");
		int num = is.deleteAll(id);
		if( num>0){
			this.show(request, response);
		}
		
	}

	//行业新增
	private void addIndu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("iy_title");
		/*int userid = Integer.parseInt(request.getParameter("iy_userId"));*/
		String content = request.getParameter("iy_content");
		int state = Integer.parseInt(request.getParameter("iy_state"));
		
		Industry indu = new Industry();
		indu.setIy_title(title);
		indu.setIy_state(state);
		indu.setIy_content(content);
		//获取当前时间
		//indu.setIy_updatetime(new java.sql.Date(new java.util.Date().getTime()).toString());
		indu.setIy_updatetime(new java.sql.Timestamp(new java.util.Date().getTime()).toString());
		//System.out.println(indu.getIy_updatetime());
		//indu.setIy_userId(userid);
		
		int num = is.addIndu(indu);
		if( num>0){
			this.show(request, response);
		}
	}

	//异步修改状态，是否推荐
	private void ajaxState(HttpServletRequest request,
			HttpServletResponse response) {
		int iy_id=Integer.parseInt(request.getParameter("iy_id"));
		int iy_state = is.lookIndu(iy_id).getIy_state();
		//检验
		//System.out.println("要修改的id"+iy_id+"当前状态为："+iy_state);
		if(iy_state==1){
		   is.ajaxState(iy_id,0);
		}else{
		   is.ajaxState(iy_id,1);
		}
	}

	//单个删除操作
	private void deleteIndu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("id"+request.getParameter("iy_id"));
		int iy_id=Integer.parseInt(request.getParameter("iy_id"));
		//System.out.println("要删除的id"+iy_id);
		int num = is.deleteIndu(iy_id);
	    if(num>0){
	    	this.show(request, response);
	    }
	}

	//编辑操作，修改行业内容
	private void updateIndu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		int iy_id = Integer.parseInt(request.getParameter("iy_id"));
		String iy_content = request.getParameter("iy_content");
		int iy_state = Integer.parseInt(request.getParameter("iy_state"));
		//检查
		//System.out.println("id"+iy_id+"---内容"+iy_content+"---状态"+iy_state);
	    int num = is.updateIndu(iy_id,iy_content,iy_state);
	    if(num>0){
	    	this.show(request, response);
	    }
	}

	//行业编辑页面展示，相当于查看，查找时多增加一个作者姓名
	private void editIndu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		int iy_id = Integer.parseInt(request.getParameter("iy_id"));
		Industry industry = is.lookIndu(iy_id);
		request.setAttribute("industry", industry);
		request.getRequestDispatcher("houtai/pages/publicityManage/classManage/edit.jsp").forward(request, response);
		
	}

	//查看操作
	private void lookIndu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iy_id = Integer.parseInt(request.getParameter("iy_id"));
		//System.out.println("id=="+iy_id);
		Industry industry = is.lookIndu(iy_id);
		//System.out.println("id="+iy_id+"   title="+industry.getIy_title());
		request.setAttribute("industry", industry);
		request.getRequestDispatcher("houtai/pages/publicityManage/classManage/lookImpl.jsp").forward(request, response);
	}

	//模糊查询
	private void mohuSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String iy_title = new String(request.getParameter("iy_title").getBytes("ISO-8859-1"),"utf-8");
		String iy_updatetime = new String(request.getParameter("iy_updatetime").getBytes("ISO-8859-1"),"utf-8");
		String iy_state = new String(request.getParameter("iy_state").getBytes("ISO-8859-1"),"utf-8");
		
		//检查
		//System.out.println(iy_title+"---"+iy_updatetime+"---"+iy_state);
		
		if((iy_title==null||iy_title.length()==0)&&(iy_updatetime==null||iy_updatetime.length()==0)&&(iy_state==null||iy_state.length()==0)){
			this.show(request, response);
		}else{
			//页码初始化为第一页，每页5条
			PageInfo pi = new PageInfo();
			pi.setPagenum(1);
			pi.setPagesize(5);
			String page = request.getParameter("page");
			if(page!=null && page.length()>0){
				pi.setPagenum(Integer.parseInt(page));
			}
			if(pi.getPagenum()<1){
				pi.setPagenum(1);
			}
			//System.out.println("当前页码数："+pi.getPagenum());
			//查询该条件下的总条数
			int count = is.moHuSearchGetCount(iy_title,iy_updatetime,iy_state);
			//测试
			//System.out.println("当前条件下的总条数："+count);
			
			pi.setTotalcount(count);
			pi.setTotalpage((pi.getTotalcount()+pi.getPagesize()-1)/pi.getPagesize());
			if(pi.getPagenum()>pi.getTotalpage()){
				pi.setPagenum(pi.getTotalpage());
			}
			
			List<Industry> list = is.moHuSearch(iy_title,iy_updatetime,iy_state,pi);
			
			request.setAttribute("pi", pi);
			request.setAttribute("iy_title", iy_title);
			request.setAttribute("iy_updatetime", iy_updatetime);
			request.setAttribute("iy_state",iy_state );
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("houtai/pages/publicityManage/classManage/index.jsp").forward(request, response);
			
		}
	}

	// 所有存在数据列表分页展示
	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//页码初始化为第一页，每页5条
		PageInfo pi = new PageInfo();
		pi.setPagenum(1);
		pi.setPagesize(5);

		// 如果不是第一次访问，更新当前页码
		if (request.getParameter("page") != null && request.getParameter("page").length()>0) {
			pi.setPagenum(Integer.parseInt(request.getParameter("page")));
		}

		// 判断是否上一页过了第一页
		if (pi.getPagenum() < 1) {
			pi.setPagenum(1);
		}
		// 判断是否下一页到了尽头，需要先查询该条件下一共能查出多少条信息
		int count = is.getCount();
		// 设置查询总条数
		pi.setTotalcount(count);
		// 计算总页数
		pi.setTotalpage((count + pi.getPagesize() - 1) / pi.getPagesize());
		// 如果当前页码数大于查询总页数，赋值为最大页码数
		if (pi.getPagenum() > pi.getTotalpage()) {
			pi.setPagenum(pi.getTotalpage());
		}
		
       
//		System.out.println("当前页码"+pi.getPagenum());
//		System.out.println("单页条数"+pi.getPagesize());
//		System.out.println("总条数"+pi.getTotalcount());
//		System.out.println("总页数"+pi.getTotalpage());
		//分页全查展示
		List<Industry> list = is.show(pi);
//		for(Industry d : list){
//			System.out.println(d.getIy_title());
//		}
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("houtai/pages/publicityManage/classManage/index.jsp").forward(request, response);
	
	}
}

