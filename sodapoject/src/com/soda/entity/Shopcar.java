package com.soda.entity;

public class Shopcar {
	private Integer sr_id;
	private String sr_coursename;
	private String sr_courseteacher;
	private Integer sr_coursetype;
	private Double sr_courseprice;
	private String sr_courseabstract;
	private Integer sr_stu_id;
	private Integer sr_cs_id;
	private Integer sr_status;

	public Shopcar() {
		super();
	}

	public Shopcar(Integer sr_id, String sr_coursename, String sr_courseteacher, Integer sr_coursetype, Double sr_courseprice, String sr_courseabstract, Integer sr_stu_id, Integer sr_cs_id, Integer sr_status) {
		this.sr_id = sr_id;
		this.sr_coursename = sr_coursename;
		this.sr_courseteacher = sr_courseteacher;
		this.sr_coursetype = sr_coursetype;
		this.sr_courseprice = sr_courseprice;
		this.sr_courseabstract = sr_courseabstract;
		this.sr_stu_id = sr_stu_id;
		this.sr_cs_id = sr_cs_id;
		this.sr_status = sr_status;
	}

	public void setSr_id(Integer sr_id) {
		this.sr_id = sr_id;
	}

	public Integer getSr_id(){
		return sr_id;
	}


	public void setSr_coursename(String sr_coursename) {
		this.sr_coursename = sr_coursename;
	}

	public String getSr_coursename(){
		return sr_coursename;
	}


	public void setSr_courseteacher(String sr_courseteacher) {
		this.sr_courseteacher = sr_courseteacher;
	}

	public String getSr_courseteacher(){
		return sr_courseteacher;
	}


	public void setSr_coursetype(Integer sr_coursetype) {
		this.sr_coursetype = sr_coursetype;
	}

	public Integer getSr_coursetype(){
		return sr_coursetype;
	}


	public void setSr_courseprice(Double sr_courseprice) {
		this.sr_courseprice = sr_courseprice;
	}

	public Double getSr_courseprice(){
		return sr_courseprice;
	}


	public void setSr_courseabstract(String sr_courseabstract) {
		this.sr_courseabstract = sr_courseabstract;
	}

	public String getSr_courseabstract(){
		return sr_courseabstract;
	}


	public void setSr_stu_id(Integer sr_stu_id) {
		this.sr_stu_id = sr_stu_id;
	}

	public Integer getSr_stu_id(){
		return sr_stu_id;
	}


	public void setSr_cs_id(Integer sr_cs_id) {
		this.sr_cs_id = sr_cs_id;
	}

	public Integer getSr_cs_id(){
		return sr_cs_id;
	}


	public void setSr_status(Integer sr_status) {
		this.sr_status = sr_status;
	}

	public Integer getSr_status(){
		return sr_status;
	}

}

