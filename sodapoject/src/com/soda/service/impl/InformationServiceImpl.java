package com.soda.service.impl;


import com.soda.dao.InformationDao;
import com.soda.dao.impl.InformationDaoImpl;
import com.soda.entity.Information;

import java.util.List;
import com.soda.entity.News;
import com.soda.entity.PageInfo;

import com.soda.service.*;

public class InformationServiceImpl implements InformationService {


	private InformationDao id = new InformationDaoImpl();
	public Information selectInformationById(int in_id) {
		// TODO Auto-generated method stub
		return id.selectInformationById(in_id);
	}
	public List<Information> getinformation(Information in) {
		// TODO Auto-generated method stub
		return id.getinformation(in);
	}

	public List<Information> conditionSelect(Information information, PageInfo pi) {
		// TODO Auto-generated method stub
		return id.conditionSelect(information, pi);
	}

	public int conditionCount(Information information) {
		// TODO Auto-generated method stub
		return id.conditionCount(information);
	}

	public int deleteInformation(int ns_id) {
		// TODO Auto-generated method stub
		return id.deleteInformation(ns_id);
	}

	public int updateState(int in_state, int in_id) {
		// TODO Auto-generated method stub
		return id.updateState(in_state,in_id);
	}

	public Information getInformationWithId(int ns_id) {
		// TODO Auto-generated method stub
		return id.getInformationWithId(ns_id);
	}

	public int submitInformation(Information information) {
		// TODO Auto-generated method stub
		return id.submitInformation(information);
	}

	public int addInformation(Information information) {
		// TODO Auto-generated method stub
		return id.addInformation(information);
	}

}
