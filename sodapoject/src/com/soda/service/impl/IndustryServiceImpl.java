package com.soda.service.impl;
import java.util.List;

import com.soda.dao.IndustryDao;
import com.soda.dao.impl.IndustryDaoImpl;
import com.soda.entity.Industry;
import com.soda.dao.IndustryDao;
import com.soda.dao.impl.IndustryDaoImpl;
import com.soda.entity.Industry;
import com.soda.service.*;
import com.soda.util.PageInfo;


public class IndustryServiceImpl implements IndustryService{

	
	private IndustryDao id=new IndustryDaoImpl();
	
	@Override
	public Industry selectIndustryById(int iy_id) {
		// TODO Auto-generated method stub
		return id.selectIndustryById(iy_id);
	}

	

	@Override
	public int moHuSearchGetCount(String iy_title, String iy_updatetime,
			String iy_state) {
		
		return id.moHuSearchGetCount(iy_title,  iy_updatetime, iy_state);
	}

	@Override
	public List<Industry> moHuSearch(String iy_title,
			String iy_updatetime, String iy_state, PageInfo pi) {
		// TODO Auto-generated method stub
		return id.moHuSearch( iy_title, iy_updatetime,  iy_state,  pi);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return id.getCount();
	}

	@Override
	public List<Industry> show(PageInfo pi) {
		// TODO Auto-generated method stub
		return id.show(pi);
	}

	@Override
	public Industry lookIndu(int iy_id) {
		// TODO Auto-generated method stub
		return id.lookIndu(iy_id);
	}

	@Override
	public int updateIndu(int iy_id, String iy_content, int iy_state) {
		// TODO Auto-generated method stub
		return id.updateIndu(iy_id,iy_content,iy_state);
	}

	@Override
	public int deleteIndu(int iy_id) {
		// TODO Auto-generated method stub
		return id.deleteIndu(iy_id);
	}

	@Override
	public void ajaxState(int iy_id,int state) {
		// TODO Auto-generated method stub
		id.ajaxState(iy_id,state);
	}

	@Override
	public int addIndu(Industry indu) {
		// TODO Auto-generated method stub
		return id.addIndu(indu);
	}

	@Override
	public int deleteAll(String[] ids) {
		int i;
		for(i=0;i<ids.length;i++){
			int iy_id = Integer.parseInt(ids[i]);
			id.deleteIndu(iy_id);
		}
		if(i==ids.length)
		   return 1;
		else
			return 0;
	}

	@Override
	public List<Industry> exportExcel(String[] ids) {
		return id.exportExcel(ids);
	}


}

