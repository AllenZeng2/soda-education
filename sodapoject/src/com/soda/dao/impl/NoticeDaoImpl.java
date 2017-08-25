package com.soda.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soda.dao.BaseDao;
import com.soda.dao.NoticeDao;
import com.soda.entity.Notice;
import com.soda.entity.PageInfo;
import com.soda.entity.User;

public class NoticeDaoImpl extends BaseDao implements NoticeDao {
	
	
	public Notice selectNoticeById(int ne_id) {
		try {
			getConn();
			String sql = "SELECT * FROM notice ne INNER JOIN `user` ur ON ne_userId=ur_id WHERE ne_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ne_id);
			res = ps.executeQuery();
			if (res.next()) {
				
				Notice notice=new Notice();
				User u=new User();
				
				notice.setNe_id(res.getInt(1));
				notice.setNe_title(res.getString(2));
				notice.setNe_content(res.getString(3));
				notice.setNe_level(res.getInt(4));
				notice.setNe_updatetime(res.getString(5));
				notice.setNe_status(res.getInt(7));
				u.setUr_name(res.getString(11));
				notice.setUser(u);
				
				return notice;
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
	public List<Notice> conditionSelect(Notice ne, PageInfo pi) {
		// TODO Auto-generated method stub
		try {
			getConn();
			StringBuffer sql = new StringBuffer(
					"select * from notice where ne_status=1");
			if (ne.getNe_title() != null && ne.getNe_title().length() > 0) {

				sql.append(" and ne_title like ?");
			}
			if (ne.getNe_updatetime() != null
					&& ne.getNe_updatetime().length() > 0) {

				sql.append(" and ne_updatetime like ?");

			}
			if (ne.getNe_level() == 1 || ne.getNe_level() == 3 || ne.getNe_level() == 2) {

				sql.append(" and ne_level=?");
			}

			sql.append(" limit ?,?");
			int param = 1;
			ps = conn.prepareStatement(sql.toString());
			if (ne.getNe_title() != null && ne.getNe_title().length() > 0) {

				ps.setString(param++, "%" + ne.getNe_title() + "%");
			}
			if (ne.getNe_updatetime() != null
					&& ne.getNe_updatetime().length() > 0) {

				ps.setString(param++, "%" + ne.getNe_updatetime() + "%");
			}
			if (ne.getNe_level() == 1 || ne.getNe_level() == 3 || ne.getNe_level() == 2) {

				ps.setInt(param++, ne.getNe_level());
			}
			ps.setInt(param++, (pi.getPageNum() - 1) * pi.getPageSize());
			ps.setInt(param, pi.getPageSize());
			res = ps.executeQuery();
			List<Notice> list = new ArrayList<Notice>();
			while (res.next()) {

				Notice notice = new Notice();
				notice.setNe_id(res.getInt("ne_id"));
				notice.setNe_title(res.getString("ne_title"));
				notice.setNe_content(res.getString("ne_content"));
				notice.setNe_updatetime(res.getString("ne_updatetime"));
				notice.setNe_level(res.getInt("ne_level"));

				list.add(notice);

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

	@Override
	public int conditionCount(Notice ne) {
		// TODO Auto-generated method stub
		try {
			getConn();
			StringBuffer sql = new StringBuffer(
					"select count(1) from notice where ne_status=1");
			if (ne.getNe_title() != null && ne.getNe_title().length() > 0) {

				sql.append(" and ne_title like ?");
			}
			if (ne.getNe_updatetime() != null
					&& ne.getNe_updatetime().length() > 0) {

				sql.append(" and ne_updatetime like ?");

			}
			int param = 1;
			ps = conn.prepareStatement(sql.toString());
			if (ne.getNe_title() != null && ne.getNe_title().length() > 0) {

				ps.setString(param++, "%" + ne.getNe_title() + "%");
			}
			if (ne.getNe_updatetime() != null
					&& ne.getNe_updatetime().length() > 0) {

				ps.setString(param++, "%" + ne.getNe_updatetime() + "%");
			}
			res = ps.executeQuery();
			if (res.next()) {
				return res.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}
		return 0;
	}

	@Override
	public int deleteNotice(int ne_id) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql="update notice set ne_status=? where ne_status=1 and ne_id=?";
			//String sql="delete from news where ns_status=1 and ns_id=?";
			
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, 0);
			ps.setInt(2, ne_id);
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
	public Notice etNoticeWithId(int ne_id) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql="SELECT * FROM notice `ne` INNER JOIN `user` ur ON ne.ne_userId=ur.ur_id WHERE ne_status=1 and ne.ne_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ne_id);
			
			res=ps.executeQuery();
		
			
			if(res.next()){
				Notice notice=new Notice();
				
				notice.setNe_id(res.getInt("ne_id"));
				notice.setNe_title(res.getString("ne_title"));
				notice.setNe_content(res.getString("ne_content"));
				notice.setNe_level(res.getInt("ne_level"));
				notice.setNe_other1(res.getString("ur_name"));
				notice.setNe_updatetime(res.getString("ne_updatetime"));
				return notice;
				
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
	public int submitNotice(Notice notice) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql="update notice set ne_title=?, ne_other1=?, ne_level=?,ne_content=? where ne_status=1 and ne_id=?";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,notice.getNe_title());
			ps.setString(2,notice.getNe_other1());
			ps.setInt(3,notice.getNe_level());
			ps.setString(4,notice.getNe_content());
			ps.setInt(5,notice.getNe_id());
			
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
	public int addNotice(Notice notice) {
		// TODO Auto-generated method stub
		try {
			getConn();
						
			String sql="insert into notice values(0,?,?,?,'2017-02-20 00:00:00',2,1,?,NULL)";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, notice.getNe_title());
			ps.setString(2,notice.getNe_content());
			ps.setInt(3,notice.getNe_level());
			ps.setString(4, notice.getNe_other1());
			
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

