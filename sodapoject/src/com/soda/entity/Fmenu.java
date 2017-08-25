package com.soda.entity;

import java.util.ArrayList;
import java.util.List;

public class Fmenu {
	private Integer fmen_id;
	private	String fme_name;
	private String fme_remark;
	private Integer fme_state;
	private Integer fme_delete;
	private List<Menu> menu=new ArrayList<Menu>();
	public Fmenu() {
		super();
	}
	
	public Fmenu(Integer fmen_id, String fme_name, String fme_remark,
			Integer fme_state, Integer fme_delete, List<Menu> menu) {
		super();
		this.fmen_id = fmen_id;
		this.fme_name = fme_name;
		this.fme_remark = fme_remark;
		this.fme_state = fme_state;
		this.fme_delete = fme_delete;
		this.menu = menu;
	}

	public Fmenu(Integer fmen_id, String fme_name, String fme_remark,
			Integer fme_state, Integer fme_delete) {
		super();
		this.fmen_id = fmen_id;
		this.fme_name = fme_name;
		this.fme_remark = fme_remark;
		this.fme_state = fme_state;
		this.fme_delete = fme_delete;
	}
	public Integer getFmen_id() {
		return fmen_id;
	}
	public void setFmen_id(Integer fmen_id) {
		this.fmen_id = fmen_id;
	}
	public String getFme_name() {
		return fme_name;
	}
	public void setFme_name(String fme_name) {
		this.fme_name = fme_name;
	}
	public String getFme_remark() {
		return fme_remark;
	}
	public void setFme_remark(String fme_remark) {
		this.fme_remark = fme_remark;
	}
	public Integer getFme_state() {
		return fme_state;
	}
	public void setFme_state(Integer fme_state) {
		this.fme_state = fme_state;
	}
	public Integer getFme_delete() {
		return fme_delete;
	}
	public void setFme_delete(Integer fme_delete) {
		this.fme_delete = fme_delete;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	
	
}
