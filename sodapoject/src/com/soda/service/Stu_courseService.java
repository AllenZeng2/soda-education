package com.soda.service;

import java.util.List;

import com.soda.entity.Course;
import com.soda.entity.PageInfo;
import com.soda.entity.Stu_course;
import com.soda.entity.Student;

public interface Stu_courseService {


	List<Stu_course> selectMohuMycourse(Course course, PageInfo pi);

	List<Stu_course> selectAllMyCourse(Student stu, PageInfo pi);
}

