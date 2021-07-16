package com.koreait.a.dto;

import java.sql.Date;


public class NoticeDTO {

	// field
	private long rn;
	private long no;
	private String writer;
	private String title;
	private String content;
	private Date postdate;
	private Date lastdate;
	private int hit;
	
	
	
	
	// Getter and Setter
	public long getRn() {
		return rn;
	}
	public void setRn(long rn) {
		this.rn = rn;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}

	
	
}
