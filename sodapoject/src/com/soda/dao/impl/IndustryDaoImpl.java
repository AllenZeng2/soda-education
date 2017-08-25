package com.soda.dao.impl;


import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.soda.dao.BaseDao;
import com.soda.dao.IndustryDao;

import com.soda.entity.Industry;
import com.soda.entity.Information;
import com.soda.entity.User;

import com.soda.util.PageInfo;

public class IndustryDaoImpl extends BaseDao implements IndustryDao{
	
	@Override
	public Industry selectIndustryById(int iy_id) {
		try {
			getConn();
			String sql = "SELECT * FROM industry iy INNER JOIN `user` ur ON iy_userId=ur_id WHERE iy_state=1 AND iy_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, iy_id);
			res = ps.executeQuery();
			if (res.next()) {
				
				Industry industry=new Industry();
				User u=new User();
				
				industry.setIy_id(res.getInt(1));
				industry.setIy_title(res.getString(2));
				industry.setIy_content(res.getString(3));
				industry.setIy_state(res.getInt(5));
				industry.setIy_updatetime(res.getString(6));
				industry.setIy_status(res.getInt(7));
				
				industry.setIy_other1(res.getString("ur_name"));
				
				return industry;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "select count(1) from industry where iy_status = 1";
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();
			if(res.next()){
				return res.getInt(1);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			close(conn, ps, res);
		}
		return 0;
	}

	@Override
	public List<Industry> show(PageInfo pi) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "SELECT * FROM industry where iy_status=1 ORDER BY iy_id desc LIMIT ?,? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (pi.getPagenum()-1)*pi.getPagesize());
			ps.setInt(2, pi.getPagesize());
			res = ps.executeQuery();
			List<Industry> list = new ArrayList<Industry>();
			while(res.next()){
			    Industry i = new Industry();
			    i.setIy_id(res.getInt("iy_id"));
			    i.setIy_title(res.getString("iy_title"));
			    
			    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			    Time date = res.getTime("iy_updatetime");
			    //System.out.println("date"+date);
			    String updatetime=sdf.format(new Date(date.getTime()));
			    i.setIy_updatetime(updatetime);
			    //System.out.println(i.getIy_updatetime());
			    
			    i.setIy_state(res.getInt("iy_state"));
			    
			    list.add(i);
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
	public List<Industry> moHuSearch(String iy_title, String iy_updatetime,
			String iy_state, PageInfo pi) {
		// TODO Auto-generated method stub
		try {
			getConn();
			StringBuffer sql = new StringBuffer("select * from industry where iy_status=1 ");
			
			if( iy_title!=null && iy_title.length()>0){
			   sql.append(" and iy_title like ?");	
			}
			if(iy_updatetime!=null && iy_updatetime.length()>0){
				sql.append(" and iy_updatetime like ?");
			}
			if(iy_state!=null && iy_state.length()>0){
				if(!("全部".equals(iy_state))){
					sql.append(" and iy_state=?");
				}
			}
			sql.append(" order by iy_id desc limit ?,?");
			
			ps = conn.prepareStatement(sql.toString());
			
			int param=1;
			if( iy_title!=null && iy_title.length()>0){
				  ps.setString(param, "%"+iy_title+"%");
				  param++;
				}
				if(iy_updatetime!=null && iy_updatetime.length()>0){
				  ps.setString(param, "%"+iy_updatetime+"%");
				  param++;
				}
				if(iy_state!=null && iy_state.length()>0){
					if(!("全部".equals(iy_state))){
						if("是".equals(iy_state)){
							ps.setInt(param, 1);
							param++;
						}
						else if("否".equals(iy_state)){
							ps.setInt(param, 0);
							param++;
						}
					}
				}
				//检查
				//System.out.println("分页页码："+pi.getPagenum());
				//System.out.println("分页"+(pi.getPagenum()-1)*pi.getPagesize());
				//当查询0条记录时；
				if(pi.getPagenum()<=0){
					ps.setInt(param, 0);
					param++;
				}else{
					ps.setInt(param, (pi.getPagenum()-1)*pi.getPagesize());
			        param++;
				}
			    //检查
			    //System.out.println("分页大小"+pi.getPagesize());
			    ps.setInt(param, pi.getPagesize());
			   // System.out.println(sql);
				res = ps.executeQuery();
				List<Industry> list = new ArrayList<Industry>();
				while(res.next()){
					Industry i = new Industry();
					i.setIy_id(res.getInt(1));
					i.setIy_title(res.getString(2));
					i.setIy_state(res.getInt(5));
					i.setIy_userId(res.getInt("iy_userId"));
					i.setIy_content(res.getString("iy_content"));
					 
				    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
				    Time date = res.getTime("iy_updatetime");
				    //System.out.println("date"+date);
					String updatetime=sdf.format(new Date(date.getTime()));
					i.setIy_updatetime(updatetime);
					
					list.add(i);
				}
				return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn,ps,res);
			
		}
		return null;
	}

	@Override
	public int moHuSearchGetCount(String iy_title, String iy_updatetime,
			String iy_state) {
		// TODO Auto-generated method stub
		try {
			getConn();
			StringBuffer sql = new StringBuffer("select count(1) from industry where iy_status=1 ");
			
			if( iy_title!=null && iy_title.length()>0){
			   sql.append(" and iy_title like ?");	
			}
			if(iy_updatetime!=null && iy_updatetime.length()>0){
				sql.append(" and iy_updatetime like ?");
			}
			if(iy_state!=null && iy_state.length()>0){
				if(!("全部".equals(iy_state))){
					sql.append(" and iy_state=?");
				}
			}
			ps = conn.prepareStatement(sql.toString());
			int param=1;
			if( iy_title!=null && iy_title.length()>0){
				  ps.setString(param, "%"+iy_title+"%");
				  param++;
				}
				if(iy_updatetime!=null && iy_updatetime.length()>0){
				  ps.setString(param, "%"+iy_updatetime+"%");
				  param++;
				}
				if(iy_state!=null && iy_state.length()>0){
					if(!("全部".equals(iy_state))){
						if("是".equals(iy_state)){
							ps.setInt(param, 1);
						}
						else if("否".equals(iy_state)){
							ps.setInt(param, 0);
						}
					}
				}
			    //System.out.println(sql);
				res = ps.executeQuery();
				
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

	@Override
	public Industry lookIndu(int iy_id) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "SELECT *,ur_name FROM industry indu INNER JOIN `user` u ON indu.iy_userId=u.ur_id WHERE iy_status=1 and iy_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, iy_id);
			res = ps.executeQuery();
			if(res.next()){
				Industry idu = new Industry();
				idu.setIy_id(res.getInt("iy_id"));
				idu.setIy_title(res.getString("iy_title"));
				idu.setIy_updatetime(res.getString("iy_updatetime"));
				idu.setIy_state(res.getInt("iy_state"));
				idu.setIy_userId(res.getInt("iy_userId"));
				idu.setIy_content(res.getString("iy_content"));
				idu.setIy_other1(res.getString("ur_name"));
			    return idu;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		return null;
	}

	@Override
	public int updateIndu(int iy_id, String iy_content, int iy_state) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "UPDATE industry SET iy_state=?,iy_content=? WHERE iy_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, iy_state);
			ps.setString(2, iy_content);
			ps.setInt(3, iy_id);
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		return 0;
	}

	@Override
	public int deleteIndu(int iy_id) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "UPDATE industry SET iy_status=0 WHERE iy_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, iy_id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		return 0;
	}

	@Override
	public void ajaxState(int iy_id, int state) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "update industry set iy_state=? where iy_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, state);
			ps.setInt(2, iy_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		
	}

	@Override
	//行业信息新增
	public int addIndu(Industry indu) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "INSERT INTO industry VALUES(NULL,?,?,NULL,?,?,1,null,null)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, indu.getIy_title());
			ps.setString(2, indu.getIy_content());
			ps.setInt(3, indu.getIy_state());
			ps.setString(4, indu.getIy_updatetime());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		return 0;
	}

	@Override
	public List<Industry> exportExcel(String[] ids) {
		// TODO Auto-generated method stub
		try {
			getConn();
			StringBuffer sql = new StringBuffer("SELECT *,ur_name FROM industry indu INNER JOIN `user` u ON indu.iy_userId=u.ur_id WHERE iy_status=1 AND iy_id IN( ? ");
			for(int i=1;i<ids.length;i++){
				sql.append(",? ");
			}
			sql.append(")");
			ps = conn.prepareStatement(sql.toString());
			for(int i=0;i<ids.length;i++){
				int id = Integer.parseInt(ids[i]);
				ps.setInt(i+1,id);
			}
			//System.out.println(sql);
			res = ps.executeQuery();
			
			List<Industry> list = new ArrayList<Industry>();
			while(res.next()){
			    Industry indu = new Industry();
			    indu.setIy_id(res.getInt("iy_id"));
			    indu.setIy_title(res.getString("iy_title"));
			    indu.setIy_content(res.getString("iy_content"));
			    indu.setIy_userId(res.getInt("iy_userId"));
			    indu.setIy_updatetime(res.getString("iy_updatetime"));
			    indu.setIy_state(res.getInt("iy_state"));
			    //iy_other1用来存放作者姓名
			    indu.setIy_other1(res.getString("ur_name"));
			    
			    list.add(indu);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		return null;
	}
}

