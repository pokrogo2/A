package com.koreait.a.dto;

import lombok.Data;

@Data
public class SearchStoreQueryDTO {

	// field
	private int beginRecord;
	private int endRecord;
	private String zone;
	private String local;
	private String catg;
	private String query;
	
}

