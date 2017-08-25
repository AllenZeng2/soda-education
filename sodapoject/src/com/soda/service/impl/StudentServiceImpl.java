package com.soda.service.impl;

import com.soda.dao.StudentDao;
import com.soda.dao.impl.StudentDaoImpl;
import com.soda.entity.Course;
import com.soda.entity.Student;
import com.soda.service.*;

public class StudentServiceImpl implements StudentService {
	private StudentDao sd = new StudentDaoImpl();

	public void addCourse(int stid, int p) {

		sd.addCourse(stid,p);

	}
	@Override
	public Student selectStudentByName(String ur_loginName) {
		// TODO Auto-generated method stub
		return sd.selectStudentByName(ur_loginName);
	}

	@Override
	public int updateContent(String content, int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void addMoney(int p1, int p2) {
		// TODO Auto-generated method stub
		sd.addMoney(p1, p2);
	}
}
