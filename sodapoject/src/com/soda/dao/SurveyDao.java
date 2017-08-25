package com.soda.dao;


import java.util.List;

import com.soda.entity.Student;
import com.soda.entity.Survey;


public interface SurveyDao {

	List<Survey> selectSurvey();

	Survey getSurvey(int i);

	int updateContent(String content,int id);

	Survey getSurveyWithUser(int i);

	int insertSurvey(String content);



}
