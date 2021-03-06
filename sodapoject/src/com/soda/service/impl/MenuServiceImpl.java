package com.soda.service.impl;

import java.util.List;

import com.soda.dao.MenuDao;
import com.soda.dao.impl.MenuDaoImpl;
import com.soda.entity.ConditionInfo;
import com.soda.entity.Fmenu;
import com.soda.entity.Menu;
import com.soda.service.*;



public class MenuServiceImpl implements MenuService{
	private MenuDao md=new MenuDaoImpl();
	
	@Override
	public void addFmenu(String mu_name) {
		// TODO Auto-generated method stub
		md.addFmenu(mu_name);
	}
	@Override
	public List<Menu> selectAllMenus() {
		// TODO Auto-generated method stub
		return md.selectAllMenus();
	}
	@Override
	public List<Menu> selectMenusOfFmenu(int id) {
		// TODO Auto-generated method stub
		return md.selectMenusOfFmenu(id);
	}
	@Override
	public List<Fmenu> selecFmenus() {
		// TODO Auto-generated method stub
		return md.selecFmenus();
	}
	@Override
	public Integer getTotalPages(ConditionInfo cf) {
		// TODO Auto-generated method stub
		return md.getTotalPages(cf);
	}
	
	@Override
	public List<Menu> selectMenus(ConditionInfo cf) {
		// TODO Auto-generated method stub
		return md.selectMenus(cf);
	}
	
	@Override
	public void updateStateOfMenu(int id, int num) {
		// TODO Auto-generated method stub
		if(num==1||num==0){
			md.updateStateOfMenu(id, num);
		}
		if(num==2){
			md.updateStatusOfMenu(id);
		}
	}
	
	@Override
	public Menu selectMenuById(int id) {
		// TODO Auto-generated method stub
		return md.selectMenuById(id);
	}
	
	@Override
	public void updateFmenuOfMenu(Menu mu) {
		// TODO Auto-generated method stub
		md.updateFmenuOfMenu(mu);
	}
	
	@Override
	public void updateMenu(Menu mu) {
		// TODO Auto-generated method stub
		md.updateMenu(mu);
	}
	@Override
	public Menu selectMenuByName(String name) {
		// TODO Auto-generated method stub
		return md.selectMenuByName(name);
	}
	@Override
	public void addMenu(Menu mu) {
		// TODO Auto-generated method stub
		md.addMenu(mu);
	}
	@Override
	public void addFmenuOfMenu(Menu menu) {
		// TODO Auto-generated method stub
		md.addFmenuOfMenu(menu);
	}
	
	@Override
	public Fmenu selectFmenuByName(String name) {
		// TODO Auto-generated method stub
		return md.selectFmenuByName(name);
	}
}

