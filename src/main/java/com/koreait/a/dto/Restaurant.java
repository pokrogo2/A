package com.koreait.a.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Restaurant {

	private long storeNo;
	private String owenerName;
	private String storeName;
	private String storeTEL;
	private String storeCategori;
	private String storeTime;
	private String storeAddr;
	private String storeContent;
	private String storeMenu;
	private String storeSns;
	private String filename1;
	private int storeTable;
}
