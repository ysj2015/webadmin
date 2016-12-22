package com.ssh.bean;

import java.io.Serializable;
import java.util.List;

public class DataList implements java.io.Serializable{

	private int total;
	private List rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
