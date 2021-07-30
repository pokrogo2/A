package com.koreait.a.dto;

import lombok.Data;


public class SearchStoreQueryDTO {

	// field
	private int beginRecord;
	private int endRecord;
	private String zone;
	private String local;
	private String catg;
	private String query;
	public int getBeginRecord() {
		return beginRecord;
	}
	public void setBeginRecord(int beginRecord) {
		this.beginRecord = beginRecord;
	}
	public int getEndRecord() {
		return endRecord;
	}
	public void setEndRecord(int endRecord) {
		this.endRecord = endRecord;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getCatg() {
		return catg;
	}
	public void setCatg(String catg) {
		this.catg = catg;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	
	
}

