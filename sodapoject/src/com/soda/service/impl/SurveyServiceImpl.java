package com.soda.service.impl;
import com.soda.dao.SurveyDao;
import com.soda.dao.impl.SurveyDaoImpl;
import com.soda.entity.Survey;
import java.util.List;

import com.soda.dao.SurveyDao;
import com.soda.dao.impl.SurveyDaoImpl;
import com.soda.entity.Survey;
import com.soda.service.*;


public class SurveyServiceImpl implements SurveyService{

	
	private SurveyDao sd=new SurveyDaoImpl();
	
	@Override
	public List<Survey> selectSurvey() {
		// TODO Auto-generated method stub
		return sd.selectSurvey();
	}
	
	
	
	public Survey getSurvey(int i) {
		return sd.getSurvey(i);
	}

	@Override
	public int updateContent(String content,int id) {
		// TODO Auto-generated method stub
		return sd.updateContent(content,id);
	}

	@Override
	public Survey getSurveyWithUser(int i) {
		// TODO Auto-generated method stub
		return sd.getSurveyWithUser(i);
	}

	@Override
	public int insertSurvey(String content) {
		// TODO Auto-generated method stub
		return 0;
	}

}

