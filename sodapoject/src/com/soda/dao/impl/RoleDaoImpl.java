package com.soda.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soda.dao.BaseDao;
import com.soda.dao.RoleDao;
import com.soda.entity.ConditionInfo;
import com.soda.entity.Fmenu;
import com.soda.entity.Menu;
import com.soda.entity.Role;
import com.soda.entity.User;

public class RoleDaoImpl extends BaseDao implements RoleDao{
	
	
	@Override
	public List<Role> selectRoleForAdd() {
		try {
			getConn();
			StringBuffer sql=new StringBuffer("SELECT * FROM role");		
			res=ps.executeQuery();
			List<Role> list=new ArrayList<Role>();
			
			while(res.next()){
				Role r=new Role();
				r.setRe_id(res.getInt(1));
				r.setRe_name(res.getString(2));
				r.setRe_state(res.getInt(3));
				r.setRe_remark(res.getString(4));
				list.add(r);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		return null;
	}
	
	//删除主菜单
	@Override
	public void deleteFmenus(int p) {
		try {
			getConn();
			String sql="DELETE FROM role_fmenu WHERE re_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, p);
			ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);	
		}
		
	}
	//删除子菜单
	public void deleteMenus(int p) {
		try {
			getConn();
			String sql="DELETE FROM role_menu WHERE role_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, p);
			ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);	
		}
		
		
	}
	
	
	@Override
	public void editRole(Role role) {
		try {
			getConn();
			String sql="UPDATE role SET re_name=?,re_state=?,re_remark=? WHERE re_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, role.getRe_name());
			ps.setInt(2, role.getRe_state());
			ps.setString(3,role.getRe_remark());
			ps.setInt(4, role.getRe_id());
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);	
		}
		
	}
	
	@Override
	public void addMenuOfRole(int re_id, int mu_id) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql="INSERT INTO role_menu VALUES(?,?,null,null)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, re_id);
			ps.setInt(2, mu_id);
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);	
		}
	}
	
	
	@Override
	public void addFmenuOfRole(int fm_id, int re_id) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql="INSERT INTO role_fmenu VALUES(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, re_id);
			ps.setInt(2, fm_id);
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
	}
	
	//根据名字查角色
	@Override
	public Role selectRoleByName(String ro_name) {
				try {
					getConn();
					String sql="select * from role where re_name=?";
					ps=conn.prepareStatement(sql);
					ps.setString(1, ro_name);
					res=ps.executeQuery();
					if(res.next()){
						Role r=new Role(res.getInt(1),res.getString(2),res.getInt(3),res.getString(4),res.getInt(5));
						return r;
					}
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					close(conn, ps, res);
					
				}
		return null;
	}
	
	
	//添加角色
	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
				try {
					getConn();
					String sql="INSERT INTO role VALUES(NULL,?,?,?,1,NULL,NULL)";
					ps=conn.prepareStatement(sql);
					ps.setString(1, role.getRe_name());
					ps.setInt(2, role.getRe_state());
					ps.setString(3, role.getRe_remark());
					ps.executeUpdate();
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					close(conn, ps, res);
					
				}
		
	}
	

	//删除
	@Override
	public void deleteRole(int p) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql="UPDATE role SET re_status=0 WHERE re_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, p);
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
	}
	
	//禁用
	@Override
	public void updateStateOfRole(int id, int num) {
		try {
			getConn();
			String sql="UPDATE role SET re_state=? WHERE re_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, id);
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		
	}
	//单个详情
	@Override
	public Role selectRoleById(int parseInt) {
		try {
			getConn();
			String sql=new String("SELECT * FROM role ro INNER JOIN role_menu rm ON ro.re_id=rm.role_id INNER JOIN menu m ON rm.menu_id=m.mu_id INNER JOIN menu_fmenu mf ON m.mu_id=mf.mu_id INNER JOIN fmenu f ON f.fme_id=mf.fme_id WHERE ro.re_id=? ORDER BY f.fme_id");
			ps=conn.prepareStatement(sql);
			ps.setInt(1, parseInt);
			res=ps.executeQuery();
			Role r=null;
			List<Menu> menus=new ArrayList<Menu>();
			aa:	while(res.next()){
				if(r==null){
					r=new Role();
					r.setRe_id(res.getInt(1));
					r.setRe_name(res.getString(2));
					r.setRe_state(res.getInt(3));
					r.setRe_remark(res.getString(4));
					r.setRe_status(res.getInt(5));
				}
				while(true){
					Fmenu fm=new Fmenu();
					fm.setFmen_id(res.getInt(23));
					fm.setFme_name(res.getString(24));
					fm.setFme_remark(res.getString(25));
					fm.setFme_state(res.getInt(26));
					fm.setFme_delete(res.getInt(27));
					
					while(true){

						Menu m=new Menu();
						m.setMu_id(res.getInt(9));
						m.setMu_pid(res.getInt(13));
						m.setMu_name(res.getString(14));
						m.setMu_url(res.getString(15));
						m.setMu_remark(res.getString(16));
						m.setMu_state(res.getInt(17));
						m.setMu_status(res.getInt(18));
						r.getMenus().add(m);
						//menus.add(m);
						fm.getMenu().add(m);
						if(!res.next()){
							r.getMenus().add(m);
							r.getFmenu().add(fm);
							break;
						}
						if(res.getInt(23)!=fm.getFmen_id()){
							res.previous();
							break;
						}
					}
					
					if(!res.next()){
						
						break;
					}
					
					if(res.getInt(1)!=r.getRe_id()){
						res.previous();
						break;
					}
					r.getFmenu().add(fm);
				}
				
				
			}
			return r;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		return null;
	}
	
	
	//已经废弃的方法
	public Fmenu addMenuToFmenu(Integer fmen_id,int id) {
		try {
			getConn();
			String sql=new String("SELECT * FROM role ro INNER JOIN role_menu rm ON ro.re_id=rm.role_id INNER JOIN menu m ON rm.menu_id=m.mu_id INNER JOIN menu_fmenu mf ON m.mu_id=mf.mu_id INNER JOIN fmenu f ON f.fme_id=mf.fme_id WHERE f.fme_id=? AND ro.re_id=? ORDER BY f.fme_id");
			ps=conn.prepareStatement(sql);
			ps.setInt(1, fmen_id);
			ps.setInt(2, id);
			res=ps.executeQuery();
			Fmenu fm=new Fmenu();
			
		
		
			while(res.next()){
				Menu m=new Menu();
				m.setMu_id(res.getInt(9));
				m.setMu_pid(res.getInt(13));
				m.setMu_name(res.getString(14));
				m.setMu_url(res.getString(15));
				m.setMu_remark(res.getString(16));
				m.setMu_state(res.getInt(17));
				m.setMu_status(res.getInt(18));
				fm.getMenu().add(m);
				
			}
			return fm;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		return null;
	}
	
	
	
	
	//全查
	@Override
	public List<Role> selectRoles(ConditionInfo cf) {
		try {
			getConn();
			StringBuffer sql=new StringBuffer("SELECT * FROM role WHERE 1=1 and re_status=1");
			
			if(cf.getLoginName()!=null&&cf.getLoginName().length()>0){
				sql.append(" and re_name like ?");
			}
			
			if(cf.getState()==1||cf.getState()==0){
				sql.append(" and re_state=?");
			}
			sql.append(" order by re_id desc");
			sql.append(" limit ?,?");
			
			ps=conn.prepareStatement(sql.toString());
			
			int temp=1;
			if(cf.getLoginName()!=null&&cf.getLoginName().length()>0){
				ps.setString(temp, cf.getLoginName()+"%");
				temp++;
			}
			
			if(cf.getState()==1||cf.getState()==0){
				ps.setInt(temp, cf.getState());
				temp++;
			}
			
			ps.setInt(temp, cf.getItemsEveryPage()*(cf.getCurrentPage()-1));
			temp++;
			ps.setInt(temp, cf.getItemsEveryPage());
		
			
			res=ps.executeQuery();
			List<Role> list=new ArrayList<Role>();
			
			while(res.next()){
				Role r=new Role();
				r.setRe_id(res.getInt(1));
				r.setRe_name(res.getString(2));
				r.setRe_state(res.getInt(3));
				r.setRe_remark(res.getString(4));
				list.add(r);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		return null;
	}
	
	
	@Override
	public Integer getTotalPages(ConditionInfo cf) {
		try {
			getConn();
			StringBuffer sql=new StringBuffer("SELECT count(1) FROM role WHERE 1=1 and re_status=1");

			if(cf.getLoginName()!=null&&cf.getLoginName().length()>0){
				sql.append(" and re_name like ?");
			}

			if(cf.getState()==1||cf.getState()==0){
				sql.append(" and re_state=?");
			}
			
			
			ps=conn.prepareStatement(sql.toString());
			
			int temp=1;
			if(cf.getLoginName()!=null&&cf.getLoginName().length()>0){
				ps.setString(temp, cf.getLoginName()+"%");
				temp++;
			}

			if(cf.getState()==1||cf.getState()==0){
				ps.setInt(temp, cf.getState());
				temp++;
			}
			
			res=ps.executeQuery();
			//List<User> list=new ArrayList<User>();
			if(res.next()){
				return res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		return 0;
	}
	
	
}
