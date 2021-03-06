package com.soda.dao;

import java.util.List;

import com.soda.entity.ConditionInfo;
import com.soda.entity.Fmenu;
import com.soda.entity.Menu;
import com.soda.entity.Role;

public interface MenuDao {

	Integer getTotalPages(ConditionInfo cf);

	List<Menu> selectMenus(ConditionInfo cf);

	//void updateStateOfMenu(int id);

	void updateStatusOfMenu(int id);

	Menu selectMenuById(int id);

	void updateFmenuOfMenu(Menu mu);

	void updateMenu(Menu mu);

	Menu selectMenuByName(String name);

	void addMenu(Menu mu);

	void addFmenuOfMenu(Menu menu);

	void updateStateOfMenu(int id, int num);

	List<Fmenu> selecFmenus();

	List<Menu> selectMenusOfFmenu(int id);

	List<Menu> selectAllMenus();

	void addFmenu(String mu_name);

	Fmenu selectFmenuByName(String name);

}
