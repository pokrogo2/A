package com.koreait.a.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.a.dto.StoreResDTO;

@Repository
public interface ReservationDAO {

	// 예약 등록
	public int resInsert(StoreResDTO res);
	
	// 예약 등록 개수
	public int resTotalCount();
	
	// 예약 내역 보기
	public StoreResDTO resView(long resNo);
	
	// 예약 내역 보기
	public Long findResNoRecentlyInserted();
	
	//myPage조회
	public List<StoreResDTO> memberMyPage(Long memberNo);
	
	//삭제
	public int resDelete(Long resNo);
}
