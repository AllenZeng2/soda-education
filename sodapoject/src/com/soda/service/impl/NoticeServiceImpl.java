package com.soda.service.impl;


import java.util.List;

import com.soda.dao.NoticeDao;
import com.soda.dao.impl.NoticeDaoImpl;
import com.soda.entity.Notice;
import com.soda.entity.PageInfo;
import com.soda.service.NoticeService;



public class NoticeServiceImpl implements NoticeService{

	
	private NoticeDao nd=new NoticeDaoImpl();
	
	@Override
	public Notice selectNoticeById(int ne_id) {
		// TODO Auto-generated method stub
		return nd.selectNoticeById(ne_id);
	}


	public List<Notice> conditionSelect(Notice notice, PageInfo pi) {
		// TODO Auto-generated method stub
		return nd.conditionSelect(notice,pi);
	}
	@Override
	public int conditionCount(Notice notice) {
		// TODO Auto-generated method stub
		return nd.conditionCount(notice);
	}
	@Override
	public int deleteNotice(int ne_id) {
		// TODO Auto-generated method stub
		return nd.deleteNotice(ne_id);
	}
	@Override
	public Notice getNoticeWithId(int ne_id) {
		// TODO Auto-generated method stub
		return nd.etNoticeWithId(ne_id);
	}
	@Override
	public int submitNotice(Notice notice) {
		// TODO Auto-generated method stub
		return nd.submitNotice(notice);
	}
	@Override
	public int addNotice(Notice notice) {
		// TODO Auto-generated method stub
		return nd.addNotice(notice);
	}
}

