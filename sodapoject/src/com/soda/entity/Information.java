package com.soda.entity;

import java.util.Date;

public class Information {
	private Integer in_id;
	private String in_title;
	private String in_content;
	private Integer in_state;
	private String in_updatetime;
	//private Integer in_userId;
	private Integer in_status;
	private String in_other1;
	private String in_other2;
	private User user;//user外键约束ns_userId;
	public Information() {
		super();
	}
	public Information(Integer in_id, String in_title, String in_content,
			Integer in_state, String in_updatetime, Integer in_status,
			String in_other1, String in_other2) {
		super();
		this.in_id = in_id;
		this.in_title = in_title;
		this.in_content = in_content;
		this.in_state = in_state;
		this.in_updatetime = in_updatetime;
		this.in_status = in_status;
		this.in_other1 = in_other1;
		this.in_other2 = in_other2;
	}
	public Information(Integer in_id, String in_title, String in_content,
			Integer in_state, String in_updatetime, Integer in_status,
			String in_other1, String in_other2, User user) {
		super();
		this.in_id = in_id;
		this.in_title = in_title;
		this.in_content = in_content;
		this.in_state = in_state;
		this.in_updatetime = in_updatetime;
		this.in_status = in_status;
		this.in_other1 = in_other1;
		this.in_other2 = in_other2;
		this.user = user;
	}
	public Integer getIn_id() {
		return in_id;
	}
	public void setIn_id(Integer in_id) {
		this.in_id = in_id;
	}
	public String getIn_title() {
		return in_title;
	}
	public void setIn_title(String in_title) {
		this.in_title = in_title;
	}
	public String getIn_content() {
		return in_content;
	}
	public void setIn_content(String in_content) {
		this.in_content = in_content;
	}
	public Integer getIn_state() {
		return in_state;
	}
	public void setIn_state(Integer in_state) {
		this.in_state = in_state;
	}
	public String getIn_updatetime() {
		return in_updatetime;
	}
	public void setIn_updatetime(String in_updatetime) {
		this.in_updatetime = in_updatetime;
	}
	public Integer getIn_status() {
		return in_status;
	}
	public void setIn_status(Integer in_status) {
		this.in_status = in_status;
	}
	public String getIn_other1() {
		return in_other1;
	}
	public void setIn_other1(String in_other1) {
		this.in_other1 = in_other1;
	}
	public String getIn_other2() {
		return in_other2;
	}
	public void setIn_other2(String in_other2) {
		this.in_other2 = in_other2;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

	

}

