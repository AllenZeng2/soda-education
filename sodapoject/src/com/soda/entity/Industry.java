package com.soda.entity;

import java.util.Date;

public class Industry {
	private Integer iy_id;
	private String iy_title;
	private String iy_content;
	private Integer iy_userId;
	private Integer iy_state;
	private String iy_updatetime;
	private Integer iy_status;
	private String iy_other1;
	private String iy_other2;
	
	
	public Industry() {
		// TODO Auto-generated constructor stub
	}

	public Industry(Integer iy_id, String iy_title, String iy_content,
			Integer iy_userId, Integer iy_state, String iy_updatetime,
			Integer iy_status, String iy_other1, String iy_other2) {
		super();
		this.iy_id = iy_id;
		this.iy_title = iy_title;
		this.iy_content = iy_content;
		this.iy_userId = iy_userId;
		this.iy_state = iy_state;
		this.iy_updatetime = iy_updatetime;
		this.iy_status = iy_status;
		this.iy_other1 = iy_other1;
		this.iy_other2 = iy_other2;
	}

	public Integer getIy_id() {
		return iy_id;
	}

	public void setIy_id(Integer iy_id) {
		this.iy_id = iy_id;
	}

	public String getIy_title() {
		return iy_title;
	}

	public void setIy_title(String iy_title) {
		this.iy_title = iy_title;
	}

	public String getIy_content() {
		return iy_content;
	}

	public void setIy_content(String iy_content) {
		this.iy_content = iy_content;
	}

	public Integer getIy_userId() {
		return iy_userId;
	}

	public void setIy_userId(Integer iy_userId) {
		this.iy_userId = iy_userId;
	}

	public Integer getIy_state() {
		return iy_state;
	}

	public void setIy_state(Integer iy_state) {
		this.iy_state = iy_state;
	}

	public String getIy_updatetime() {
		return iy_updatetime;
	}

	public void setIy_updatetime(String iy_updatetime) {
		this.iy_updatetime = iy_updatetime;
	}

	public Integer getIy_status() {
		return iy_status;
	}

	public void setIy_status(Integer iy_status) {
		this.iy_status = iy_status;
	}

	public String getIy_other1() {
		return iy_other1;
	}

	public void setIy_other1(String iy_other1) {
		this.iy_other1 = iy_other1;
	}

	public String getIy_other2() {
		return iy_other2;
	}

	public void setIy_other2(String iy_other2) {
		this.iy_other2 = iy_other2;
	}
}

