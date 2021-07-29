package com.koreait.a.dto;

import java.sql.Date;

public class StoreResDTO {

	// field 
	private long resNo;
	private long storeNo;
	private long memberNo;
	private String resDate;
	private String resHours;
	private String resPeople;
	private String resNote;
	private Date resPostdate;

	
	// getter, setter
	public long getResNo() {
		return resNo;
	}
	public void setResNo(long resNo) {
		this.resNo = resNo;
	}
	public long getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(long storeNo) {
		this.storeNo = storeNo;
	}
	public long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(long memberNo) {
		this.memberNo = memberNo;
	}
	public String getResDate() {
		return resDate;
	}
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}
	public String getResHours() {
		return resHours;
	}
	public void setResHours(String resHours) {
		this.resHours = resHours;
	}
	public String getResPeople() {
		return resPeople;
	}
	public void setResPeople(String resPeople) {
		this.resPeople = resPeople;
	}
	public String getResNote() {
		return resNote;
	}
	public void setResNote(String resNote) {
		this.resNote = resNote;
	}
	public Date getResPostdate() {
		return resPostdate;
	}
	public void setResPostdate(Date resPostdate) {
		this.resPostdate = resPostdate;
	}
	
	
	
}
