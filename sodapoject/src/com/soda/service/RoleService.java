package com.soda.service;

import java.util.List;

import com.soda.entity.ConditionInfo;
import com.soda.entity.Fmenu;
import com.soda.entity.Role;

public interface RoleService {

	Integer getTotalPages(ConditionInfo cf);

	List<Role> selectRoles(ConditionInfo cf);

	Role selectRoleById(int parseInt);

	Fmenu addMenuToFmenu(Integer fmen_id, int parseInt);

	void updateStateOfRole(int parseInt, int parseInt2);

	void addRole(Role role);

	Role selectRoleByName(String ro_name);

	void addFmenuOfRole(int fm_id, int re_id);

	void addMenuOfRole(int re_id, int mu_id);

	void editRole(Role role);

	void deleteMenus(int parseInt);

	void deleteFmenus(int parseInt);

	List<Role> selectRoleForAdd();
}

