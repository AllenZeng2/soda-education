package com.soda.entity;

import java.util.Date;

public class ConditionNews {
	private String title;
	private String date;
	private int state;
	public ConditionNews() {
		// TODO Auto-generated constructor stub
	}
	public ConditionNews(String title, String date, int state) {
		super();
		this.title = title;
		this.date = date;
		this.state = state;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	

}
