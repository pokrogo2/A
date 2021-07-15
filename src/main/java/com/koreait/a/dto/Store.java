package com.koreait.a.dto;

public class Store {
	
	// field
		private long storeNo;
		private String storeName;
		private String storeTel;
		private String storeTime;
		private String storeAddr;
		private String storeContent;
		private int storeHit;	
		private int storeTable;

	// constructor
	public Store() { }
	public Store(long storeNo, String storeName, String storeTel, String storeTime, String storeAddr,
			String storeContent, int storeHit, int storeTable) {
		super();
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storeTel = storeTel;
		this.storeTime = storeTime;
		this.storeAddr = storeAddr;
		this.storeContent = storeContent;
		this.storeHit = storeHit;
		this.storeTable = storeTable;
	}



	public long getStoreNo() {
		return storeNo;
	}


	public void setStoreNo(long storeNo) {
		this.storeNo = storeNo;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getStoreTel() {
		return storeTel;
	}


	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}


	public String getStoreTime() {
		return storeTime;
	}


	public void setStoreTime(String storeTime) {
		this.storeTime = storeTime;
	}


	public String getStoreAddr() {
		return storeAddr;
	}


	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}


	public String getStoreContent() {
		return storeContent;
	}


	public void setStoreContent(String storeContent) {
		this.storeContent = storeContent;
	}


	public int getStoreHit() {
		return storeHit;
	}


	public void setStoreHit(int storeHit) {
		this.storeHit = storeHit;
	}


	public int getStoreTable() {
		return storeTable;
	}


	public void setStoreTable(int storeTable) {
		this.storeTable = storeTable;
	}
	
	
}
