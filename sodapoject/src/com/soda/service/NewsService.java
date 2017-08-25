package com.soda.service;
import java.util.List;
import java.util.concurrent.locks.Condition;

import com.soda.entity.ConditionNews;
import com.soda.entity.News;
import com.soda.entity.Page;

public interface NewsService {



	News selectNewsById(int ns_id);
	int DelNewsById(int id);

	int UpdateNewsById(int id,String content,int state);

	List<News> SelectNews(ConditionNews ct,Page p);

	int SelectCountNews(ConditionNews ct);

	News SelectNewsByid(int id);

	

	int updateNewsById(int id, int state);

	int updateStatusById(int id);

	News getNewsWithUser(int parseInt);

	int AddNews(String title, String author, int num, int state, String content);

	String getNewsName(int userId);
}

