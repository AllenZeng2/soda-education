package com.soda.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soda.dao.BaseDao;
import com.soda.dao.CourseDao;
import com.soda.entity.Contact;
import com.soda.entity.Course;
import com.soda.entity.Industry;
import com.soda.entity.Information;
import com.soda.entity.News;
import com.soda.entity.Notice;
import com.soda.entity.PageInfo;
import com.soda.entity.User;

public class CourseDaoImpl extends BaseDao implements CourseDao {

	@Override
	public Contact SelectContact() {
		try {
			getConn();
			String sql = "SELECT * FROM contact WHERE ct_id=1";
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();

			if (res.next()) {
				Contact contact = new Contact();
				contact.setCt_id(res.getInt(1));
				contact.setCt_title(res.getString(2));
				contact.setCt_content(res.getString(3));
				contact.setCt_phone(res.getString(5));

				return contact;
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
	public List<Industry> selectIndustry() {
		try {
			getConn();
			String sql = "SELECT * FROM industry WHERE iy_state=1 LIMIT 0,6";
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();
			List<Industry> list = new ArrayList<Industry>();
			while (res.next()) {
				Industry industry = new Industry();

				industry.setIy_id(res.getInt(1));
				industry.setIy_title(res.getString(2));
				industry.setIy_content(res.getString(3));
				industry.setIy_state(res.getInt(5));
				industry.setIy_updatetime(res.getString(6));
				industry.setIy_status(res.getInt(7));

				list.add(industry);
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
	public List<News> selectNews() {
		try {
			getConn();
			String sql = "SELECT * FROM news WHERE ns_state=1 LIMIT 0,6";
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();
			List<News> list = new ArrayList<News>();
			while (res.next()) {

				News ns = new News();

				ns.setNs_id(res.getInt(1));
				ns.setNs_title(res.getString(2));
				ns.setNs_content(res.getString(3));
				ns.setNs_number(res.getInt(4));
				ns.setNs_showtime(res.getString(5));
				ns.setNs_state(res.getInt(6));

				list.add(ns);
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
	public List<Notice> selectNotice() {
		try {
			getConn();
			String sql = "SELECT * FROM information LIMIT 0,6";
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();

			List<Notice> list = new ArrayList<Notice>();
			while (res.next()) {

				Notice no = new Notice();

				no.setNe_id(res.getInt(1));
				no.setNe_title(res.getString(2));
				no.setNe_content(res.getString(3));

				list.add(no);
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
	public List<Information> selectInformation() {
		try {
			getConn();
			String sql = "SELECT * FROM information LIMIT 0,6";
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();

			List<Information> list = new ArrayList<Information>();
			while (res.next()) {

				Information infor = new Information();

				infor.setIn_id(res.getInt(1));
				infor.setIn_title(res.getString(2));
				infor.setIn_content(res.getString(3));

				list.add(infor);
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
	public List<Course> selectZaiCourse() {

		try {
			getConn();
			String sql = "SELECT * FROM course WHERE ce_type=2 LIMIT 0,6";
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();

			List<Course> list = new ArrayList<Course>();
			while (res.next()) {
				Course c = new Course();

				c.setCe_id(res.getInt(1));
				c.setCe_name(res.getString(2));
				list.add(c);
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
	public List<Course> selectXianCourse() {

		try {
			getConn();
			String sql = "SELECT * FROM course WHERE ce_type=1 LIMIT 0,6";
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();

			List<Course> list = new ArrayList<Course>();
			while (res.next()) {
				Course c = new Course();

				c.setCe_id(res.getInt(1));
				c.setCe_name(res.getString(2));
				list.add(c);
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
	public Course selestCourseById(int ce_id) {

		try {
			getConn();
			String sql = "SELECT * FROM course WHERE ce_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ce_id);

			res = ps.executeQuery();
			if (res.next()) {
				Course course = new Course(res.getInt(1), res.getString(2),
						res.getString(3), res.getInt(4), res.getInt(5),
						res.getInt(6), res.getDouble(7), res.getDate(8),
						res.getDate(9), res.getString(10), res.getInt(11),
						res.getString(12), res.getInt(13));
				return course;
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
	public int selectTotalCount() {

		try {
			getConn();
			String sql = "SELECT COUNT(1) FROM course WHERE ce_type=1";
			ps = conn.prepareStatement(sql);
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

	// 全查现场课程
	@Override
	public List<Course> selectXianchangServlet(PageInfo pi) {

		try {
			getConn();

			String sql = "SELECT * FROM course ce INNER JOIN USER us ON ce.ce_userId=us.ur_id where ce_type=1 limit ?,?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, (pi.getPageNum() - 1) * pi.getPageSize());
			ps.setInt(2, pi.getPageSize());

			res = ps.executeQuery();
			List<Course> list = new ArrayList<Course>();
			while (res.next()) {
				User u = new User();
				Course ce = new Course();

				ce.setCe_id(res.getInt(1));
				ce.setCe_name(res.getString(2));
				ce.setCe_address(res.getString(3));
				ce.setCe_type(res.getInt(4));
				ce.setCe_state(res.getInt(5));
				ce.setCe_userId(res.getInt(6));
				ce.setCe_money(res.getDouble(7));
				ce.setCe_opentime(res.getDate(8));
				ce.setCe_endtime(res.getDate(9));
				ce.setCe_easy(res.getString(12));
				u.setUr_name(res.getString(15));
				ce.setUser(u);
				list.add(ce);
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

	// 模糊查询现场课程
	@Override
	public List<Course> selectMohuCourse(Course course, PageInfo pi) {
		try {
			getConn();

			StringBuffer sql = new StringBuffer(
					"SELECT * FROM course ce INNER JOIN `user` us ON ce.ce_userId=us.ur_id where ce_status=1 and ce_type=1");
			if (course.getCe_name() != null && course.getCe_name().length() > 0) {
				sql.append(" and ce_name like ?");
			}
			sql.append("limit ?,?");

			ps = conn.prepareStatement(sql.toString());
			int param = 1;
			if (course.getCe_name() != null && course.getCe_name().length() > 0) {
				ps.setString(param++, "%" + course.getCe_name() + "%");				
			}
			ps.setInt(param++, (pi.getPageNum() - 1) * pi.getPageSize());
			ps.setInt(param, pi.getPageSize());

			res = ps.executeQuery();
			List<Course> list = new ArrayList<Course>();
			while (res.next()) {
				User u = new User();
				Course ce = new Course();

				ce.setCe_id(res.getInt(1));
				ce.setCe_name(res.getString(2));
				ce.setCe_address(res.getString(3));
				ce.setCe_type(res.getInt(4));
				ce.setCe_state(res.getInt(5));
				ce.setCe_userId(res.getInt(6));
				ce.setCe_money(res.getDouble(7));
				ce.setCe_opentime(res.getDate(8));
				ce.setCe_endtime(res.getDate(9));
				ce.setCe_easy(res.getString(12));
				u.setUr_name(res.getString(15));
				ce.setUser(u);
				list.add(ce);
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

	// 全查在线课程
	@Override
	public List<Course> selectZaixianCourse(PageInfo pi) {
		// TODO Auto-generated method stub
		try {
			getConn();
			String sql = "SELECT * FROM course ce INNER JOIN `user` us ON ce.ce_id=us.ur_id WHERE ce_type=2 limit ?,?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, (pi.getPageNum() - 1) * pi.getPageSize());
			ps.setInt(2, pi.getPageSize());
			res = ps.executeQuery();

			List<Course> list = new ArrayList<Course>();
			while (res.next()) {

				User u = new User();
				Course co = new Course();
				co.setCe_id(res.getInt(1));
				co.setCe_name(res.getString(2));
				co.setCe_address(res.getString(3));
				co.setCe_type(res.getInt(4));
				co.setCe_state(res.getInt(5));
				co.setCe_userId(res.getInt(6));
				co.setCe_money(res.getDouble(7));
				co.setCe_opentime(res.getDate(8));
				co.setCe_endtime(res.getDate(9));
				co.setCe_easy(res.getString(12));
				u.setUr_name(res.getString(15));
				co.setUser(u);

				list.add(co);
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
	
	//模糊查询在线课程
	@Override
	public List<Course> selectMohuZaixianCourse(Course course, PageInfo pi) {
		try {
			getConn();

			StringBuffer sql = new StringBuffer(
					"SELECT * FROM course ce INNER JOIN `user` us ON ce.ce_userId=us.ur_id where ce_status=1 and ce_type=2");
			if (course.getCe_name() != null && course.getCe_name().length() > 0) {
				sql.append(" and ce_name like ?");
			}
			sql.append(" limit ?,?");

			ps = conn.prepareStatement(sql.toString());
			int param = 1;
			if (course.getCe_name() != null && course.getCe_name().length() > 0) {
				ps.setString(param++, "%" + course.getCe_name() + "%");				
			}
			ps.setInt(param++, (pi.getPageNum() - 1) * pi.getPageSize());
			ps.setInt(param, pi.getPageSize());

			res = ps.executeQuery();
			List<Course> list = new ArrayList<Course>();
			while (res.next()) {
				User u = new User();
				Course ce = new Course();

				ce.setCe_id(res.getInt(1));
				ce.setCe_name(res.getString(2));
				ce.setCe_address(res.getString(3));
				ce.setCe_type(res.getInt(4));
				ce.setCe_state(res.getInt(5));
				ce.setCe_userId(res.getInt(6));
				ce.setCe_money(res.getDouble(7));
				ce.setCe_opentime(res.getDate(8));
				ce.setCe_endtime(res.getDate(9));
				ce.setCe_easy(res.getString(12));
				u.setUr_name(res.getString(15));
				ce.setUser(u);
				list.add(ce);
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
