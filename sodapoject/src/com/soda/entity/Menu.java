package com.soda.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private Integer mu_id;
	private Integer mu_pid;
	private String mu_name;
	private String mu_url;
	private String mu_remark;
	private Integer mu_state;
	private Integer mu_status;
	private String mu_other1;
	private String mu_other2;
	private Fmenu fmenu;
	
	public Menu(Integer mu_id, Integer mu_pid, String mu_name, String mu_url,
			String mu_remark, Integer mu_state, Integer mu_status) {
		super();
		this.mu_id = mu_id;
		this.mu_pid = mu_pid;
		this.mu_name = mu_name;
		this.mu_url = mu_url;
		this.mu_remark = mu_remark;
		this.mu_state = mu_state;
		this.mu_status = mu_status;
	}

	public Menu(Integer mu_id, Integer mu_pid, String mu_name, String mu_url,
			String mu_remark, Integer mu_state, Integer mu_status,
			String mu_other1, String mu_other2, Fmenu fmenu) {
		super();
		this.mu_id = mu_id;
		this.mu_pid = mu_pid;
		this.mu_name = mu_name;
		this.mu_url = mu_url;
		this.mu_remark = mu_remark;
		this.mu_state = mu_state;
		this.mu_status = mu_status;
		this.mu_other1 = mu_other1;
		this.mu_other2 = mu_other2;
		this.fmenu = fmenu;
	}

	private List<Role> roles=new ArrayList<Role>();
	public Menu() {
		super();
	}

	public Menu(Integer mu_id, Integer mu_pid, String mu_name, String mu_url, String mu_remark, Integer mu_state, Integer mu_status, String mu_other1, String mu_other2) {
		this.mu_id = mu_id;
		this.mu_pid = mu_pid;
		this.mu_name = mu_name;
		this.mu_url = mu_url;
		this.mu_remark = mu_remark;
		this.mu_state = mu_state;
		this.mu_status = mu_status;
		this.mu_other1 = mu_other1;
		this.mu_other2 = mu_other2;
	}
	
	public Menu(Integer mu_id, Integer mu_pid, String mu_name, String mu_url,
			String mu_remark, Integer mu_state, Integer mu_status,
			String mu_other1, String mu_other2, List<Role> roles) {
		super();
		this.mu_id = mu_id;
		this.mu_pid = mu_pid;
		this.mu_name = mu_name;
		this.mu_url = mu_url;
		this.mu_remark = mu_remark;
		this.mu_state = mu_state;
		this.mu_status = mu_status;
		this.mu_other1 = mu_other1;
		this.mu_other2 = mu_other2;
		this.roles = roles;
	}

	public void setMu_id(Integer mu_id) {
		this.mu_id = mu_id;
	}

	public Integer getMu_id(){
		return mu_id;
	}


	public void setMu_pid(Integer mu_pid) {
		this.mu_pid = mu_pid;
	}

	public Integer getMu_pid(){
		return mu_pid;
	}


	public void setMu_name(String mu_name) {
		this.mu_name = mu_name;
	}

	public String getMu_name(){
		return mu_name;
	}


	public void setMu_url(String mu_url) {
		this.mu_url = mu_url;
	}

	public String getMu_url(){
		return mu_url;
	}


	public void setMu_remark(String mu_remark) {
		this.mu_remark = mu_remark;
	}

	public String getMu_remark(){
		return mu_remark;
	}


	public void setMu_state(Integer mu_state) {
		this.mu_state = mu_state;
	}

	public Integer getMu_state(){
		return mu_state;
	}


	public void setMu_status(Integer mu_status) {
		this.mu_status = mu_status;
	}

	public Integer getMu_status(){
		return mu_status;
	}


	public void setMu_other1(String mu_other1) {
		this.mu_other1 = mu_other1;
	}

	public String getMu_other1(){
		return mu_other1;
	}


	public void setMu_other2(String mu_other2) {
		this.mu_other2 = mu_other2;
	}

	public String getMu_other2(){
		return mu_other2;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Fmenu getFmenu() {
		return fmenu;
	}

	public void setFmenu(Fmenu fmenu) {
		this.fmenu = fmenu;
	}

	public void addMenu(Menu mu) {
		// TODO Auto-generated method stub
		
	}
	

}

