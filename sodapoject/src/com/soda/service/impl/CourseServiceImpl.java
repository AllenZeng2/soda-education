package com.soda.service.impl;

import java.util.List;

import com.soda.dao.CourseDao;
import com.soda.dao.impl.CourseDaoImpl;
import com.soda.entity.Contact;
import com.soda.entity.Course;
import com.soda.entity.Industry;
import com.soda.entity.Information;
import com.soda.entity.News;
import com.soda.entity.Notice;
import com.soda.entity.PageInfo;
import com.soda.service.*;



public class CourseServiceImpl implements CourseService{
	
	private CourseDao cd=new CourseDaoImpl();
	
	
	
	//模糊查询在线课程
	@Override
	public List<Course> selectMohuZaixianCourse(Course course, PageInfo pi) {
		// TODO Auto-generated method stub
		return cd.selectMohuZaixianCourse(course, pi);
	}
	
	//模糊查询现场课程
	@Override
	public List<Course> selectMohuCourse(Course course, PageInfo pi) {
		// TODO Auto-generated method stub
		return cd.selectMohuCourse(course, pi);
	}

	@Override
	public int selectTotalCount() {
		// TODO Auto-generated method stub
		return cd.selectTotalCount();
	}
	@Override
	public List<Course> selectXianchangServlet(PageInfo pi) {
		// TODO Auto-generated method stub
		return cd.selectXianchangServlet(pi);
	}
	
	@Override
	public Course selestCourseById(int ce_id) {
		// TODO Auto-generated method stub
		return cd.selestCourseById(ce_id);
	}

	@Override
	public List<Course> selectZaixianCourse(PageInfo pi) {
		// TODO Auto-generated method stub
		return cd.selectZaixianCourse(pi);
	}
	@Override
	public List<Course> selectXianCourse() {
		// TODO Auto-generated method stub
		return cd.selectXianCourse();
	}
	@Override
	public List<Course> selectZaiCourse() {
		// TODO Auto-generated method stub
		return cd.selectZaiCourse();
	}
	@Override
	public List<Information> selectInformation() {
		// TODO Auto-generated method stub
		return cd.selectInformation();	
	}
	@Override
	public List<Notice> selectNotice() {
		// TODO Auto-generated method stub
		return cd.selectNotice();
	}
	@Override
	public List<News> selectNews() {
		// TODO Auto-generated method stub
		return cd.selectNews();
	}
	@Override
	public List<Industry> selectIndustry() {
		// TODO Auto-generated method stub
		return cd.selectIndustry();
	}
	
	@Override
	public Contact SelectContact() {
		// TODO Auto-generated method stub
		return cd.SelectContact();
	}
	
	
	
	
	
	
}

