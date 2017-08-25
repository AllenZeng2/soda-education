package com.soda.service;


import java.util.List;

import com.soda.entity.Industry;
import com.soda.util.PageInfo;


public interface IndustryService {


	Industry selectIndustryById(int iy_id);


	List<Industry> exportExcel(String[] ids);

	int deleteAll(String[] id);

	int addIndu(Industry indu);

	Industry lookIndu(int iy_id);

	void ajaxState(int iy_id, int i);

	int deleteIndu(int iy_id);

	int updateIndu(int iy_id, String iy_content, int iy_state);

	int moHuSearchGetCount(String iy_title, String iy_updatetime,
			String iy_state);

	List<Industry> moHuSearch(String iy_title, String iy_updatetime,
			String iy_state, PageInfo pi);

	int getCount();

	List<Industry> show(PageInfo pi);

}

