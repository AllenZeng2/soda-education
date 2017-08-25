package com.soda.dao.impl;


import java.sql.SQLException;

import com.soda.dao.BaseDao;
import com.soda.dao.InformationDao;


import java.util.ArrayList;
import java.util.List;

import com.soda.entity.Information;
import com.soda.entity.News;
import com.soda.entity.User;

import com.soda.dao.*;

import com.soda.entity.PageInfo;


public class InformationDaoImpl extends BaseDao implements InformationDao{


	
	@Override
	public Information selectInformationById(int in_id) {
		try {
			getConn();
			String sql = "SELECT * FROM information `in` INNER JOIN `user` ur ON in_userId=ur_id WHERE in_state=1 AND in_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, in_id);

			res = ps.executeQuery();
			if (res.next()) {
				
				Information infor=new Information();
				User u=new User(); 
				
				infor.setIn_id(res.getInt(1));
				infor.setIn_title(res.getString(2));
				infor.setIn_content(res.getString(3));
				infor.setIn_state(res.getInt(4));
				infor.setIn_updatetime(res.getString(5));
				u.setUr_name(res.getString(11));
				infor.setUser(u);
				
				return infor;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}
		return null;
	}

	
	public List<Information> getinformation(Information in) {
		// TODO Auto-generated method stub
		try {
			getConn();
			StringBuffer sql=new StringBuffer("select * from information where in_status=1");
			if(in.getIn_title()!=null && in.getIn_title().length()>0){
				sql.append(" and in_title like ?");
			}
			if(in.getIn_updatetime()!=null && in.getIn_updatetime().length()>0){
				sql.append(" and in_updatetime like ?");
			}
			int param=1;
			ps=conn.prepareStatement(sql.toString());
			if(in.getIn_title()!=null && in.getIn_title().length()>0){
				ps.setString(1, "%"+in.getIn_title()+"%");
			}
			if(in.getIn_updatetime()!=null && in.getIn_updatetime().length()>0){
				ps.setString(2, "%"+in.getIn_updatetime()+"%");
			}
			res=ps.executeQuery();
			List<Information> list=new ArrayList<Information>();
			
			while(res.next()){
				
				Information information=new Information();
				information.setIn_id(res.getInt("in_id"));
				information.setIn_title(res.getString("in_title"));
				information.setIn_content(res.getString("in_content"));
				information.setIn_updatetime(res.getString("in_updatetime"));
				information.setIn_state(res.getInt("in_state"));
				
				list.add(in);
				
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


	public List<Information> conditionSelect(Information in, PageInfo pi) {
		// TODO Auto-generated method stub
		try {
			getConn();
			StringBuffer sql=new StringBuffer("select * from information where in_status=1");
			if(in.getIn_title()!=null && in.getIn_title().length()>0){
				
				sql.append(" and in_title like ?");
			}
			if(in.getIn_updatetime()!=null && in.getIn_updatetime().length()>0){
				
				sql.append(" and in_updatetime like ?");
				
			}
			if(in.getIn_state()==1 || in.getIn_state()==0){
				
				sql.append(" and in_state=?");
			}
			
			sql.append(" limit ?,?");
			int param=1;
			ps=conn.prepareStatement(sql.toString());
			if(in.getIn_title()!=null && in.getIn_title().length()>0){
				
				ps.setString(param++, "%"+in.getIn_title()+"%");
			}
			if(in.getIn_updatetime()!=null && in.getIn_updatetime().length()>0){
				
				ps.setString(param++, "%"+in.getIn_updatetime()+"%");
			}
			if(in.getIn_state()==1 || in.getIn_state()==0){
				
				ps.setInt(param++, in.getIn_state());
			}
			ps.setInt(param++,(pi.getPageNum()-1)*pi.getPageSize());
			ps.setInt(param,pi.getPageSize());
			res=ps.executeQuery();
			List<Information> list=new ArrayList<Information>();
			
			while(res.next()){
				
				Information information=new Information();
				information.setIn_id(res.getInt("in_id"));
				information.setIn_title(res.getString("in_title"));
				information.setIn_content(res.getString("in_content"));
				information.setIn_updatetime(res.getString("in_updatetime"));
				information.setIn_state(res.getInt("in_state"));
				
				list.add(information);
				
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


	public int conditionCount(Information in) {
		// TODO Auto-generated method stub
		try {
			getConn();
			StringBuffer sql=new StringBuffer("select count(1) from information where in_status=1");
			if(in.getIn_title()!=null && in.getIn_title().length()>0){
				
				sql.append(" and in_title like ?");
			}
			if(in.getIn_updatetime()!=null && in.getIn_updatetime().length()>0){
				
				sql.append(" and in_updatetime like ?");
				
			}
			int param=1;
			ps=conn.prepareStatement(sql.toString());
			if(in.getIn_title()!=null && in.getIn_title().length()>0){
				
				ps.setString(param++, "%"+in.getIn_title()+"%");
			}
			if(in.getIn_updatetime()!=null && in.getIn_updatetime().length()>0){
				
				ps.setString(param++, "%"+in.getIn_updatetime()+"%");
			}
			res=ps.executeQuery();
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


	public int deleteInformation(int in_id) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql="update information set in_status=? where in_status=1 and in_id=?";
			//String sql="delete from news where ns_status=1 and ns_id=?";
			
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, 0);
			ps.setInt(2, in_id);
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		return 0;
	}


	public int updateState(int state, int id) {
		// TODO Auto-generated method stub
		try {
			getConn();
			System.out.println(state);
			if(state==1){
				String sql="update information set in_state=0 where in_status=1 and in_id=? and in_state=1";
				ps=conn.prepareStatement(sql);
				ps.setInt(1,id);
				return ps.executeUpdate();
			}
			if(state==0){
				String sql="update information set in_state=1 where in_status=1 and in_id=? and in_state=0";
				ps=conn.prepareStatement(sql);
				ps.setInt(1,id);
				return ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		return 0;
	}


	public Information getInformationWithId(int in_id) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql="SELECT * FROM information `in` INNER JOIN `user` ur ON in.in_userId=ur.ur_id WHERE in_status=1 and in.in_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, in_id);
			
			res=ps.executeQuery();
		
			
			if(res.next()){
				Information information=new Information();
				information.setIn_id(res.getInt("in_id"));
				information.setIn_title(res.getString("in_title"));
				information.setIn_content(res.getString("in_content"));
				information.setIn_state(res.getInt("in_state"));
				information.setIn_other1(res.getString("ur_name"));
				information.setIn_updatetime(res.getString("in_updatetime"));
				return information;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		
		return null;
	}


	public int submitInformation(Information information) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql="update information set in_title=?, in_other1=?, in_state=?,in_content=? where in_status=1 and in_id=?";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,information.getIn_title());
			ps.setString(2,information.getIn_other1());
			ps.setInt(3,information.getIn_state());
			ps.setString(4,information.getIn_content());
			ps.setInt(5,information.getIn_id());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		return 0;
	}


	public int addInformation(Information information) {
		// TODO Auto-generated method stub
		try {
			getConn();
						
			String sql="insert into information values(0,?,?,?,'2017-02-20 00:00:00',2,1,?,NULL)";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, information.getIn_title());
			ps.setString(2,information.getIn_content());
			ps.setInt(3,information.getIn_state());
			ps.setString(4, information.getIn_other1());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
		}
		return 0;
	}

}


