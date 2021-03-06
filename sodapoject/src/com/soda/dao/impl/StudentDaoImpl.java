package com.soda.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soda.dao.BaseDao;
import com.soda.dao.StudentDao;
import com.soda.entity.Course;
import com.soda.entity.Student;
import com.soda.entity.User;

public class StudentDaoImpl extends BaseDao implements StudentDao{

	
	//充值
	@Override
	public void addMoney(int p1, int p2) {
		try {
			getConn();
			String sql="UPDATE student SET st_money=? WHERE st_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, p2);
			ps.setInt(2, p1);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		
	}
	
	//单个购买后直接加入我的课程

	public void addCourse(int stid, int p) {
		try {
			getConn();
			String sql="INSERT INTO stu_course VALUES(?,?,null,null)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, stid);
			ps.setInt(2, p);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		
	}
	


	//根据名字查询
	@Override
	public Student selectStudentByName(String name) {
		try {
			getConn();
			String sql="SELECT * FROM student where st_loginName=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			res=ps.executeQuery();
			if(res.next()){
				Student st=new Student();
				st.setSt_id(res.getInt(1));
				st.setSt_name(res.getString(2));	
				st.setSt_loginName(res.getString(3));
				st.setSt_password(res.getString(4));
				st.setSt_sex(res.getInt(5));
				st.setSt_age(res.getInt(6));
				st.setSt_school(res.getString(7));
				st.setSt_idcard(res.getString(8));
				st.setSt_major(res.getString(9));
				st.setSt_phone(res.getString(10));
				st.setSt_address(res.getString(11));
				st.setSt_email(res.getString(12));
				st.setSt_remark(res.getString(13));
				st.setSt_money(res.getInt(14));
				st.setSt_status(res.getInt(15));

				return st;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn, ps, res);
			
		}
		return null;
	}
}
