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
			System.out.println("�д���");
		}

	}

	//excel����
	private void exportExcel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		//��ȡ��Ҫ��������ҵID
		String[] ids = request.getParameterValues("checkbox2");
		List<Industry> list = is.exportExcel(ids);
		
		//��һ��������һ��webbook,��Ӧһ��excel�ļ�
		HSSFWorkbook wb = new HSSFWorkbook();
		 
		 //�ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
		 HSSFSheet sheet = wb.createSheet("��ҵ��һ");
	     // ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
		 HSSFRow row = sheet.createRow(0);
		 
        //����һ�����еĸ�ʽ
		 HSSFCellStyle style = wb.createCellStyle();
		 style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		 // ���Ĳ���������Ԫ�񣬲���ֵ��ͷ ���ñ�ͷ����
	     HSSFCell cell = row.createCell(0);
	     cell.setCellValue("���");
	     cell.setCellStyle(style);
	     
	     cell = row.createCell(1);
	     cell.setCellValue("����");
	     cell.setCellStyle(style);
	     
	     cell = row.createCell(2);
	     cell.setCellValue("����");
	     cell.setCellStyle(style);
	     
	     cell = row.createCell(3);
	     cell.setCellValue("�Ƿ��Ƽ�");
	     cell.setCellStyle(style);
	     
	     cell = row.createCell(4);
	     cell.setCellValue("����ʱ��");
	     cell.setCellStyle(style);
	     
	     cell = row.createCell(5);
	     cell.setCellValue("����");
	     cell.setCellStyle(style);
	     
	     for(int i=0; i<list.size(); i++){
	    	 
	    	 //������
	    	 row = sheet.createRow(i+1);
	    	 Industry indu = list.get(i);
	    	 //������Ԫ�񲢸�ֵ
	    	 row.createCell(0).setCellValue(indu.getIy_id());
	    	 row.createCell(1).setCellValue(indu.getIy_other1());
	    	 row.createCell(2).setCellValue(indu.getIy_title());
	    	
	    	 if(indu.getIy_state()==1){
    	    	 row.createCell(3).setCellValue("��");
	    	 }else{
	    		 row.createCell(3).setCellValue("��");
	    	 }
	    
	    	 row.createCell(4).setCellValue(indu.getIy_updatetime());
	    	 row.createCell(5).setCellValue(indu.getIy_content());
	    
	    	 
	     }
	     
	     //�����������ļ��浽ָ��λ��
