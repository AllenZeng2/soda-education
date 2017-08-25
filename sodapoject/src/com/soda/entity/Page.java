package com.soda.entity;

public class Page {
	
	private int pageSize;
	private int pageNum;
	private int TotalNum;
	private int TotalSize;
	
	public Page() {
		// TODO Auto-generated constructor stub
	}

	public Page(int pageSize, int pageNum, int totalNum, int totalSize) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		TotalNum = totalNum;
		TotalSize = totalSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalNum() {
		return TotalNum;
	}

	public void setTotalNum(int totalNum) {
		TotalNum = totalNum;
	}

	public int getTotalSize() {
		return TotalSize;
	}

	public void setTotalSize(int totalSize) {
		TotalSize = totalSize;
	}
	

}
