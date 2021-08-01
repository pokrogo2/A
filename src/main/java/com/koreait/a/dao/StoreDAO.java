package com.koreait.a.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.a.dto.FBoardDTO;
import com.koreait.a.dto.FBoardQueryDTO;
import com.koreait.a.dto.PagingDTO;
import com.koreait.a.dto.StoreDTO;
import com.koreait.a.dto.StoreQueryDTO;

@Repository
public interface StoreDAO {

	// 가게 목록
	public List<StoreDTO> storeList(PagingDTO pagingDTO);
	
	// 가게 목록 조회수
	public int storeHit(long storeNo);
	
	// 가게 목록 전체 개수
	public int storeTotalCount();
	
	
	
	// 카테고리 가게 목록
	public List<StoreDTO> storeCateTotalCount(StoreQueryDTO queryDTO);
	
	// 카테고리 가게 목록 전체 개수
	public int storeCateTotalCount(String storyCategory);
	
	
	
	// 가게 등록
	
	public int storeInsert(StoreDTO storeDTO);
	 
	// 가게 내용 보기
	public StoreDTO storeView(long storeNo);
	
	// 가게 수정
	public int storeUpdate(StoreDTO storeDTO);
	
	// 가게 삭제
	public int storeDelete(long storeNo);
	
	// 가게 검색
	public List<StoreDTO> storeSearch(StoreQueryDTO queryDTO);
	public int storeSearchRecord(StoreQueryDTO queryDTO);
	// 가게 검색2
	public List<StoreDTO> autoComplete(StoreQueryDTO queryDTO);
	
	
	// 조회순, 등록순 가게 검색
	public List<StoreDTO> searchLineUp(StoreQueryDTO queryDTO);
	public int searchLineUpRecord(StoreQueryDTO queryDTO);

	
	
	
}