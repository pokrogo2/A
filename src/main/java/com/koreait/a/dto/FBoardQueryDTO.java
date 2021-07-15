package com.koreait.a.dto;


public class FBoardQueryDTO {

	// field
	private String column;
	private String query;
	private String drop;
	private int beginRecord;
	private int endRecord;
	
	
	// constructor
	public FBoardQueryDTO() {}
	public FBoardQueryDTO(String column, String query, String drop, int beginRecord, int endRecord) {
		super();
		this.column = column;
		this.query = query;
		this.drop = drop;
		this.beginRecord = beginRecord;
		this.endRecord = endRecord;
	}
	
	// Getter and Setter
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getDrop() {
		return drop;
	}
	public void setDrop(String drop) {
		this.drop = drop;
	}
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
		
		
	
	
	
	
}
