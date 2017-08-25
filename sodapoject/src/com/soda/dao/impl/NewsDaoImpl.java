package com.soda.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.soda.dao.BaseDao;
import com.soda.dao.NewsDao;
import com.soda.entity.Course;
import com.soda.entity.News;
import com.soda.entity.User;
import com.soda.entity.ConditionNews;
import com.soda.entity.Page;


public class NewsDaoImpl extends BaseDao implements NewsDao {


	public News selectNewsById(int ns_id) {
		try {
			getConn();
			String sql = "SELECT * FROM news ns INNER JOIN `user` ur ON ns_userId=ur_id WHERE ns_state=1 AND ns_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ns_id);

			res = ps.executeQuery();
			if (res.next()) {
				
				News news=new News();
				User u=new User();
				
				news.setNs_id(res.getInt(1));
				news.setNs_title(res.getString(2));
				news.setNs_content(res.getString(3));
				news.setNs_number(res.getInt(4));
				news.setNs_showtime(res.getString(5));
				news.setNs_state(res.getInt(6));
				news.setNs_status(res.getInt(8));
				u.setUr_name(res.getString(12));
				news.setUser(u);

				return news;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}
		return null;
	}

	public int DelNewsById(int id) {
		// TODO Auto-generated method stub

		try {
			getConn();
			String sql = "DELETE FROM news WHERE ns_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}

		return 0;
	}

	
	public int UpdateNewsById(int id, String content, int state) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "update news set ns_content=?,ns_state=? WHERE ns_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, state);
			ps.setInt(3, id);
			return ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}

		return 0;
	}

	
	public List<News> SelectNews(ConditionNews ct, Page p) {

		try {
			getConn();

			StringBuffer sql = new StringBuffer(
					"select * from news where ns_status=1");
			if (ct.getTitle() != null && ct.getTitle().length() > 0)
				sql.append(" and ns_title like ? ");
			if (ct.getDate() != null && ct.getDate().length() > 0)
				sql.append(" and ns_showtime like ?");
			if (ct.getState() == 0 || ct.getState() == 1)
				sql.append(" and ns_state=?");

			sql.append("  limit ?,?");

			ps = conn.prepareStatement(sql.toString());
			int param = 1;
			if (ct.getTitle() != null && ct.getTitle().length() > 0) {
				ps.setString(param, "%" + ct.getTitle() + "%");
				param++;
			}
			if (ct.getDate() != null && ct.getDate().length() > 0) {
				ps.setString(param, "%" + ct.getDate() + "%");
				param++;
			}
			if (ct.getState() == 0 || ct.getState() == 1) {
				ps.setInt(param, ct.getState());
				param++;

			}
			ps.setInt(param, (p.getPageNum() - 1) * p.getPageSize());
			param++;
			ps.setInt(param, p.getPageSize());
			res = ps.executeQuery();

			List<News> list = new ArrayList<News>();

			while (res.next()) {

				News n = new News(res.getInt(1), res.getString(2),
						res.getString(3), res.getInt(4), res.getString(5),
						res.getInt(6), 0, null, null);

				list.add(n);

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
	public int SelectCountNews(ConditionNews ct) {

		try {
			getConn();

			StringBuffer sql = new StringBuffer(
					"select count(1) from news where ns_status=1 ");
			if (ct.getTitle() != null && ct.getTitle().length() > 0)
				sql.append(" and ns_title like ? ");
			if (ct.getDate() != null)
				sql.append(" and ns_showtime like ?");
			if (ct.getState() == 0 || ct.getState() == 1)
				sql.append(" and ns_state=?");

			ps = conn.prepareStatement(sql.toString());
			int param = 1;
			if (ct.getTitle() != null && ct.getTitle().length() > 0) {
				ps.setString(param, "%" + ct.getTitle() + "%");
				param++;
			}
			if (ct.getDate() != null) {
				ps.setString(param, "%" + ct.getDate() + "%");
				param++;
			}
			if (ct.getState() == 0 || ct.getState() == 1) {
				ps.setInt(param, ct.getState());
				param++;

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

	public News SelectNewsByid(int id) {
		// TODO Auto-generated method stub

		try {
			getConn();
			String sql = "select *from news where ns_id=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			res = ps.executeQuery();

			if (res.next()) {
				News n = new News(res.getInt(1), res.getString(2),
						res.getString(3), res.getInt(4), res.getString(5),
						res.getInt(6), 0, null, null);

				return n;
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
	public int AddNews(String title, String author, int num, int state,
			String content) {

		try {
			getConn();
			String sql = "INSERT INTO news VALUE(0,?,?,?,'2000-00-00 00:00:00',?,1,1,?,null)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, num);
			ps.setInt(4, state);
			ps.setString(5, author);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}
		return 0;
	}

	@Override
	public int updateNewsById(int id, int state) {

		try {
			getConn();
			String sql = "UPDATE news SET ns_state=? WHERE ns_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, state);
			ps.setInt(2, id);

			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}

		return 0;
	}

	@Override
	public int updateStatusById(int id) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "update news set ns_status=2 WHERE ns_id=?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			return ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}

		return 0;
	}

	public News getNewsWithUser(int ns_id) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "SELECT * FROM news ns INNER JOIN `user` ur ON ns.ns_userId=ur.ur_id WHERE ns_status=1 and ns.ns_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ns_id);

			res = ps.executeQuery();

			if (res.next()) {

				News news = new News();
				news.setNs_id(res.getInt("ns_id"));
				news.setNs_title(res.getString("ns_title"));
				news.setNs_content(res.getString("ns_content"));
				news.setNs_state(res.getInt("ns_state"));
				news.setNs_other1(res.getString("ur_name"));
				return news;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}

		return null;
	}

	
	public String getNewsName(int userId) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "SELECT * FROM news ns INNER JOIN `user` ur ON ns.ns_userId=ur.ur_id WHERE ns_status=1 and ns.ns_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			res = ps.executeQuery();

			if (res.next()) {

				News news = new News();

				news.setNs_other1(res.getString("ur_name"));
				return news.getNs_other1();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}
		return null;
	}

}
