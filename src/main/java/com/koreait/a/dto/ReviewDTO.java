package com.koreait.a.dto;

public class ReviewDTO {
	private String writer;
	private long no;
	private long score;
	private String content;
	private String filename;
	private long storeno;
	private String storename;
	private String storecategori;
	
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getStorecategori() {
		return storecategori;
	}
	public void setStorecategori(String storecategori) {
		this.storecategori = storecategori;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getStoreno() {
		return storeno;
	}
	public void setStoreno(long storeno) {
		this.storeno = storeno;
	}
	
	
}
