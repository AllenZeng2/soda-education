package com.soda.entity;

import java.util.Date;

public class Course {
	private Integer ce_id;
	private String ce_name;
	private String ce_address;
	private Integer ce_type;
	private Integer ce_state;
	private Integer ce_userId;
	private Double ce_money;
	private Date ce_opentime;
	private Date ce_endtime;
	private String ce_video;
	private Integer ce_status;
	private String ce_easy;
	private Integer ce_phone;
	public User user;
	

	


	public Course(Integer ce_id, String ce_name, String ce_address,
			Integer ce_type, Integer ce_state, Integer ce_userId,
			Double ce_money, Date ce_opentime, Date ce_endtime,
			String ce_video, Integer ce_status, String ce_easy,
			Integer ce_phone, User user) {
		super();
		this.ce_id = ce_id;
		this.ce_name = ce_name;
		this.ce_address = ce_address;
		this.ce_type = ce_type;
		this.ce_state = ce_state;
		this.ce_userId = ce_userId;
		this.ce_money = ce_money;
		this.ce_opentime = ce_opentime;
		this.ce_endtime = ce_endtime;
		this.ce_video = ce_video;
		this.ce_status = ce_status;
		this.ce_easy = ce_easy;
		this.ce_phone = ce_phone;
		this.user = user;
	}


	public Course() {
		super();
	}

	
	public Course(Integer ce_id, String ce_name, Integer ce_type,
			Integer ce_state, Integer ce_userId, Double ce_money,
			Date ce_opentime, Date ce_endtime, String ce_video,
			Integer ce_status, String ce_easy, User user) {
		super();
		this.ce_id = ce_id;
		this.ce_name = ce_name;
		this.ce_type = ce_type;
		this.ce_state = ce_state;
		this.ce_userId = ce_userId;
		this.ce_money = ce_money;
		this.ce_opentime = ce_opentime;
		this.ce_endtime = ce_endtime;
		this.ce_video = ce_video;
		this.ce_status = ce_status;
		this.ce_easy = ce_easy;
		this.user = user;
	}


	public Course(Integer ce_id, String ce_name, String ce_address, Integer ce_type, Integer ce_state, Integer ce_userId, Double ce_money, Date ce_opentime, Date ce_endtime, String ce_video, Integer ce_status, String ce_easy, Integer ce_phone) {
		this.ce_id = ce_id;
		this.ce_name = ce_name;
		this.ce_address = ce_address;
		this.ce_type = ce_type;
		this.ce_state = ce_state;
		this.ce_userId = ce_userId;
		this.ce_money = ce_money;
		this.ce_opentime = ce_opentime;
		this.ce_endtime = ce_endtime;
		this.ce_video = ce_video;
		this.ce_status = ce_status;
		this.ce_easy = ce_easy;
		this.ce_phone = ce_phone;
	}

	public void setCe_id(Integer ce_id) {
		this.ce_id = ce_id;
	}

	public Integer getCe_id(){
		return ce_id;
	}


	public void setCe_name(String ce_name) {
		this.ce_name = ce_name;
	}

	public String getCe_name(){
		return ce_name;
	}


	public void setCe_address(String ce_address) {
		this.ce_address = ce_address;
	}

	public String getCe_address(){
		return ce_address;
	}


	public void setCe_type(Integer ce_type) {
		this.ce_type = ce_type;
	}

	public Integer getCe_type(){
		return ce_type;
	}


	public void setCe_state(Integer ce_state) {
		this.ce_state = ce_state;
	}

	public Integer getCe_state(){
		return ce_state;
	}


	public void setCe_userId(Integer ce_userId) {
		this.ce_userId = ce_userId;
	}

	public Integer getCe_userId(){
		return ce_userId;
	}


	public void setCe_money(Double ce_money) {
		this.ce_money = ce_money;
	}

	public Double getCe_money(){
		return ce_money;
	}


	public void setCe_opentime(Date ce_opentime) {
		this.ce_opentime = ce_opentime;
	}

	public Date getCe_opentime(){
		return ce_opentime;
	}


	public void setCe_endtime(Date ce_endtime) {
		this.ce_endtime = ce_endtime;
	}

	public Date getCe_endtime(){
		return ce_endtime;
	}


	public void setCe_video(String ce_video) {
		this.ce_video = ce_video;
	}

	public String getCe_video(){
		return ce_video;
	}


	public void setCe_status(Integer ce_status) {
		this.ce_status = ce_status;
	}

	public Integer getCe_status(){
		return ce_status;
	}


	public void setCe_easy(String ce_easy) {
		this.ce_easy = ce_easy;
	}

	public String getCe_easy(){
		return ce_easy;
	}


	public void setCe_phone(Integer ce_phone) {
		this.ce_phone = ce_phone;
	}

	public Integer getCe_phone(){
		return ce_phone;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	

}

