package com.soda.dao;

import com.soda.entity.Course;
import com.soda.entity.Student;

public interface StudentDao {

	Student selectStudentByName(String ur_loginName);
	void addCourse(int stid, int p);
	void addMoney(int p1, int p2);

}
