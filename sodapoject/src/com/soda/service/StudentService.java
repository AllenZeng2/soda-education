package com.soda.service;

import com.soda.entity.Course;
import com.soda.entity.Student;

public interface StudentService {

	Student selectStudentByName(String ur_loginName);

	int updateContent(String content, int id);

	// AddMyCourse(int studentid, String ce_id);

	void addCourse(int stid, int parseInt);

	void addMoney(int parseInt, int parseInt2);
}

