package com.soda.dao.impl;

import java.sql.SQLException;

import com.soda.dao.BaseDao;
import com.soda.dao.ContactDao;
import com.soda.entity.Contact;

public class ContactDaoImpl extends BaseDao implements ContactDao{
	public Contact getContact(){
		
		try {
			getConn();
			String sql="SELECT * FROM contact c INNER JOIN `user` u ON c.ct_userid=u.ur_id";
			ps=conn.prepareStatement(sql);
			res=ps.executeQuery();
			if(res.next()){
				Contact c=new Contact();
				c.setCt_id(res.getInt("ct_id"));
				c.setCt_title(res.getString("ct_title"));
				c.setCt_content(res.getString("ct_content"));
				c.setCt_phone(res.getString("ct_phone"));
				c.setCt_other(res.getString("ct_other"));
				
				return c;
			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return null;

}

	@Override
	public int updateContent(String phone, String content) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "UPDATE contact SET  ct_phone=?,ct_content=? WHERE ct_id=1";
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setString(2, content);
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
