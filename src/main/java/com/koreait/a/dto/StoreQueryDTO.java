package com.koreait.a.dto;

public class StoreQueryDTO {

	private String column;
	private String query;
	private String searchLineUp;
	private String storeCategory;
	private int beginRecord;
	private int endRecord;
	
	
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
	public String getSearchLineUp() {
		return searchLineUp;
	}
	public void setSearchLineUp(String searchLineUp) {
		this.searchLineUp = searchLineUp;
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
	public String getStoreCategory() {
		return storeCategory;
	}
	public void setStoreCategory(String storeCategory) {
		this.storeCategory = storeCategory;
	}
	
	
	
	
	
}
