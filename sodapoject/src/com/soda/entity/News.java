package com.soda.entity;

import java.util.Date;

public class News {
	private Integer ns_id;
	private String ns_title;
	private String ns_content;
	private Integer ns_number;
	private String ns_showtime;
	private Integer ns_state;
	//private Integer ns_userId;
	private Integer ns_status;
	private String ns_other1;
	private String ns_other2;
	private User user;//user外键约束ns_userId;
	public News() {
		super();
	}
	public News(Integer ns_id, String ns_title, String ns_content,
			Integer ns_number, String ns_showtime, Integer ns_state,
			Integer ns_status, String ns_other1, String ns_other2) {
		super();
		this.ns_id = ns_id;
		this.ns_title = ns_title;
		this.ns_content = ns_content;
		this.ns_number = ns_number;
		this.ns_showtime = ns_showtime;
		this.ns_state = ns_state;
		this.ns_status = ns_status;
		this.ns_other1 = ns_other1;
		this.ns_other2 = ns_other2;
	}
	public News(Integer ns_id, String ns_title, String ns_content,
			Integer ns_number, String ns_showtime, Integer ns_state,
			Integer ns_status, String ns_other1, String ns_other2, User user) {
		super();
		this.ns_id = ns_id;
		this.ns_title = ns_title;
		this.ns_content = ns_content;
		this.ns_number = ns_number;
		this.ns_showtime = ns_showtime;
		this.ns_state = ns_state;
		this.ns_status = ns_status;
		this.ns_other1 = ns_other1;
		this.ns_other2 = ns_other2;
		this.user = user;
	}
	public Integer getNs_id() {
		return ns_id;
	}
	public void setNs_id(Integer ns_id) {
		this.ns_id = ns_id;
	}
	public String getNs_title() {
		return ns_title;
	}
	public void setNs_title(String ns_title) {
		this.ns_title = ns_title;
	}
	public String getNs_content() {
		return ns_content;
	}
	public void setNs_content(String ns_content) {
		this.ns_content = ns_content;
	}
	public Integer getNs_number() {
		return ns_number;
	}
	public void setNs_number(Integer ns_number) {
		this.ns_number = ns_number;
	}
	public String getNs_showtime() {
		return ns_showtime;
	}
	public void setNs_showtime(String ns_showtime) {
		this.ns_showtime = ns_showtime;
	}
	public Integer getNs_state() {
		return ns_state;
	}
	public void setNs_state(Integer ns_state) {
		this.ns_state = ns_state;
	}
	public Integer getNs_status() {
		return ns_status;
	}
	public void setNs_status(Integer ns_status) {
		this.ns_status = ns_status;
	}
	public String getNs_other1() {
		return ns_other1;
	}
	public void setNs_other1(String ns_other1) {
		this.ns_other1 = ns_other1;
	}
	public String getNs_other2() {
		return ns_other2;
	}
	public void setNs_other2(String ns_other2) {
		this.ns_other2 = ns_other2;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	

}

