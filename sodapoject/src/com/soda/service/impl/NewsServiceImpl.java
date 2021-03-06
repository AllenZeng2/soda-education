package com.soda.service.impl;

import java.util.List;
import com.soda.dao.NewsDao;
import com.soda.dao.impl.NewsDaoImpl;
import com.soda.entity.ConditionNews;
import com.soda.entity.*;
import com.soda.entity.Page;
import com.soda.service.*;



public class NewsServiceImpl implements NewsService{


	private NewsDao nd=new NewsDaoImpl();
	

	public News selectNewsById(int ns_id) {
		// TODO Auto-generated method stub
		return nd.selectNewsById(ns_id);
	}
	public int DelNewsById(int id) {
		// TODO Auto-generated method stub
		return nd.DelNewsById(id) ;
	}
	@Override
	public int UpdateNewsById(int id,String content,int state) {
		// TODO Auto-generated method stub
		return nd. UpdateNewsById(id,content,state);
	}
	@Override
	public List<News> SelectNews(ConditionNews ct,Page p) {
		// TODO Auto-generated method stub
		return nd.SelectNews(ct,p);
	}
	@Override
	public int SelectCountNews(ConditionNews ct) {
		// TODO Auto-generated method stub
		return nd.SelectCountNews(ct);
	}
	@Override
	public News SelectNewsByid(int id) {
		// TODO Auto-generated method stub
		return nd.SelectNewsByid(id);
	}
	@Override
	public int AddNews(String title,String author,int num,int state,String content) {
		// TODO Auto-generated method stub
		return nd.AddNews(title,author,num,state,content);
	}
	@Override
	public int updateNewsById(int id,int state) {
		// TODO Auto-generated method stub
		return nd.updateNewsById(id,state);
	}
	@Override
	public int updateStatusById(int id) {
		// TODO Auto-generated method stub
		return nd.updateStatusById(id);
	}
	@Override
	public News getNewsWithUser(int parseInt) {
		// TODO Auto-generated method stub
		return nd.getNewsWithUser(parseInt);
	}
	@Override
	public String getNewsName(int userId) {
		// TODO Auto-generated method stub
		return nd.getNewsName( userId);
	}

}

