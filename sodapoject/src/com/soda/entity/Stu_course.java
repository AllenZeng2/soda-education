package com.soda.entity;

public class Stu_course {
	private Student stu;//外键来自student表的stuId
	private Course course;//外键来自course表的cId
	private String ps;
	private String other2;
	
	public Stu_course() {
		super();
	}

	public Stu_course(Student stu, Course course, String ps, String other2) {
		super();
		this.stu = stu;
		this.course = course;
		this.ps = ps;
		this.other2 = other2;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getOther2() {
		return other2;
	}

	public void setOther2(String other2) {
		this.other2 = other2;
	}
	
	

}

