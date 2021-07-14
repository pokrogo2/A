package com.koreait.a.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Store {

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
}
