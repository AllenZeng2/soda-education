package com.soda.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soda.dao.BaseDao;
import com.soda.dao.ShopcarDao;
import com.soda.entity.Course;
import com.soda.entity.PageInfo;
import com.soda.entity.Shopcar;
import com.soda.entity.User;

public class ShopcarDaoImpl extends BaseDao implements ShopcarDao{
	
	
	//全查未结算课程
	@Override
	public List<Shopcar> selectNoSettlement(PageInfo pi) {

		try {
			getConn();

			String sql = "SELECT * FROM shopcar sr INNER JOIN student st ON sr.sr_stu_id=st.st_id limit ?,?";		
		
			ps = conn.prepareStatement(sql);
		
			ps.setInt(1, (pi.getPageNum() - 1) * pi.getPageSize());
			ps.setInt(2, pi.getPageSize());

			res = ps.executeQuery();
			List<Shopcar> list=new ArrayList<Shopcar>();
			while (res.next()) {
				
				Shopcar sc=new Shopcar();
				sc.setSr_id(res.getInt(1));
				sc.setSr_coursename(res.getString(2));
				sc.setSr_courseteacher(res.getString(3));
				sc.setSr_coursetype(res.getInt(4));
				sc.setSr_courseabstract(res.getString(5));
				
				list.add(sc);			
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}
		return null;
	}
	
	//模糊查询未结算课程
	@Override
	public List<Shopcar> selectMohuNoSettlementCourse(Shopcar shopcar,
			PageInfo pi) {
		try {
			getConn();

			StringBuffer sql = new StringBuffer(
					"SELECT * FROM shopcar sr INNER JOIN student st ON sr.sr_stu_id=st.st_id where 1=1");		
			if(shopcar.getSr_coursename()!=null&&shopcar.getSr_coursename().length()>0){
				sql.append(" and sr_coursename like ?");
			}			
			sql.append(" limit ?,?");

			ps = conn.prepareStatement(sql.toString());
			int param = 1;
			if(shopcar.getSr_coursename()!=null&&shopcar.getSr_coursename().length()>0){
				ps.setString(param++, "%" + shopcar.getSr_coursename() + "%");	
			}
			
			ps.setInt(param++, (pi.getPageNum() - 1) * pi.getPageSize());
			ps.setInt(param, pi.getPageSize());

			res = ps.executeQuery();
			List<Shopcar> list=new ArrayList<Shopcar>();
			while (res.next()) {
				
				Shopcar sc=new Shopcar();
				sc.setSr_id(res.getInt(1));
				sc.setSr_coursename(res.getString(2));
				sc.setSr_courseteacher(res.getString(3));
				sc.setSr_coursetype(res.getInt(4));
				sc.setSr_courseabstract(res.getString(5));
				
				list.add(sc);			
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}
		return null;
	}
}
