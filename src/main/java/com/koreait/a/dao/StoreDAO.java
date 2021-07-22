package com.koreait.a.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.a.dto.PageDTO;
import com.koreait.a.dto.StoreDTO;

@Repository
public interface StoreDAO {

	// 가게 목록
	public List<StoreDTO> storeList(PageDTO pageDTO);
	
	// 가게 목록 조회수
	public int storeHit(long storeNo);
	
	// 가게 목록 전체 갯수
	public int storeTotalCount();
	
	// 가게 등록
	public int storeInsert(StoreDTO storeDTO);
	
	// 가게 게시글 반환
	public StoreDTO storeView(long storeNo);
	
	// 가게 수정
	public int storeUpdate(StoreDTO storeDTO);
	
	// 가게 삭제
	public int storeDelete(long storeNo);
}
