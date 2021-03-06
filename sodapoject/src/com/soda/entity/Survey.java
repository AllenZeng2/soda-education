package com.soda.entity;

public class Survey {
	private Integer sy_id;
	private String sy_title;
	private String sy_content;
	private Integer sy_userId;
	private Integer sy_type;
	private Integer sy_status;
	private String sy_other1;
	private String sy_other2;
	public Survey() {
		super();
	}

	public Survey(Integer sy_id, String sy_title, String sy_content, Integer sy_userId, Integer sy_type, Integer sy_status, String sy_other1, String sy_other2) {
		this.sy_id = sy_id;
		this.sy_title = sy_title;
		this.sy_content = sy_content;
		this.sy_userId = sy_userId;
		this.sy_type = sy_type;
		this.sy_status = sy_status;
		this.sy_other1 = sy_other1;
		this.sy_other2 = sy_other2;
	}

	public void setSy_id(Integer sy_id) {
		this.sy_id = sy_id;
	}

	public Integer getSy_id(){
		return sy_id;
	}


	public void setSy_title(String sy_title) {
		this.sy_title = sy_title;
	}

	public String getSy_title(){
		return sy_title;
	}


	public void setSy_content(String sy_content) {
		this.sy_content = sy_content;
	}

	public String getSy_content(){
		return sy_content;
	}


	public void setSy_userId(Integer sy_userId) {
		this.sy_userId = sy_userId;
	}

	public Integer getSy_userId(){
		return sy_userId;
	}


	public void setSy_type(Integer sy_type) {
		this.sy_type = sy_type;
	}

	public Integer getSy_type(){
		return sy_type;
	}


	public void setSy_status(Integer sy_status) {
		this.sy_status = sy_status;
	}

	public Integer getSy_status(){
		return sy_status;
	}


	public void setSy_other1(String sy_other1) {
		this.sy_other1 = sy_other1;
	}

	public String getSy_other1(){
		return sy_other1;
	}


	public void setSy_other2(String sy_other2) {
		this.sy_other2 = sy_other2;
	}

	public String getSy_other2(){
		return sy_other2;
	}

}

