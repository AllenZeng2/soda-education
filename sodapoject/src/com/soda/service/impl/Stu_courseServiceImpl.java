package com.soda.service.impl;

import java.util.List;

import com.soda.dao.Stu_courseDao;
import com.soda.dao.impl.Stu_courseDaoImpl;
import com.soda.entity.Course;
import com.soda.entity.PageInfo;
import com.soda.entity.Stu_course;
import com.soda.entity.Student;
import com.soda.service.*;



public class Stu_courseServiceImpl implements Stu_courseService{
	
	private Stu_courseDao scd=new Stu_courseDaoImpl();
	
	@Override
	public List<Stu_course> selectAllMyCourse(Student stu, PageInfo pi) {
		// TODO Auto-generated method stub
		return scd.selectAllMyCourse(stu,pi);
	}
	
	@Override
	public List<Stu_course> selectMohuMycourse(Course course, PageInfo pi) {
		// TODO Auto-generated method stub
		return scd.selectMohuMycourse(course,pi);
	}
}

