package com.soda.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soda.dao.BaseDao;
import com.soda.dao.Stu_courseDao;
import com.soda.entity.Course;
import com.soda.entity.PageInfo;
import com.soda.entity.Shopcar;
import com.soda.entity.Stu_course;
import com.soda.entity.Student;
import com.soda.entity.User;

public class Stu_courseDaoImpl extends BaseDao implements Stu_courseDao {

	//全查我的课程
	@Override
	public List<Stu_course> selectAllMyCourse(Student stu, PageInfo pi) {
		try {
			getConn();

			String sql = "SELECT * FROM stu_course stuc INNER JOIN student st ON stuc.stuId=st.st_id INNER JOIN course co ON stuc.cId=co.ce_id INNER JOIN `user` ur ON co.ce_userId=ur.ur_id limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (pi.getPageNum() - 1) * pi.getPageSize());
			ps.setInt(2, pi.getPageSize());
			res = ps.executeQuery();
			List<Stu_course> stuc = new ArrayList<Stu_course>();
			while (res.next()) {
				Stu_course stuco = new Stu_course();
				Student st = new Student();
				Course c = new Course();
				User u = new User();
				c.setCe_id(res.getInt(22));
				c.setCe_name(res.getString(23));
				c.setCe_type(res.getInt(25));
				c.setCe_easy(res.getString(33));
				u.setUr_name(res.getString(36));
				c.setUser(u);
				st.setSt_id(res.getInt(5));
				stuco.setStu(st);
				stuco.setCourse(c);
				stuc.add(stuco);
			}
			return stuc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}
		return null;
	}

	//模糊查询我的课程
	@Override
	public List<Stu_course> selectMohuMycourse(Course course, PageInfo pi) {
		try {
			getConn();
			StringBuffer sql = new StringBuffer(
					"SELECT * FROM stu_course stuc INNER JOIN student st ON stuc.stuId=st.st_id INNER JOIN course co ON stuc.cId=co.ce_id INNER JOIN `user` ur ON co.ce_userId=ur.ur_id");
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
			List<Stu_course> stucourse=new ArrayList<Stu_course>();
			while (res.next()) {				
				Stu_course stuco = new Stu_course();
				Student st = new Student();
				Course c = new Course();
				User u = new User();
				c.setCe_id(res.getInt(22));
				c.setCe_name(res.getString(23));
				c.setCe_type(res.getInt(25));
				c.setCe_easy(res.getString(33));
				u.setUr_name(res.getString(36));
				c.setUser(u);
				st.setSt_id(res.getInt(5));
				stuco.setStu(st);
				stuco.setCourse(c);
				stucourse.add(stuco);
			}
			return stucourse;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, res);
		}
		return null;
	}

}
