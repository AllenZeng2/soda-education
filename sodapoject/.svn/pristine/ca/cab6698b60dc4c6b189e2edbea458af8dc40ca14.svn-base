package com.soda.service.impl;

import java.util.List;

import com.soda.dao.ShopcarDao;
import com.soda.dao.impl.ShopcarDaoImpl;
import com.soda.entity.Course;
import com.soda.entity.PageInfo;
import com.soda.entity.Shopcar;
import com.soda.service.*;



public class ShopcarServiceImpl implements ShopcarService{
	
	private ShopcarDao sd=new ShopcarDaoImpl();
	
	@Override
	public List<Shopcar> selectNoSettlement(PageInfo pi) {
		// TODO Auto-generated method stub
		return sd.selectNoSettlement(pi);
	}
	
	@Override
	public List<Shopcar> selectMohuNoSettlementCourse(Shopcar shopcar,
			PageInfo pi) {
		// TODO Auto-generated method stub
		return sd.selectMohuNoSettlementCourse(shopcar, pi);
	}

	
}

