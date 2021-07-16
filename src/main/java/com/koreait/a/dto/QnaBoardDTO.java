package com.koreait.a.dto;

public class QnaBoardDTO {
	private long No;
	private String id;
	private String content;
	private String postdate;
	private long groupord;
	private int groupno;
	private int depth;
	
	public long getNo() {
		return No;
	}
	public void setNo(long no) {
		No = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	public long getGroupord() {
		return groupord;
	}
	public void setGroupord(long groupord) {
		this.groupord = groupord;
	}
	public int getGroupno() {
		return groupno;
	}
	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	

}
