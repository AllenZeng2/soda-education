package com.soda.service;

import java.util.List;

import com.soda.entity.ConditionInfo;
import com.soda.entity.Fmenu;
import com.soda.entity.Menu;
import com.soda.entity.Role;

public interface MenuService {

	Integer getTotalPages(ConditionInfo cf);

	List<Menu> selectMenus(ConditionInfo cf);

	void updateStateOfMenu(int parseInt, int parseInt2);

	Menu selectMenuById(int parseInt);

	void updateMenu(Menu mu);

	void updateFmenuOfMenu(Menu mu);

	Menu selectMenuByName(String name);

	void addMenu(Menu mu);

	void addFmenuOfMenu(Menu menu);

	List<Fmenu> selecFmenus();

	List<Menu> selectMenusOfFmenu(int id);

	List<Menu> selectAllMenus();

	void addFmenu(String mu_name);

	Fmenu selectFmenuByName(String name);

}

