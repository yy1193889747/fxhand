package com.cyporj.model;

import java.util.List;

import javax.persistence.Entity;
@Entity
public class Page {

	private List list;    
	private int pageSize = 5;
	private int rowCount;
	private int totalPage;
	private int pageNo = 1; 
	private int prePageNo;
	private int nextPageNo; 
	private int firstNo = 1;
	private int lastNo;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getTotalPage() {
		
	totalPage=(this.rowCount % this.pageSize ==0? (rowCount / pageSize) : (rowCount/pageSize)+1);
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPrePageNo() {
		this.prePageNo=this.pageNo-1;
		if(this.prePageNo<this.getFirstNo()){			
			this.prePageNo=this.getFirstNo();
		
		}
		return prePageNo;
	}
	public void setPrePageNo(int prePageNo) {
		this.prePageNo = prePageNo;
	}
	public int getNextPageNo() {
		this.nextPageNo=this.pageNo+1;
		if(this.nextPageNo>this.getLastNo()){			
			this.nextPageNo=this.getLastNo();
		
		}
		return nextPageNo;
	}
	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}
	public int getFirstNo() {
		return firstNo;
	}
	public void setFirstNo(int firstNo) {
		this.firstNo = firstNo;
	}
	public int getLastNo() {
		this.lastNo=getTotalPage();
		return lastNo;
	}
	public void setLastNo(int lastNo) {
		this.lastNo = lastNo;
	}
	
	
}
