package com.soda.entity;

import java.util.Date;

public class Contact {
	private Integer ct_id;
	private String ct_title;
	private String ct_content;
	private Integer ct_userId;
	private String ct_phone;
	private Date ct_time;
	private Integer ct_status;
	private String ct_other;
	private String ct_other2;

	public Contact() {
		super();
	}

	public Contact(Integer ct_id, String ct_title, String ct_content, Integer ct_userId, String ct_phone, Date ct_time, Integer ct_status, String ct_other, String ct_other2) {
		this.ct_id = ct_id;
		this.ct_title = ct_title;
		this.ct_content = ct_content;
		this.ct_userId = ct_userId;
		this.ct_phone = ct_phone;
		this.ct_time = ct_time;
		this.ct_status = ct_status;
		this.ct_other = ct_other;
		this.ct_other2 = ct_other2;
	}

	public void setCt_id(Integer ct_id) {
		this.ct_id = ct_id;
	}

	public Integer getCt_id(){
		return ct_id;
	}


	public void setCt_title(String ct_title) {
		this.ct_title = ct_title;
	}

	public String getCt_title(){
		return ct_title;
	}


	public void setCt_content(String ct_content) {
		this.ct_content = ct_content;
	}

	public String getCt_content(){
		return ct_content;
	}


	public void setCt_userId(Integer ct_userId) {
		this.ct_userId = ct_userId;
	}

	public Integer getCt_userId(){
		return ct_userId;
	}


	public void setCt_phone(String ct_phone) {
		this.ct_phone = ct_phone;
	}

	public String getCt_phone(){
		return ct_phone;
	}


	public void setCt_time(Date ct_time) {
		this.ct_time = ct_time;
	}

	public Date getCt_time(){
		return ct_time;
	}


	public void setCt_status(Integer ct_status) {
		this.ct_status = ct_status;
	}

	public Integer getCt_status(){
		return ct_status;
	}


	public void setCt_other(String ct_other) {
		this.ct_other = ct_other;
	}

	public String getCt_other(){
		return ct_other;
	}


	public void setCt_other2(String ct_other2) {
		this.ct_other2 = ct_other2;
	}

	public String getCt_other2(){
		return ct_other2;
	}

}

