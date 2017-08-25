package com.soda.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soda.dao.BaseDao;
import com.soda.dao.MenuDao;
import com.soda.entity.ConditionInfo;
import com.soda.entity.Fmenu;
import com.soda.entity.Menu;
import com.soda.entity.Role;

public class MenuDaoImpl extends BaseDao implements MenuDao{
	
	
	@Override
	public void addFmenu(String mu_name) {
		try {
			getConn();
			String sql="INSERT INTO fmenu VALUES(null,?,null,1,1)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, mu_name);
			ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		
	}
	
	@Override
	public List<Menu> selectMenusOfFmenu(int id) {
		try {
			getConn();
			String sql="SELECT * FROM fmenu f INNER JOIN menu_fmenu mf ON f.fme_id=mf.fme_id INNER JOIN menu m ON mf.mu_id=m.mu_id WHERE f.fme_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			res=ps.executeQuery();
			List<Menu> list=new ArrayList<Menu>();
			while(res.next()){
				Menu me=new Menu();
				me.setMu_id(res.getInt(8));
				me.setMu_name(res.getString(10));
				list.add(me);
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
	//查询父菜单
	@Override
	public List<Fmenu> selecFmenus() {
		try {
			getConn();
			String sql="SELECT * FROM fmenu";
			ps=conn.prepareStatement(sql);
			res=ps.executeQuery();
			List<Fmenu> list=new ArrayList<Fmenu>();
			while(res.next()){
				Fmenu fm=new Fmenu();
				fm.setFmen_id(res.getInt(1));
				fm.setFme_name(res.getString(2));
				fm.setFme_remark(res.getString(3));
				fm.setFme_delete(res.getInt(5));
				fm.setFme_state(res.getInt(4));
				list.add(fm);
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
	
	//给子菜单添加父菜单
	@Override
	public void addFmenuOfMenu(Menu menu) {
		try {
			getConn();
			String sql="INSERT INTO menu_fmenu VALUES(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, menu.getMu_pid());
			ps.setInt(2, menu.getMu_id());
			ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		
	}
	//添加
	@Override
	public void addMenu(Menu mu) {
		try {
			getConn();
			String sql="INSERT INTO menu VALUES(NULL,?,?,?,?,?,1,NULL,NULL)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mu.getMu_pid());
			ps.setString(2, mu.getMu_name());
			ps.setString(3, mu.getMu_url());
			ps.setString(4, mu.getMu_remark());
			ps.setInt(5, mu.getMu_state());
			ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		
	}
	//查询父菜单by name
	@Override
	public Fmenu selectFmenuByName(String name) {
		try {
			getConn();
			String sql="SELECT * FROM fmenu WHERE fme_name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			res=ps.executeQuery();
			if(res.next()){
				Fmenu mu=new Fmenu();
				mu.setFmen_id(res.getInt(1));
				mu.setFme_name(res.getString(3));
				mu.setFme_state(res.getInt(4));
				return mu;
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}		
		return null;
	}
	
	//查询子菜单by name
	@Override
	public Menu selectMenuByName(String name) {
		try {
			getConn();
			String sql="SELECT * FROM menu WHERE mu_name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			res=ps.executeQuery();
			if(res.next()){
				Menu mu=new Menu();
				mu.setMu_id(res.getInt(1));
				mu.setMu_pid(res.getInt(2));
				mu.setMu_name(res.getString(3));
				mu.setMu_state(res.getInt(6));
				return mu;
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}		
		return null;
	}
	//修改子菜单
	@Override
	public void updateMenu(Menu mu) {
		try {
			getConn();
			String sql="UPDATE menu SET mu_name=?,mu_pid=?,mu_url=?,mu_remark=?,mu_state=? WHERE mu_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,mu.getMu_name());
			ps.setInt(2, mu.getMu_pid());
			ps.setString(3,mu.getMu_url());
			ps.setString(4,mu.getMu_remark());
			ps.setInt(5,mu.getMu_state());
			ps.setInt(6, mu.getMu_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		
	}
	
	//修改子菜单的父菜单
	@Override
	public void updateFmenuOfMenu(Menu mu) {
		try {
			getConn();
			String sql="UPDATE menu_fmenu SET fme_id=? WHERE mu_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,mu.getMu_pid());
			ps.setInt(2, mu.getMu_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		
	}
	//单个id查询
	@Override
	public Menu selectMenuById(int id) {
		try {
			getConn();
			String sql="SELECT * FROM menu m INNER JOIN menu_fmenu mf ON m.mu_id=mf.mu_id INNER JOIN fmenu fm ON mf.fme_id=fm.fme_id WHERE m.mu_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			res=ps.executeQuery();
			if(res.next()){
				Menu m=new Menu(res.getInt(1),res.getInt(12),res.getString(3),res.getString(4),res.getString(5),res.getInt(6),res.getInt(7),res.getString(13),null);
				return m;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		return null;
	}
	
	//删除
	@Override
	public void updateStatusOfMenu(int id) {
		try {
			getConn();
			String sql="UPDATE menu SET mu_status=0 WHERE mu_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
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
	public void updateStateOfMenu(int id,int num) {
		try {
			getConn();
			String sql="UPDATE menu SET mu_state=? WHERE mu_id=?";
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
	
	//迷糊查询
	@Override
	public List<Menu> selectMenus(ConditionInfo cf) {
		try {
			getConn();
			StringBuffer sql=new StringBuffer("SELECT * FROM menu WHERE 1=1 and mu_status=1");
			
			if(cf.getLoginName()!=null&&cf.getLoginName().length()>0){
				sql.append(" and mu_name like ?");
			}
			
			if(cf.getState()==1||cf.getState()==0){
				sql.append(" and mu_state=?");
			}
			
			sql.append(" ORDER BY mu_id DESC");
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
			temp++;
			
			res=ps.executeQuery();
			List<Menu> list=new ArrayList<Menu>();
			
			while(res.next()){
				Menu m=new Menu();
				m.setMu_id(res.getInt(1));
				m.setMu_pid(res.getInt(2));
				m.setMu_name(res.getString(3));
				m.setMu_url(res.getString(4));
				m.setMu_state(res.getInt(6));
				m.setMu_remark(res.getString(5));
				m.setMu_status(res.getInt(7));
				list.add(m);
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

	//分页
	@Override
	public Integer getTotalPages(ConditionInfo cf) {
		try {
			getConn();
			StringBuffer sql=new StringBuffer("SELECT count(1) FROM menu WHERE 1=1 and mu_status=1");

			if(cf.getLoginName()!=null&&cf.getLoginName().length()>0){
				sql.append(" and mu_name like ?");
			}

			if(cf.getState()==1||cf.getState()==0){
				sql.append(" and mu_state=?");
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
		return null;
	}
	
	
	@Override
	public List<Menu> selectAllMenus() {
		try {
			getConn();
			String sql="SELECT * FROM menu";
			ps=conn.prepareStatement(sql);
			res=ps.executeQuery();
			List<Menu> list=new ArrayList<Menu>();
			
			while(res.next()){
				Menu m=new Menu();
				m.setMu_id(res.getInt(1));
				m.setMu_pid(res.getInt(2));
				m.setMu_name(res.getString(3));
				m.setMu_url(res.getString(4));
				m.setMu_state(res.getInt(6));
				m.setMu_remark(res.getString(5));
				m.setMu_status(res.getInt(7));
				list.add(m);
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
	
}
