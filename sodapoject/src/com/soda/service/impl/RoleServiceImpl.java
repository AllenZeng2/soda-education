package com.soda.service.impl;

import java.util.List;

import com.soda.dao.RoleDao;
import com.soda.dao.impl.RoleDaoImpl;
import com.soda.entity.ConditionInfo;
import com.soda.entity.Fmenu;
import com.soda.entity.Role;
import com.soda.service.*;



public class RoleServiceImpl implements RoleService{
	private RoleDao rd=new RoleDaoImpl();
	@Override
	public Integer getTotalPages(ConditionInfo cf) {
		// TODO Auto-generated method stub
		return rd.getTotalPages(cf);
	}
	//全查
	@Override
	public List<Role> selectRoles(ConditionInfo cf) {
		// TODO Auto-generated method stub
		return rd.selectRoles(cf);
	}
	
	//根据id单查
	@Override
	public Role selectRoleById(int parseInt) {
		// TODO Auto-generated method stub
		return rd.selectRoleById(parseInt);
	}
	
	@Override
	public Fmenu addMenuToFmenu(Integer fmen_id, int parseInt) {
		// TODO Auto-generated method stub
		return rd.addMenuToFmenu(fmen_id,parseInt);
	}
	
	@Override
	public void updateStateOfRole(int parseInt, int num) {
		// TODO Auto-generated method stub
		if(num==1||num==0){
			rd.updateStateOfRole(parseInt,num);
		}
		if(num==2){
			rd.deleteRole(parseInt);
		}
	}
	
	@Override
	public void addRole(Role role) {
		rd.addRole(role);
		
	}
	
	@Override
	public Role selectRoleByName(String ro_name) {
		// TODO Auto-generated method stub
		return rd.selectRoleByName(ro_name);
	}
	
	@Override
	public void addFmenuOfRole(int fm_id, int re_id) {
		// TODO Auto-generated method stub
		rd.addFmenuOfRole(fm_id, re_id);
	}

	@Override
	public void addMenuOfRole(int re_id, int mu_id) {
		// TODO Auto-generated method stub
		rd.addMenuOfRole(re_id, mu_id);
	}
	
	@Override
	public void editRole(Role role) {
		// TODO Auto-generated method stub
		rd.editRole(role);
	}
	
	@Override
	public void deleteMenus(int parseInt) {
		// TODO Auto-generated method stub
		rd.deleteMenus(parseInt);
	}
	
	@Override
	public void deleteFmenus(int parseInt) {
		// TODO Auto-generated method stub
		rd.deleteFmenus(parseInt);
	}
	
	@Override
	public List<Role> selectRoleForAdd() {
		// TODO Auto-generated method stub
		return rd.selectRoleForAdd();
	}
	
}

