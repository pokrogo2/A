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
	
	// 가게 목록 전체 개수
	public int storeTotalCount();

	
	// 가게 목록 조회수
	public int storeHit(long storeNo);
	
	
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
	// 가게 keyup 검색
	public List<StoreDTO> autoComplete(StoreQueryDTO queryDTO);
	
	// 조회순, 등록순 검색
	public List<StoreDTO> searchOrder(PagingDTO pagingDTO);

	
	// 카테고리별 가게목록
	public List<StoreDTO> storeCateList(StoreQueryDTO queryDTO);
	
	// 카테고리별 가게목록 갯수
	public int storeCateTotalCount(String storyCategory);
	
	
	
	
	
}