//	     FileOutputStream fout = new FileOutputStream("e:/abc/stu.xls");
//	     wb.write(fout);
//	     fout.close();
	     
	     //ֱ�����ظ��û�
	        
			//������Ӧ����Ϊһ�������ص��ļ�
			response.setContentType("application/x-msdownload");
			//���������ļ����ļ���
			String file = URLEncoder.encode("��ҵ����.xls","utf-8");
			//������Ӧͷ�ļ�����
			response.addHeader("Content-DIsposition", "attachment; filename=\""
					+ file + "\"");
			//�����
			ServletOutputStream out = response.getOutputStream();
	
			//���ļ�������ͻ���
			wb.write(out);
			
			out.close();
			
	}

	//��ѡɾ��
	private void deleteAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//��ñ�ѡ����ҵID,�����ַ���������
		String[] id = request.getParameterValues("checkbox2");
		int num = is.deleteAll(id);
		if( num>0){
			this.show(request, response);
		}
		
	}

	//��ҵ����
	private void addIndu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("iy_title");
		/*int userid = Integer.parseInt(request.getParameter("iy_userId"));*/
		String content = request.getParameter("iy_content");
		int state = Integer.parseInt(request.getParameter("iy_state"));
		
		Industry indu = new Industry();
		indu.setIy_title(title);
		indu.setIy_state(state);
		indu.setIy_content(content);
		//��ȡ��ǰʱ��
		//indu.setIy_updatetime(new java.sql.Date(new java.util.Date().getTime()).toString());
		indu.setIy_updatetime(new java.sql.Timestamp(new java.util.Date().getTime()).toString());
		//System.out.println(indu.getIy_updatetime());
		//indu.setIy_userId(userid);
		
		int num = is.addIndu(indu);
		if( num>0){
			this.show(request, response);
		}
	}

	//�첽�޸�״̬���Ƿ��Ƽ�
	private void ajaxState(HttpServletRequest request,
			HttpServletResponse response) {
		int iy_id=Integer.parseInt(request.getParameter("iy_id"));
		int iy_state = is.lookIndu(iy_id).getIy_state();
		//����
		//System.out.println("Ҫ�޸ĵ�id"+iy_id+"��ǰ״̬Ϊ��"+iy_state);
		if(iy_state==1){
		   is.ajaxState(iy_id,0);
		}else{
		   is.ajaxState(iy_id,1);
		}
	}

	//����ɾ������
	private void deleteIndu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("id"+request.getParameter("iy_id"));
		int iy_id=Integer.parseInt(request.getParameter("iy_id"));
		//System.out.println("Ҫɾ����id"+iy_id);
		int num = is.deleteIndu(iy_id);
	    if(num>0){
	    	this.show(request, response);
	    }
	}

	//�༭�������޸���ҵ����
	private void updateIndu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		int iy_id = Integer.parseInt(request.getParameter("iy_id"));
		String iy_content = request.getParameter("iy_content");
		int iy_state = Integer.parseInt(request.getParameter("iy_state"));
		//���
		//System.out.println("id"+iy_id+"---����"+iy_content+"---״̬"+iy_state);
	    int num = is.updateIndu(iy_id,iy_content,iy_state);
	    if(num>0){
	    	this.show(request, response);
	    }
	}

	//��ҵ�༭ҳ��չʾ���൱�ڲ鿴������ʱ������һ����������
	private void editIndu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		int iy_id = Integer.parseInt(request.getParameter("iy_id"));
		Industry industry = is.lookIndu(iy_id);
		request.setAttribute("industry", industry);
		request.getRequestDispatcher("houtai/pages/publicityManage/classManage/edit.jsp").forward(request, response);
		
	}

	//�鿴����
	private void lookIndu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iy_id = Integer.parseInt(request.getParameter("iy_id"));
		//System.out.println("id=="+iy_id);
		Industry industry = is.lookIndu(iy_id);
		//System.out.println("id="+iy_id+"   title="+industry.getIy_title());
		request.setAttribute("industry", industry);
		request.getRequestDispatcher("houtai/pages/publicityManage/classManage/lookImpl.jsp").forward(request, response);
	}

	//ģ����ѯ
	private void mohuSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String iy_title = new String(request.getParameter("iy_title").getBytes("ISO-8859-1"),"utf-8");
		String iy_updatetime = new String(request.getParameter("iy_updatetime").getBytes("ISO-8859-1"),"utf-8");
		String iy_state = new String(request.getParameter("iy_state").getBytes("ISO-8859-1"),"utf-8");
		
		//���
		//System.out.println(iy_title+"---"+iy_updatetime+"---"+iy_state);
		
		if((iy_title==null||iy_title.length()==0)&&(iy_updatetime==null||iy_updatetime.length()==0)&&(iy_state==null||iy_state.length()==0)){
			this.show(request, response);
		}else{
			//ҳ���ʼ��Ϊ��һҳ��ÿҳ5��
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
			//System.out.println("��ǰҳ������"+pi.getPagenum());
			//��ѯ�������µ�������
			int count = is.moHuSearchGetCount(iy_title,iy_updatetime,iy_state);
			//����
			//System.out.println("��ǰ�����µ���������"+count);
			
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

	// ���д��������б��ҳչʾ
	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ҳ���ʼ��Ϊ��һҳ��ÿҳ5��
		PageInfo pi = new PageInfo();
		pi.setPagenum(1);
		pi.setPagesize(5);

		// ������ǵ�һ�η��ʣ����µ�ǰҳ��
		if (request.getParameter("page") != null && request.getParameter("page").length()>0) {
			pi.setPagenum(Integer.parseInt(request.getParameter("page")));
		}

		// �ж��Ƿ���һҳ���˵�һҳ
		if (pi.getPagenum() < 1) {
			pi.setPagenum(1);
		}
		// �ж��Ƿ���һҳ���˾�ͷ����Ҫ�Ȳ�ѯ��������һ���ܲ����������Ϣ
		int count = is.getCount();
		// ���ò�ѯ������
		pi.setTotalcount(count);
		// ������ҳ��
		pi.setTotalpage((count + pi.getPagesize() - 1) / pi.getPagesize());
		// �����ǰҳ�������ڲ�ѯ��ҳ������ֵΪ���ҳ����
		if (pi.getPagenum() > pi.getTotalpage()) {
			pi.setPagenum(pi.getTotalpage());
		}
		
       
//		System.out.println("��ǰҳ��"+pi.getPagenum());
//		System.out.println("��ҳ����"+pi.getPagesize());
//		System.out.println("������"+pi.getTotalcount());
//		System.out.println("��ҳ��"+pi.getTotalpage());
		//��ҳȫ��չʾ
		List<Industry> list = is.show(pi);
//		for(Industry d : list){
//			System.out.println(d.getIy_title());
//		}
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("houtai/pages/publicityManage/classManage/index.jsp").forward(request, response);
	
	}
}

