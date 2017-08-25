package com.soda.dao;
import java.util.List;


import com.soda.entity.Industry;

import com.soda.util.PageInfo;
public interface IndustryDao {
	int getCount();


	Industry selectIndustryById(int iy_id);
	


	List<Industry> show(PageInfo pi);

	List<Industry> moHuSearch(String iy_title, String iy_updatetime,
			String iy_state, PageInfo pi);

	int moHuSearchGetCount(String iy_title, String iy_updatetime,
			String iy_state);

	Industry lookIndu(int iy_id);

	int updateIndu(int iy_id, String iy_content, int iy_state);

	int deleteIndu(int iy_id);

	void ajaxState(int iy_id,int state);

	int addIndu(Industry indu);

	List<Industry> exportExcel(String[] ids);

}
