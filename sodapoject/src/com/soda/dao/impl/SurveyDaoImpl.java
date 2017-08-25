package com.soda.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.soda.dao.BaseDao;
import com.soda.dao.SurveyDao;
import com.soda.entity.Survey;

public class SurveyDaoImpl extends BaseDao implements SurveyDao{

	@Override
	public List<Survey> selectSurvey() {
		try {
			getConn();
			String sql="SELECT * FROM survey";
			ps=conn.prepareStatement(sql);
			
			res=ps.executeQuery();
			List<Survey> list=new ArrayList<Survey>();
			
			while(res.next()){
				Survey sur=new Survey();
				sur.setSy_id(res.getInt(1));
				sur.setSy_title(res.getString(2));
				sur.setSy_content(res.getString(3));
				list.add(sur);
			
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	public Survey getSurvey(int id){
		try {
			getConn();
			String sql = "SELECT * FROM survey WHERE sy_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			res = ps.executeQuery();
			if(res.next()){
				Survey s = new Survey();
				s.setSy_id(res.getInt("sy_id"));
				s.setSy_title(res.getString("sy_title"));
				s.setSy_content(res.getString("sy_content"));
				s.setSy_type(res.getInt("sy_type"));
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	

	
	//���ݸ��
		public int updateContent(String content,int id) {
			try {
				getConn();
				String sql = "UPDATE survey SET sy_content=? WHERE sy_id=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, content);
				ps.setInt(2, id);
				return ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return 0;
			
			
		}




	@Override
	public int insertSurvey(String content) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//��Ȩ�����͹������ǣ���Ϣ��ѯ����Ҫ��ѯ����
	public Survey getSurveyWithUser(int id){
		try {
			getConn();
			String sql = "SELECT * FROM survey s INNER JOIN `user` u ON s.sy_userId=u.ur_id WHERE sy_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			res = ps.executeQuery();
			if(res.next()){
				Survey s = new Survey();
				s.setSy_title(res.getString("sy_title"));
				s.setSy_content(res.getString("sy_content"));
				//other1����������
				s.setSy_other1(res.getString("ur_name"));
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}	
		
		
		
		
		
		
		
		
		
		
		
}
