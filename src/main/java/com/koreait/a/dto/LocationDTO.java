package com.koreait.a.dto;

import lombok.Data;


public class LocationDTO {

	// field
	private long locationNo;
	private String zone;
	private String local;
	
	
	public long getLocationNo() {
		return locationNo;
	}
	public void setLocationNo(long locationNo) {
		this.locationNo = locationNo;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	
	
}
