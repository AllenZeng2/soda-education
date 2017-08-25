package com.soda.entity;

import java.util.ArrayList;
import java.util.List;

public class Role {
	private Integer re_id;
	private String re_name;
	private Integer re_state;
	private String re_remark;
	private Integer re_status;
	private String re_other1;
	private String re_other2;
	private List<User> users=new ArrayList<User>();
	private List<Menu> menus=new ArrayList<Menu>();
	private List<Fmenu> fmenu=new ArrayList<Fmenu>();
	public Role() {
		super();
	}

	public Role(Integer re_id, String re_name, Integer re_state,
			String re_remark, Integer re_status, String re_other1,
			String re_other2, List<User> users, List<Menu> menus,
			List<Fmenu> fmenu) {
		super();
		this.re_id = re_id;
		this.re_name = re_name;
		this.re_state = re_state;
		this.re_remark = re_remark;
		this.re_status = re_status;
		this.re_other1 = re_other1;
		this.re_other2 = re_other2;
		this.users = users;
		this.menus = menus;
		this.fmenu = fmenu;
	}
	
	public Role(Integer re_id, String re_name, Integer re_state,
			String re_remark, Integer re_status) {
		super();
		this.re_id = re_id;
		this.re_name = re_name;
		this.re_state = re_state;
		this.re_remark = re_remark;
		this.re_status = re_status;
	}

	public Role(Integer re_id, String re_name, Integer re_state, String re_remark, Integer re_status, String re_other1, String re_other2) {
		this.re_id = re_id;
		this.re_name = re_name;
		this.re_state = re_state;
		this.re_remark = re_remark;
		this.re_status = re_status;
		this.re_other1 = re_other1;
		this.re_other2 = re_other2;
	}

	

	public Role(Integer re_id, String re_name, Integer re_state,
			String re_remark, Integer re_status, String re_other1,
			String re_other2, List<User> users, List<Menu> menus) {
		super();
		this.re_id = re_id;
		this.re_name = re_name;
		this.re_state = re_state;
		this.re_remark = re_remark;
		this.re_status = re_status;
		this.re_other1 = re_other1;
		this.re_other2 = re_other2;
		this.users = users;
		this.menus = menus;
	}

	public void setRe_id(Integer re_id) {
		this.re_id = re_id;
	}

	public Integer getRe_id(){
		return re_id;
	}


	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}

	public String getRe_name(){
		return re_name;
	}


	public void setRe_state(Integer re_state) {
		this.re_state = re_state;
	}

	public Integer getRe_state(){
		return re_state;
	}


	public void setRe_remark(String re_remark) {
		this.re_remark = re_remark;
	}

	public String getRe_remark(){
		return re_remark;
	}


	public void setRe_status(Integer re_status) {
		this.re_status = re_status;
	}

	public Integer getRe_status(){
		return re_status;
	}


	public void setRe_other1(String re_other1) {
		this.re_other1 = re_other1;
	}

	public String getRe_other1(){
		return re_other1;
	}


	public void setRe_other2(String re_other2) {
		this.re_other2 = re_other2;
	}

	public String getRe_other2(){
		return re_other2;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<Fmenu> getFmenu() {
		return fmenu;
	}

	public void setFmenu(List<Fmenu> fmenu) {
		this.fmenu = fmenu;
	}
	
}

