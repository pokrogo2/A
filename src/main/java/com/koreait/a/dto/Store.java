package com.koreait.a.dto;

public class Store {
	
	// field
	private long storeNo;
	private String owenerName;
	private String storeName;
	private String storeTel;
	private String storeCategori;
	private String storeTime;
	private String storeAddr;
	private String storeContent;
	private String storeMenu;
	private String storeSns;
	private int storeHit;
	private String filename1;
	private int storeTable;
	
	// constructor
	public Store() { }
	public Store(long storeNo, String owenerName, String storeName, String storeTel, String storeCategori,
			String storeTime, String storeAddr, String storeContent, String storeMenu, String storeSns, int storeHit,
			String filename1, int storeTable) {
		super();
		this.storeNo = storeNo;
		this.owenerName = owenerName;
		this.storeName = storeName;
		this.storeTel = storeTel;
		this.storeCategori = storeCategori;
		this.storeTime = storeTime;
		this.storeAddr = storeAddr;
		this.storeContent = storeContent;
		this.storeMenu = storeMenu;
		this.storeSns = storeSns;
		this.storeHit = storeHit;
		this.filename1 = filename1;
		this.storeTable = storeTable;
	}

	
	// getter, setter
	public long getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(long storeNo) {
		this.storeNo = storeNo;
	}
	public String getOwenerName() {
		return owenerName;
	}
	public void setOwenerName(String owenerName) {
		this.owenerName = owenerName;
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
	public String getStoreCategori() {
		return storeCategori;
	}
	public void setStoreCategori(String storeCategori) {
		this.storeCategori = storeCategori;
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
	public String getStoreMenu() {
		return storeMenu;
	}
	public void setStoreMenu(String storeMenu) {
		this.storeMenu = storeMenu;
	}
	public String getStoreSns() {
		return storeSns;
	}
	public void setStoreSns(String storeSns) {
		this.storeSns = storeSns;
	}
	public int getStoreHit() {
		return storeHit;
	}
	public void setStoreHit(int storeHit) {
		this.storeHit = storeHit;
	}
	public String getFilename1() {
		return filename1;
	}
	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}
	public int getStoreTable() {
		return storeTable;
	}
	public void setStoreTable(int storeTable) {
		this.storeTable = storeTable;
	}
	
	
	
	
	
	
	
	
	
	
}
